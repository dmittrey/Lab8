package gui.bundles;

import java.util.ListResourceBundle;

public class VisualLabels_lv_LV extends ListResourceBundle {

    private final Object[][] contents = {
            {"language", "Valoda"},
            {"command", "Komanda"},
            {"argument", "Arguments"},
            {"submit", "Iesniegt"},
            {"clientInfo", "Klienta informācija"},
            {"serverInfo", "Servera informācija"},
            {"tableMode", "Galda režīms"},
            {"studyGroupVisual", "Pētījuma grupa visual"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}