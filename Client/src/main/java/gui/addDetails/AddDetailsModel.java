package gui.addDetails;

import Interfaces.Relocatable;
import utility.Command;

import javax.swing.*;

public class AddDetailsModel extends JDialog implements Relocatable {

    private Command command;
    private JPanel mainPanel;
    private JPanel namePanel;
    private JTextField name;
    private JTextField nameWarn;
    private JPanel coordinatesPanel;
    private JTextField xCoordinate;
    private JTextField yCoordinate;
    private JTextField xCoordinateWarn;
    private JPanel studentsCountPanel;
    private JTextField studentsCount;
    private JTextField studentsCountWarn;
    private JPanel averageMarkPanel;
    private JTextField averageMark;
    private JTextField averageMarkWarn;
    private JPanel formOfEducationPanel;
    private JComboBox<String> formOfEducation;
    private JPanel semesterPanel;
    private JComboBox<String> semester;
    private JPanel groupAdminPanel;
    private JPanel groupAdminNamePanel;
    private JTextField groupAdminName;
    private JTextField groupAdminNameWarn;
    private JPanel groupAdminWeightPanel;
    private JTextField groupAdminWeightWarn;
    private JTextField groupAdminWeight;
    private JPanel groupAdminHairColorPanel;
    private JButton submitButton;
    private JComboBox<String> groupAdminHairColor;
    private JTextField yCoordinateWarn;

    public AddDetailsModel(AddDetailsController addDetailsController, Command aCommand) {
        setContentPane(mainPanel);
        setTitle("Fields setting");
        setModal(true);
        setSize(850, 500);
        setLocation(this);

        submitButton.addActionListener(e -> aCommand.addStudyGroup(addDetailsController.addStudyGroup()));
    }

    public String getName() {
        return (name.getText().trim().isEmpty()) ? null : name.getText().trim();
    }

    public String getXCoordinate() {
        return (xCoordinate.getText().trim().isEmpty()) ? null : xCoordinate.getText().trim();
    }

    public String getYCoordinate() {
        return (yCoordinate.getText().trim().isEmpty()) ? null : yCoordinate.getText().trim();
    }

    public String getStudentsCount() {
        return (studentsCount.getText().trim().isEmpty()) ? null : studentsCount.getText().trim();
    }

    public String getAverageMark() {
        return (averageMark.getText().trim().isEmpty()) ? null : averageMark.getText().trim();
    }

    public String getFormOfEducation() {
        return formOfEducation.getItemAt(formOfEducation.getSelectedIndex());
    }

    public String getSemester() {
        return semester.getItemAt(semester.getSelectedIndex());
    }

    public String getGroupAdminName() {
        return (groupAdminName.getText().trim().isEmpty()) ? null : groupAdminName.getText().trim();
    }

    public String getGroupAdminWeight() {
        return (groupAdminWeight.getText().trim().isEmpty()) ? null : groupAdminWeight.getText().trim();
    }

    public String getGroupAdminHairColor() {
        return groupAdminHairColor.getItemAt(groupAdminHairColor.getSelectedIndex());
    }

    public void setNameWarn(String aNameWarn) {
        nameWarn.setText(aNameWarn);
    }

    public void setXCoordinateWarn(String aXCoordinateWarn) {
        xCoordinateWarn.setText(aXCoordinateWarn);
    }

    public void setYCoordinateWarn(String aYCoordinateWarn) {
        yCoordinateWarn.setText(aYCoordinateWarn);
    }

    public void setStudentsCountWarn(String aStudentsCountWarn) {
        studentsCountWarn.setText(aStudentsCountWarn);
    }

    public void setAverageMarkWarn(String anAverageMarkWarn) {
        averageMarkWarn.setText(anAverageMarkWarn);
    }

    public void setGroupAdminNameWarn(String aGroupAdminNameWarn) {
        groupAdminNameWarn.setText(aGroupAdminNameWarn);
    }

    public void setGroupAdminWeightWarn(String aGroupAdminWeightWarn) {
        groupAdminWeightWarn.setText(aGroupAdminWeightWarn);
    }
}