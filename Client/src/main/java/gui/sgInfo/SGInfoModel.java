package gui.sgInfo;

import data.StudyGroup;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class SGInfoModel extends JDialog {

    private JPanel mainPanel;
    private JPanel namePanel;
    private JTextField name;
    private JPanel coordinatesPanel;
    private JTextField xCoordinate;
    private JTextField yCoordinate;
    private JPanel studentsCountPanel;
    private JTextField studentsCount;
    private JPanel averageMarkPanel;
    private JTextField averageMark;
    private JPanel formOfEducationPanel;
    private JTextField formOfEducation;
    private JPanel semesterPanel;
    private JTextField semester;
    private JPanel groupAdminPanel;
    private JPanel groupAdminNamePanel;
    private JTextField groupAdminName;
    private JPanel groupAdminWeightPanel;
    private JTextField groupAdminWeight;
    private JPanel groupAdminHairColorPanel;
    private JButton okButton;
    private JTextField groupAdminHairColor;
    private JLabel coordinateXText;
    private JLabel coordinateYText;
    private ResourceBundle sgInfoBundle;

    public SGInfoModel() {
        setContentPane(mainPanel);
        setTitle("Fields setting");
        setModal(true);
        setSize(400, 550);

        okButton.addActionListener(e -> dispose());
        switchLanguage(new Locale("en", "AU"));
    }

    public void setFields(StudyGroup studyGroup){
        name.setText(studyGroup.getName());
        xCoordinate.setText(studyGroup.getCoordinates().getX().toString());
        yCoordinate.setText(studyGroup.getCoordinates().getY().toString());
        studentsCount.setText(studyGroup.getStudentsCount().toString());
        averageMark.setText(studyGroup.getAverageMark().toString());
        formOfEducation.setText(studyGroup.getFormOfEducation().toString());
        semester.setText(studyGroup.getSemesterEnum().toString());
        groupAdminName.setText(studyGroup.getGroupAdmin().getName());
        groupAdminWeight.setText(studyGroup.getGroupAdmin().getWeight().toString());
        groupAdminHairColor.setText(studyGroup.getGroupAdmin().getHairColor().toString());
    }

    public void switchLanguage(Locale locale) {
        sgInfoBundle = ResourceBundle.getBundle("gui.bundles.SGInfoLabels", locale);
        fillLabels();
    }

    private void fillLabels() {
        String name = sgInfoBundle.getString("name");
        String coordinates = sgInfoBundle.getString("coordinates");
        coordinateXText.setText(sgInfoBundle.getString("coordinateX"));
        coordinateYText.setText(sgInfoBundle.getString("coordinateY"));
        String studentsCount = sgInfoBundle.getString("studentsCount");
        String averageMark = sgInfoBundle.getString("averageMark");
        String formOfEducation = sgInfoBundle.getString("formOfEducation");
        String semester = sgInfoBundle.getString("semester");
        String groupAdmin = sgInfoBundle.getString("groupAdmin");
        String groupAdminName = sgInfoBundle.getString("groupAdminName");
        String groupAdminWeight = sgInfoBundle.getString("groupAdminWeight");
        String groupAdminHairColor = sgInfoBundle.getString("groupAdminHairColor");
        okButton.setText(sgInfoBundle.getString("ok"));

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