package gui;

import data.*;
import data.Color;
import utility.Command;
import utility.CommandReader;

import javax.swing.*;
import java.awt.*;

public class AddDetailsModel extends JDialog {

    private Command command;
    private JPanel mainPanel;
    private JPanel namePanel;
    private JTextField name;
    private JTextField nameWarn;
    private JPanel coordinatesPanel;
    private JTextField xCoordinate;
    private JTextField yCoordinate;
    private JTextField coordinateWarn;
    private JPanel studentsCountPanel;
    private JTextField studentsCount;
    private JTextField studentsCountWarn;
    private JPanel averageMarkPanel;
    private JTextField averageMark;
    private JTextField averageMarkWarn;
    private JPanel formOfEducationPanel;
    private JComboBox formOfEducation;
    private JPanel semesterPanel;
    private JComboBox semester;
    private JPanel groupAdminPanel;
    private JPanel groupAdminNamePanel;
    private JTextField groupAdminName;
    private JTextField groupAdminNameWarn;
    private JPanel groupAdminWeightPanel;
    private JTextField groupAdminWeightWarn;
    private JTextField groupAdminWeight;
    private JPanel groupAdminHairColorPanel;
    private JTextField groupAdminHairColorWarn;
    private JTextField groupAdminHairColor;
    private JButton submitButton;

    public AddDetailsModel(JFrame jFrame) {
        setContentPane(mainPanel);
        setTitle("Fields setting");
        setModal(true);
        pack();
        setLocation();

        submitButton.addActionListener(e -> {
            StudyGroup studyGroup = new StudyGroup(0,
                    name.getText(),
                    new Coordinates(Integer.parseInt(xCoordinate.getText()), Double.parseDouble(yCoordinate.getText())),
                    null,
                    Integer.parseInt(studentsCount.getText()),
                    Double.parseDouble(averageMark.getText()),
                    FormOfEducation.valueOf(formOfEducation.getItemAt(formOfEducation.getSelectedIndex()).toString()),
                    Semester.valueOf(semester.getItemAt(semester.getSelectedIndex()).toString()),
                    new Person(groupAdminName.getText(),
                            Long.parseLong(groupAdminWeight.getText()),
                            Color.valueOf(groupAdminHairColor.getText())
                    ));
//            aCommand.addStudyGroup(studyGroup);
//            CommandReader.getInstance().execute(aCommand);
            // FIXME: 16.10.2021 Надо сделать оичстку полей
            dispose();
        });
    }

    public void setLocation(){
        int width = this.getSize().width;
        int height = this.getSize().height;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        this.setLocation((screenSize.width / 2) - (width / 2), (screenSize.height / 2) - (height / 2));
    }
}
