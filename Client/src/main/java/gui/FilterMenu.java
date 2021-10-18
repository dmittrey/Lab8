package gui;

import javax.swing.*;

public class FilterMenu extends JMenu {

    public FilterMenu(String title) {
        super(title);

        JMenuItem sortId = new JMenuItem("Id");
        JMenuItem sortName = new JMenuItem("Name");
        JMenuItem sortXCoordinate = new JMenuItem("X coordinate");
        JMenuItem sortYCoordinate = new JMenuItem("Y coordinate");
        JMenuItem sortCreationDate = new JMenuItem("Creation date");
        JMenuItem sortStudentsCount = new JMenuItem("Students count");
        JMenuItem sortAverageMark = new JMenuItem("Average mark");
        JMenuItem sortFormOfEducation = new JMenuItem("Form of education");
        JMenuItem sortSemesterEnum = new JMenuItem("Semester");
        JMenuItem sortGroupAdminName = new JMenuItem("Admin name");
        JMenuItem sortGroupAdminWeight = new JMenuItem("Admin weight");
        JMenuItem sortGroupAdminHairColor = new JMenuItem("Admin hair color");
        JMenuItem sortAuthor = new JMenuItem("Author");

        add(sortId);
        add(sortName);
        add(sortXCoordinate);
        add(sortYCoordinate);
        add(sortCreationDate);
        add(sortStudentsCount);
        add(sortAverageMark);
        add(sortFormOfEducation);
        add(sortSemesterEnum);
        add(sortGroupAdminName);
        add(sortGroupAdminWeight);
        add(sortGroupAdminHairColor);
        add(sortAuthor);
    }
}
