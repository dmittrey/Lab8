package Interfaces;

import java.awt.*;

public interface Relocatable {

    default void setLocation(Component component) {
        int width = component.getSize().width;
        int height = component.getSize().height;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        component.setLocation((screenSize.width / 2) - (width / 2), (screenSize.height / 2) - (height / 2));
    }
}