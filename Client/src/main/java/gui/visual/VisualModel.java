package gui.visual;

import gui.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

public class VisualModel extends JFrame {
    private JPanel mainPanel;
    private JTextField usernameField;
    private JButton tableButton;
    private JButton langButton;
    private JPanel visualPanel;
    private ResourceBundle visualBundle;

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

    public GraphicPanel getVisualPanel() {
        return (GraphicPanel) visualPanel;
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

        visualPanel.setBorder(sgVisualTitledBorder);
    }

    private void createUIComponents() {
        GraphicPanel graphicPanel = new GraphicPanel(this);
        visualPanel = graphicPanel;
        visualPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int width = visualPanel.getWidth();
                int height = visualPanel.getHeight();
                int x1 = e.getX() - width / 2;
                int y1 = e.getY() - height / 2;
                SGIcon sgIconInFocus = graphicPanel.getPaintedGroups().stream()
                        .filter(sgIcon -> sgIcon.include(x1, y1))
                        .findFirst()
                        .orElse(null);
                if (sgIconInFocus != null) System.out.println(sgIconInFocus.getStudyGroup().getName());
            }
        });
    }
}