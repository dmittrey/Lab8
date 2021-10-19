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

    public boolean validate() {
        return validateName(model.getName()) &
                validateXCoordinate(model.getXCoordinate()) &
                validateYCoordinate(model.getYCoordinate()) &
                validateStudentsCount(model.getStudentsCount()) &
                validateAverageMark(model.getAverageMark()) &
                validateGroupAdminName(model.getGroupAdminName()) &
                validateGroupAdminWeight(model.getGroupAdminWeight());
    }

    private boolean validateName(String line) {
        if (line == null) {
            model.setNameWarn("Name should be not null and not empty string!");
            return false;
        } else return true;
    }

    private boolean validateXCoordinate(String line) {
        if (line != null) {
            try {
                Integer.parseInt(line);
                return true;
            } catch (NumberFormatException ignored) {
            }
        }
        model.setXCoordinateWarn("X coordinate should be not null int number!");
        return false;
    }

    private boolean validateYCoordinate(String line) {
        if (line != null) {
            try {
                Double.parseDouble(line);
                return true;
            } catch (NumberFormatException ignored) {
            }
        }
        model.setYCoordinateWarn("Y coordinate should be not null double number!");
        return false;
    }

    private boolean validateStudentsCount(String line) {
        if (line != null) {
            try {
                if (Integer.parseInt(line) > 0) return true;
            } catch (NumberFormatException ignored) {
            }
        }
        model.setStudentsCountWarn("Student's count should be not null positive int number!");
        return false;
    }

    private boolean validateAverageMark(String line) {
        if (line != null) {
            try {
                if (Double.parseDouble(line) > 0) return true;
            } catch (NumberFormatException ignored) {
            }
        }
        model.setAverageMarkWarn("Average mark should be positive double or empty field!");
        return false;
    }

    private boolean validateGroupAdminName(String line) {
        if (line == null) {
            model.setGroupAdminNameWarn("Name should be not null and not empty string!");
            return false;
        } else return true;
    }

    private boolean validateGroupAdminWeight(String line) {
        if (line != null) {
            try {
                if (Long.parseLong(line) > 0) return true;
            } catch (NumberFormatException ignored) {
            }
        }
        model.setGroupAdminWeightWarn("Weight should be not null positive long number!");
        return false;
    }
}