package gui.visual;

import gui.*;
import utility.TypeOfCommand;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class VisualModel {
    private JPanel mainPanel;
    private JTextField usernameField;
    private JButton tableButton;
    private JScrollPane sgScrollPane;
    private JButton langButton;
    private ResourceBundle visualBundle;
    private static final Logger logger = Logger.getLogger(VisualModel.class.getName());

    public VisualModel(VisualController visualController, FrameHandler aFrameHandler) {
        langButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    new LangChangeMenu(visualController).show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        tableButton.addActionListener(e -> aFrameHandler.switchTable());
        switchLanguage(new Locale("en", "AU"));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setUsername(String username) {
        usernameField.setText(username);
    }

    public void switchLanguage(Locale locale) {
        visualBundle = ResourceBundle.getBundle("gui.bundles.VisualLabels", locale);
        fillLabels();
    }

    private void fillLabels() {
        langButton.setText(visualBundle.getString("language"));
        tableButton.setText(visualBundle.getString("tableMode"));
        String sgVisualTitle = visualBundle.getString("studyGroupVisual");

        LineBorder roundedLineBorder = new LineBorder(Color.black, 1, true);
        TitledBorder sgVisualTitledBorder = new TitledBorder(roundedLineBorder, sgVisualTitle);

        sgScrollPane.setBorder(sgVisualTitledBorder);
    }
}