package gui.bundles;

import java.util.ListResourceBundle;

public class MainLabels_sk extends ListResourceBundle {

    private final Object[][] contents = {
            {"language", "Jazyk"},
            {"command", "Príkaz"},
            {"argument", "Argument"},
            {"submit", "Predložiť"},
            {"clientInfo", "Informácie o klientovi"},
            {"serverInfo", "Informácie o serveri"},
            {"visualMode", "Vizuálny režim"},
            {"studyGroupTable", "Tabuľka študijných skupín"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}