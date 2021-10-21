package gui.informing;

import Interfaces.Relocatable;

import javax.swing.*;

public class InformationDialogModel extends JDialog implements Relocatable {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextArea informationArea;

    public InformationDialogModel() {
        setContentPane(contentPane);
        setTitle("Information");
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(500, 330);
        setLocation(this);

        buttonOK.addActionListener(e -> dispose());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public void setInformationArea(String anInformation) {
        informationArea.setText(anInformation);
    }
}