package gui;

import data.StudyGroup;
import utility.CommandManager;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Logger;

public class SGTableWorker extends AbstractTableModel {

    private final ArrayList<String[]> data;
    private static SGTableWorker instance;
    private static final Logger logger = Logger.getLogger(CommandManager.class.getName());

    public static SGTableWorker getInstance() {
        if (instance == null) instance = new SGTableWorker();
        return instance;
    }

    private SGTableWorker() {
        data = new ArrayList<>();
    }

    public void clearTable(){
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

    public boolean addData(StudyGroup studyGroup) {
        logger.info(studyGroup.getName() + " has been added!");
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
        return data.add(sg);
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
}
