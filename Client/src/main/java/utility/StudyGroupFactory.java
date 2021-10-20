package utility;

import data.*;
import Interfaces.FieldsReceiver;
import gui.addDetails.AddDetailsModel;

import java.util.Date;

/**
 * Class for creating Study groups without id and Date
 */
public class StudyGroupFactory {

    private final FieldsReceiver fieldsReceiver;

    public StudyGroupFactory() {

        fieldsReceiver = new FieldsGetter(Console.getInstance());
    }

    public StudyGroup createScriptStudyGroup() {

        String name = fieldsReceiver.getName();
        Coordinates coordinates = fieldsReceiver.getCoordinates();
        Integer studentsCount = fieldsReceiver.getStudentsCount();
        Double averageMark = fieldsReceiver.getAverageMark();
        FormOfEducation formOfEducation = fieldsReceiver.getFormOfEducation();
        Semester semester = fieldsReceiver.getSemester();
        Person groupAdmin = fieldsReceiver.getGroupAdmin();

        return new StudyGroup(0, name, coordinates, null, studentsCount,
                averageMark, formOfEducation, semester, groupAdmin);
    }

    public StudyGroup createGUIStudyGroup(AddDetailsModel model) {

        String name = model.getName();
        Integer coordinateX = Integer.parseInt(model.getXCoordinate());
        Double coordinateY = Double.parseDouble(model.getYCoordinate());
        int studentsCount = Integer.parseInt(model.getStudentsCount());
        Double averageMark = Double.parseDouble(model.getAverageMark());
        FormOfEducation formOfEducation = FormOfEducation.valueOf(model.getFormOfEducation());
        Semester semester = Semester.valueOf(model.getSemester());
        String adminName = model.getGroupAdminName();
        Long adminWeight = Long.parseLong(model.getGroupAdminWeight());
        Color adminColor = Color.valueOf(model.getGroupAdminHairColor());

        return new StudyGroup(0,
                name,
                new Coordinates(coordinateX, coordinateY),
                null,
                studentsCount,
                averageMark,
                formOfEducation,
                semester,
                new Person(adminName, adminWeight, adminColor));
    }
}