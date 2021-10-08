package gui;

import javax.swing.*;

public class AddDetailsModel extends JFrame {
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
    private JButton addGroupButton;

    public AddDetailsModel() {
//        setTitle("Fields setter");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setContentPane(mainPanel);
//        pack();
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public static void main(String[] args) {
        JFrame jFrame = new AddDetailsModel();
        jFrame.setVisible(true);
    }
}
