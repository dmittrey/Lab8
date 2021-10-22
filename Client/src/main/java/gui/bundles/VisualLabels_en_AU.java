package gui.bundles;

import java.util.ListResourceBundle;

public class VisualLabels_en_AU extends ListResourceBundle {

    private final Object[][] contents = {
            {"language", "Language"},
            {"command", "Command"},
            {"argument", "Argument"},
            {"submit", "Submit"},
            {"clientInfo", "Client info"},
            {"serverInfo", "Server info"},
            {"tableMode", "Table mode"},
            {"studyGroupVisual", "Study group visual"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
