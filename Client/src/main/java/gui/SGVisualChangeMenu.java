package gui;

import utility.Command;
import utility.CommandReader;
import utility.TypeOfCommand;

import javax.swing.*;

public class SGVisualChangeMenu extends JPopupMenu {

    public SGVisualChangeMenu(String sgId) {

        JMenuItem updateButton = new JMenuItem("Обновить объект");
        JMenuItem removeButton = new JMenuItem("Удалить объект");

        add(updateButton);
        add(removeButton);

        updateButton.addActionListener(e -> {
            Command command = new Command(TypeOfCommand.Update, sgId);
            CommandReader.getInstance().execute(command);
        });

        removeButton.addActionListener(e -> {
            Command command = new Command(TypeOfCommand.Remove_by_id, sgId);
            CommandReader.getInstance().execute(command);
        });
    }
}