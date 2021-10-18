package gui;

import gui.actions.RemoveAction;
import gui.actions.UpdateAction;

import javax.swing.*;

public class SGChangeMenu extends JPopupMenu {

    public SGChangeMenu(RemoveAction aRemoveAction, UpdateAction anUpdateAction) {
        JMenuItem updateButton = new JMenuItem("Обновить объект");
        JMenuItem removeButton = new JMenuItem("Удалить объект");

        add(updateButton);
        add(removeButton);

        updateButton.addActionListener(anUpdateAction);
        removeButton.addActionListener(aRemoveAction);
    }
}
