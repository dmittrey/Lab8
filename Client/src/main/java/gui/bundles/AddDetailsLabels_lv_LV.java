package gui.bundles;

import java.util.ListResourceBundle;

public class AddDetailsLabels_lv_LV extends ListResourceBundle {

    private final Object[][] contents = {
            {"name", "Nosaukums"},
            {"coordinates", "Koordinātas"},
            {"coordinateX", "Koordinātu X"},
            {"coordinateY", "Koordinēt Y"},
            {"studentsCount", "Studentu skaits"},
            {"averageMark", "Vidējā atzīme"},
            {"formOfEducation", "Izglītības forma"},
            {"semester", "Pusgads"},
            {"groupAdmin", "Grupas administrators"},
            {"groupAdminName", "Nosaukums"},
            {"groupAdminWeight", "Svars"},
            {"groupAdminHairColor", "Matu krāsa"},
            {"submit", "Iesniegt"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}