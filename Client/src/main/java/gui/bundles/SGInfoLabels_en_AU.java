package gui.bundles;

import java.util.ListResourceBundle;

public class SGInfoLabels_en_AU extends ListResourceBundle {

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
            {"ok", "OK"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}