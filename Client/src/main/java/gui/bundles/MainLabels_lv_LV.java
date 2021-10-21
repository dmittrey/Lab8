package gui.bundles;

import java.util.ListResourceBundle;

public class MainLabels_lv_LV extends ListResourceBundle {

    private final Object[][] contents = {
            {"language", "Valoda"},
            {"command", "Komanda"},
            {"argument", "Arguments"},
            {"submit", "Iesniegt"},
            {"clientInfo", "Klienta informācija"},
            {"serverInfo", "Servera informācija"},
            {"visualMode", "Vizuālais režīms"},
            {"studyGroupTable", "Pētījuma grupas tabula"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}