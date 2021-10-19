package gui;

import javax.swing.*;
import java.awt.*;

public class MainDialog extends JDialog {
    public void setLocation() {
        int width = this.getSize().width;
        int height = this.getSize().height;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        this.setLocation((screenSize.width / 2) - (width / 2), (screenSize.height / 2) - (height / 2));
    }
}
