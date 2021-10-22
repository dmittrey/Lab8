package gui.informing;

import Interfaces.Relocatable;
import gui.LangChangeMenu;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

public class InformationDialogModel extends JDialog implements Relocatable {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextArea informationArea;
    private ResourceBundle informationDialogBundle;

    public InformationDialogModel() {
        setContentPane(contentPane);
        setTitle("Information");
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(500, 330);
        setLocation(this);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        buttonOK.addActionListener(e -> dispose());

        switchLanguage(new Locale("en", "AU"));
    }

    public void setInformationArea(String anInformation) {
        informationArea.setText(anInformation);
    }

    public void switchLanguage(Locale locale) {
        informationDialogBundle = ResourceBundle.getBundle("gui.bundles.InformationDialogLabels", locale);
        fillLabels();
    }

    private void fillLabels() {
        buttonOK.setText(informationDialogBundle.getString("ok"));
    }
}