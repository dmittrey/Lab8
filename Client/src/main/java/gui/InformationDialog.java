package gui;

import javax.swing.*;
import java.awt.*;

public class InformationDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextArea informationArea;

    public InformationDialog() {
        setContentPane(contentPane);
        setTitle("Information");
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(500,300);
        setLocation();

        buttonOK.addActionListener(e -> dispose());
    }

    public void setInfo(String info){
        informationArea.setText(info);
    }

    public void setLocation(){
        int width = this.getSize().width;
        int height = this.getSize().height;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        this.setLocation((screenSize.width / 2) - (width / 2), (screenSize.height / 2) - (height / 2));
    }
}
