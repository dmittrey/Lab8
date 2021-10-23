package gui.bundles;

import java.util.ListResourceBundle;

public class SGInfoLabels_sk_SK extends ListResourceBundle {

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
            {"ok", "DOBRE"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}