package gui;

import javax.swing.*;

public class SGChangeMenu extends JPopupMenu {

    public SGChangeMenu() {
        JMenuItem updateButton = new JMenuItem("Обновить объект");
        JMenuItem removeButton = new JMenuItem("Удалить объект");
        JMenu sortButton = new SortMenu("Сортировать");
        JMenu filterButton = new FilterMenu("Отфильтровать");

        add(updateButton);
        add(removeButton);
        add(sortButton);
        add(filterButton);
    }
}
