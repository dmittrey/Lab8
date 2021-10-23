package gui.bundles;

import java.util.ListResourceBundle;

public class SGInfoLabels_lv_LV  extends ListResourceBundle {

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
            {"ok", "LABI"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}