package gui;

import utility.TypeOfCommand;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

public class ComboBoxToolTipRenderer<T> extends BasicComboBoxRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
            if (-1 < index && list.getSelectedValue() != null) {
                switch (TypeOfCommand.getEnum(list.getSelectedValue().toString())) {
                    case Add:
                        list.setToolTipText("Add new element to the collection");
                        break;
                    case Add_if_max:
                        list.setToolTipText("Add new element to the collection, if it`s greater," +
                                " than biggest element of this collection");
                        break;
                    case Add_if_min:
                        list.setToolTipText("Add new element to the collection, if it`s value less, " +
                                "than smallest element of this collection");
                        break;
                    case Clear:
                        list.setToolTipText("Clear the collection");
                        break;
                    case Count_less_than_students_count:
                        list.setToolTipText("Print the number of elements whose studentsCount " +
                                "field value is less, than the specified one");
                        break;
                    case Execute_script:
                        list.setToolTipText("Execute commands from entered file");
                        break;
                    case Filter_starts_with_name:
                        list.setToolTipText("Output elements whose name field value starts " +
                                "with the specified substring");
                        break;
                    case History:
                        list.setToolTipText("Print the last 14 commands (without their arguments)");
                        break;
                    case Info:
                        list.setToolTipText("Print information about the collection " +
                                "(type, initialization date, number of elements, etc.) to standard output");
                        break;
                    case Min_by_students_count:
                        list.setToolTipText("Print object from the collection whose " +
                                "studentsCount field value is minimal");
                        break;
                    default:
                        break;
                }
            }
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setFont(list.getFont());
        setText((value == null) ? "" : value.toString());
        return this;
    }
}