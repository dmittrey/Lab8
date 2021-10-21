package gui;

import data.StudyGroup;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class SGTableModel extends AbstractTableModel {

    private List<String[]> data;
    private static SGTableModel instance;

    public static SGTableModel getInstance() {
        if (instance == null) instance = new SGTableModel();
        return instance;
    }

    private SGTableModel() {
        data = new ArrayList<>();
    }

    public void clearTable() {
        data.clear();
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "id";
            case 1:
                return "name";
            case 2:
                return "xCoordinate";
            case 3:
                return "yCoordinate";
            case 4:
                return "creationDate";
            case 5:
                return "studentsCount";
            case 6:
                return "averageMark";
            case 7:
                return "formOfEducation";
            case 8:
                return "semesterEnum";
            case 9:
                return "groupAdminName";
            case 10:
                return "groupAdminWeight";
            case 11:
                return "groupAdminHairColor";
            case 12:
                return "author";
        }
        return "";
    }

    public void addData(StudyGroup studyGroup) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String[] sg = new String[13];
        sg[0] = studyGroup.getId().toString();
        sg[1] = studyGroup.getName();
        sg[2] = studyGroup.getCoordinates().getX().toString();
        sg[3] = studyGroup.getCoordinates().getY().toString();
        sg[4] = formatter.format(studyGroup.getCreationDate());
        sg[5] = studyGroup.getStudentsCount().toString();
        if (studyGroup.getAverageMark() == null) {
            sg[6] = "null";
        } else sg[6] = studyGroup.getAverageMark().toString();
        if (studyGroup.getFormOfEducation() == null) {
            sg[7] = "null";
        } else sg[7] = studyGroup.getFormOfEducation().toString();
        sg[8] = studyGroup.getSemesterEnum().toString();
        sg[9] = studyGroup.getGroupAdmin().getName();
        sg[10] = studyGroup.getGroupAdmin().getWeight().toString();
        sg[11] = studyGroup.getGroupAdmin().getHairColor().toString();
        sg[12] = studyGroup.getAuthor();
        data.add(sg);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 13;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    public Map<String, String> getColumnFromIndex(int columnIndex) {
        HashMap<String, String> column = new HashMap<>();
        data.forEach(sg -> column.put(sg[columnIndex], sg[0]));
        return column;
    }

    public String[] getRowFromId(String sgId) {
        return data.stream()
                .filter(sg -> sg[0].equals(sgId))
                .findFirst()
                .orElse(null);
    }

    public void filterField(int rowIndex, int columnIndex) {
        String filterValue = (String) getValueAt(rowIndex, columnIndex);
        data = data.stream()
                .filter(sg -> sg[columnIndex].equals(filterValue))
                .collect(Collectors.toList());
        this.fireTableDataChanged();
    }

    public void sortStraight(int columnIndex) {
        Map<String, String> column = getColumnFromIndex(columnIndex);
        switch (columnIndex) {
            //Integer
            case 2:
            case 5:
                data = data.stream()
                        .map(sg -> sg[columnIndex])
                        .map(Integer::parseInt)
                        .sorted(Integer::compareTo)
                        .map(String::valueOf)
                        .map(column::get)
                        .map(this::getRowFromId)
                        .collect(Collectors.toList());
                this.fireTableDataChanged();
                break;
            //Double
            case 3:
            case 6:
                data = data.stream()
                        .map(sg -> sg[columnIndex])
                        .map(Double::parseDouble)
                        .sorted(Double::compareTo)
                        .map(String::valueOf)
                        .map(column::get)
                        .map(this::getRowFromId)
                        .collect(Collectors.toList());
                this.fireTableDataChanged();
                break;
            //Long
            case 10:
                data = data.stream()
                        .map(sg -> sg[columnIndex])
                        .map(Long::parseLong)
                        .sorted(Long::compareTo)
                        .map(String::valueOf)
                        .map(column::get)
                        .map(this::getRowFromId)
                        .collect(Collectors.toList());
                this.fireTableDataChanged();
                break;
            //String
            default:
                data = data.stream()
                        .map(sg -> sg[columnIndex])
                        .sorted()
                        .map(column::get)
                        .map(this::getRowFromId)
                        .collect(Collectors.toList());
                this.fireTableDataChanged();
                break;
        }
    }

    public void sortBack(int columnIndex) {
        sortStraight(columnIndex);
        Collections.reverse(data);
        this.fireTableDataChanged();
    }
}