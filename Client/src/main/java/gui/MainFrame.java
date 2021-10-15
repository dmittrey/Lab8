package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setLocation() {
        int width = this.getSize().width;
        int height = this.getSize().height;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        this.setLocation((screenSize.width / 2) - (width / 2), (screenSize.height / 2) - (height / 2));
    }
}
