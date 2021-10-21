package gui.bundles;

import java.util.ListResourceBundle;

public class AddDetailsLabels_sk extends ListResourceBundle {

    private final Object[][] contents = {
            {"name", "Meno"},
            {"coordinates", "Koordinovať"},
            {"coordinateX", "Súradnica X"},
            {"coordinateY", "Koordinácia Y"},
            {"studentsCount", "Počet študentov"},
            {"averageMark", "Priemerná známka"},
            {"formOfEducation", "Forma vzdelávania"},
            {"semester", "Semester"},
            {"groupAdmin", "Správca skupiny"},
            {"groupAdminName", "Meno"},
            {"groupAdminWeight", "Hmotnosť"},
            {"groupAdminHairColor", "Farba vlasov"},
            {"submit", "Predložiť"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}