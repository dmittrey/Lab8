package gui.bundles;

import java.util.ListResourceBundle;

public class AddDetailsLabels_en extends ListResourceBundle {

    private final Object[][] contents = {
            {"name", "Name"},
            {"coordinates", "Coordinates"},
            {"coordinateX", "Coordinate X"},
            {"coordinateY", "Coordinate Y"},
            {"studentsCount", "Students count"},
            {"averageMark", "Average mark"},
            {"formOfEducation", "Form of education"},
            {"semester", "Semester"},
            {"groupAdmin", "Group admin"},
            {"groupAdminName", "Name"},
            {"groupAdminWeight", "Weight"},
            {"groupAdminHairColor", "Hair color"},
            {"submit", "Submit"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}