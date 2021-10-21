package gui.bundles;

import java.util.ListResourceBundle;

public class MainLabels_lv extends ListResourceBundle {

    private final Object[][] contents = {
            {"language", "Language"},
            {"command", "Register"},
            {"argument", "Username"},
            {"submit", "Password"},
            {"clientInfo", "Submit"},
            {"serverInfo", "Submit"},
            {"visualMode", "Submit"},
            {"studyGroupTable", "Submit"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}