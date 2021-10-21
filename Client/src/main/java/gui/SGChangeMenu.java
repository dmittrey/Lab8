package gui;

import utility.Command;
import utility.CommandReader;
import utility.TypeOfCommand;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SGChangeMenu extends JPopupMenu {

    private String sgId;

    public SGChangeMenu(FrameHandler frameHandler, String sgId) {

        JMenuItem synchronize = new JMenuItem("Включить синхронизацию");
        JMenuItem updateButton = new JMenuItem("Обновить объект");
        JMenuItem removeButton = new JMenuItem("Удалить объект");
        JMenu sortButton = new SortMenu("Сортировать");
        JMenu filterButton = new FilterMenu("Отфильтровать");

        add(synchronize);
        add(updateButton);
        add(removeButton);
        add(sortButton);
        add(filterButton);

        synchronize.addActionListener(e -> {
            frameHandler.resumeSynchronize();
        });

        removeButton.addActionListener(e -> {
            Command command = new Command(TypeOfCommand.Remove_by_id, sgId);
            System.out.println(command);
            CommandReader.getInstance().execute(command);
        });
    }
}
