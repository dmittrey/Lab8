package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final int width = 800;
    private final int height = 460;

    public MainFrame() {
        super("Study groups");
        this.setSize(width, height);
        this.setMinimumSize(new Dimension(480, 440));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        this.setLocation((screenSize.width / 2) - width/4, (screenSize.height - height)/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
