package gui;

import utility.Command;
import utility.CommandReader;
import utility.TypeOfCommand;

import javax.swing.*;

public class SGChangeMenu extends JPopupMenu {

    public SGChangeMenu(FrameHandler frameHandler) {
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

        updateButton.addActionListener(e -> {
            Command command = new Command(TypeOfCommand.Update, null);

            CommandReader.getInstance().execute(command);
            SGTableWorker.getInstance().fireTableDataChanged();
        });

        removeButton.addActionListener(e -> {
            Command command = new Command(TypeOfCommand.Remove_by_id, null);
        });
    }
}
