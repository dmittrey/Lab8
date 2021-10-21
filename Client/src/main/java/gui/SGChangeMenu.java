package gui;

import utility.Command;
import utility.CommandReader;
import utility.TypeOfCommand;

import javax.swing.*;

public class SGChangeMenu extends JPopupMenu {

    public SGChangeMenu(FrameHandler frameHandler, String sgId, int rowAtPoint, int columnAtPoint) {

        JMenuItem synchronize = new JMenuItem("Включить синхронизацию");
        JMenuItem updateButton = new JMenuItem("Обновить объект");
        JMenuItem removeButton = new JMenuItem("Удалить объект");
        JMenu sortButton = new JMenu("Сортировать");
        JMenuItem sortStraightButton = new JMenuItem("Прямо");
        JMenuItem sortBackButton = new JMenuItem("Реверсивно");
        JMenuItem filterButton = new JMenuItem("Отфильтровать");

        add(synchronize);
        add(updateButton);
        add(removeButton);
        add(sortButton);
        sortButton.add(sortStraightButton);
        sortButton.add(sortBackButton);
        add(filterButton);

        synchronize.addActionListener(e -> frameHandler.resumeSynchronize());

        updateButton.addActionListener(e -> {
            Command command = new Command(TypeOfCommand.Update, sgId);
            CommandReader.getInstance().execute(command);
        });

        removeButton.addActionListener(e -> {
            Command command = new Command(TypeOfCommand.Remove_by_id, sgId);
            CommandReader.getInstance().execute(command);
        });

        filterButton.addActionListener(e -> {
            SGTableModel.getInstance().filterField(rowAtPoint, columnAtPoint);
            frameHandler.stopSynchronize();
        });

        sortStraightButton.addActionListener(e -> {
            SGTableModel.getInstance().sortStraight(columnAtPoint);
            frameHandler.stopSynchronize();
        });

        sortBackButton.addActionListener(e -> {
            SGTableModel.getInstance().sortBack(columnAtPoint);
            frameHandler.stopSynchronize();
        });
    }
}