package utility;

import gui.addDetails.AddDetailsModel;

/**
 * Class to validate fields from gui
 */
public class FieldsValidator {

    private final AddDetailsModel model;

    public FieldsValidator(AddDetailsModel aModel) {
        model = aModel;
    }

    public boolean validate(){
        return validateName(model.getName()) &&
                validateXCoordinate(model.getXCoordinate()) &&
                validateYCoordinate(model.getYCoordinate()) &&
                validateStudentsCount(model.getStudentsCount()) &&
                validateAverageMark(model.getAverageMark()) &&
                validateGroupAdminName(model.getGroupAdminName()) &&
                validateGroupAdminWeight(model.getGroupAdminWeight());
    }

    private boolean validateName(String line) {
        if (line.equals("")) {
            model.setNameWarn("Name should be not null and not empty string!");
            return false;
        } else return true;
    }

    private boolean validateXCoordinate(String line) {
        try {
            Integer.parseInt(line);
            return true;
        } catch (NumberFormatException exception) {
            model.setXCoordinateWarn("X coordinate should be not null int number!");
            return false;
        }
    }

    private boolean validateYCoordinate(String line) {
        try {
            Double.parseDouble(line);
            return true;
        } catch (NumberFormatException exception) {
            model.setYCoordinateWarn("Y coordinate should be not null double number!");
            return false;
        }
    }

    private boolean validateStudentsCount(String line) {
        try {
            if (Integer.parseInt(line) > 0) return true;
        } catch (NumberFormatException ignored) {}
        model.setStudentsCountWarn("Student's count should be not null positive int number!");
        return false;
    }

    private boolean validateAverageMark(String line) {
        try {
            if (Double.parseDouble(line) > 0) return true;
        } catch (NumberFormatException ignored) {}
        model.setAverageMarkWarn("Average mark should be positive double or empty field!");
        return false;
    }

    private boolean validateGroupAdminName(String line) {
        if (line.equals("")) {
            model.setGroupAdminNameWarn("Name should be not null and not empty string!");
            return false;
        } else return true;
    }

    private boolean validateGroupAdminWeight(String line) {
        try {
            if (Long.parseLong(line) > 0) return true;
        } catch (NumberFormatException ignored) {}
        model.setGroupAdminWeightWarn("Weight should be not null positive long number!");
        return false;
    }
}