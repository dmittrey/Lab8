package gui;

import javax.swing.*;

public class SGChangeMenu extends JPopupMenu {

    JMenuItem updateButton;
    JMenuItem removeButton;

    public SGChangeMenu() {
        updateButton = new JMenuItem("Обновить объект");
        removeButton = new JMenuItem("Удалить объект");

        add(updateButton);
        add(removeButton);
    }
}
