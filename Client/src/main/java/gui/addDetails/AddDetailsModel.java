package gui.addDetails;

import utility.Command;

import javax.swing.*;

public class AddDetailsModel extends JDialog {

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
        pack();

        submitButton.addActionListener(e -> aCommand.addStudyGroup(addDetailsController.addStudyGroup()));
    }

    public String getName() {
        return (name.getText().isEmpty()) ? null : name.getText();
    }

    public String getXCoordinate() {
        return (xCoordinate.getText().isEmpty()) ? null : xCoordinate.getText();
    }

    public String getYCoordinate() {
        return (yCoordinate.getText().isEmpty()) ? null : yCoordinate.getText();
    }

    public String getStudentsCount() {
        return (studentsCount.getText().isEmpty()) ? null : studentsCount.getText();
    }

    public String getAverageMark() {
        return (averageMark.getText().isEmpty()) ? null : averageMark.getText();
    }

    public String getFormOfEducation() {
        return formOfEducation.getItemAt(formOfEducation.getSelectedIndex());
    }

    public String getSemester() {
        return semester.getItemAt(semester.getSelectedIndex());
    }

    public String getGroupAdminName() {
        return (groupAdminName.getText().isEmpty()) ? null : groupAdminName.getText();
    }

    public String getGroupAdminWeight() {
        return (groupAdminWeight.getText().isEmpty()) ? null : groupAdminWeight.getText();
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