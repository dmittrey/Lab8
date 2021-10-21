package gui.bundles;

import java.util.ListResourceBundle;

public class MainLabels_en extends ListResourceBundle {

    private final Object[][] contents = {
            {"language", "Language"},
            {"command", "Command"},
            {"argument", "Argument"},
            {"submit", "Submit"},
            {"clientInfo", "Client info"},
            {"serverInfo", "Server info"},
            {"visualMode", "Visual mode"},
            {"studyGroupTable", "Study group table"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}