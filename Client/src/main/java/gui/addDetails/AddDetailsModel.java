package gui.addDetails;

import Interfaces.Relocatable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class AddDetailsModel extends JDialog implements Relocatable {

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
    private JLabel coordinateXText;
    private JLabel coordinateYText;
    private ResourceBundle addDetailsBundle;

    public AddDetailsModel(AddDetailsController addDetailsController) {
        setContentPane(mainPanel);
        setTitle("Fields setting");
        setModal(true);
        setSize(850, 500);
        setLocation(this);

        submitButton.addActionListener(e -> addDetailsController.addStudyGroup());
        switchLanguage(new Locale("en", "AU"));
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

    public void clearFields() {
        name.setText("");
        xCoordinate.setText("");
        yCoordinate.setText("");
        studentsCount.setText("");
        averageMark.setText("");
        groupAdminName.setText("");
        groupAdminWeight.setText("");
    }

    public void switchLanguage(Locale locale) {
        addDetailsBundle = ResourceBundle.getBundle("gui.bundles.AddDetailsLabels", locale);
        fillLabels();
    }

    private void fillLabels() {
        String name = addDetailsBundle.getString("name");
        String coordinates = addDetailsBundle.getString("coordinates");
        coordinateXText.setText(addDetailsBundle.getString("coordinateX"));
        coordinateYText.setText(addDetailsBundle.getString("coordinateY"));
        String studentsCount = addDetailsBundle.getString("studentsCount");
        String averageMark = addDetailsBundle.getString("averageMark");
        String formOfEducation = addDetailsBundle.getString("formOfEducation");
        String semester = addDetailsBundle.getString("semester");
        String groupAdmin = addDetailsBundle.getString("groupAdmin");
        String groupAdminName = addDetailsBundle.getString("groupAdminName");
        String groupAdminWeight = addDetailsBundle.getString("groupAdminWeight");
        String groupAdminHairColor = addDetailsBundle.getString("groupAdminHairColor");
        submitButton.setText(addDetailsBundle.getString("submit"));

        LineBorder roundedLineBorder = new LineBorder(Color.black, 1, true);
        TitledBorder nameTitledBorder = new TitledBorder(roundedLineBorder, name);
        TitledBorder coordinatesTitledBorder = new TitledBorder(roundedLineBorder, coordinates);
        TitledBorder studentsCountTitledBorder = new TitledBorder(roundedLineBorder, studentsCount);
        TitledBorder averageMarkTitledBorder = new TitledBorder(roundedLineBorder, averageMark);
        TitledBorder formOfEducationTitledBorder = new TitledBorder(roundedLineBorder, formOfEducation);
        TitledBorder semesterTitledBorder = new TitledBorder(roundedLineBorder, semester);
        TitledBorder groupAdminTitledBorder = new TitledBorder(roundedLineBorder, groupAdmin);
        TitledBorder groupAdminNameTitledBorder = new TitledBorder(roundedLineBorder, groupAdminName);
        TitledBorder groupAdminWeightTitledBorder = new TitledBorder(roundedLineBorder, groupAdminWeight);
        TitledBorder groupAdminHairColorTitledBorder = new TitledBorder(roundedLineBorder, groupAdminHairColor);

        namePanel.setBorder(nameTitledBorder);
        coordinatesPanel.setBorder(coordinatesTitledBorder);
        studentsCountPanel.setBorder(studentsCountTitledBorder);
        averageMarkPanel.setBorder(averageMarkTitledBorder);
        formOfEducationPanel.setBorder(formOfEducationTitledBorder);
        semesterPanel.setBorder(semesterTitledBorder);
        groupAdminPanel.setBorder(groupAdminTitledBorder);
        groupAdminNamePanel.setBorder(groupAdminNameTitledBorder);
        groupAdminWeightPanel.setBorder(groupAdminWeightTitledBorder);
        groupAdminHairColorPanel.setBorder(groupAdminHairColorTitledBorder);
    }
}