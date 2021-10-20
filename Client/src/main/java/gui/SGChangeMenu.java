package gui;

import javax.swing.*;

public class SGChangeMenu extends JPopupMenu {

    public SGChangeMenu(FrameHandler frameHandler) {
        System.out.println(frameHandler);
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
            System.out.println("Нажали");
            System.out.println(frameHandler);
            frameHandler.resumeSynchronize();
        });
    }
}
