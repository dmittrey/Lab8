package gui.bundles;

import java.util.ListResourceBundle;

public class VisualLabels_sk_SK extends ListResourceBundle {

    private final Object[][] contents = {
            {"language", "Jazyk"},
            {"command", "Príkaz"},
            {"argument", "Argument"},
            {"submit", "Predložiť"},
            {"clientInfo", "Informácie o klientovi"},
            {"serverInfo", "Informácie o serveri"},
            {"tableMode", "Režim tabuľky"},
            {"studyGroupVisual", "Vizuálna študijná skupina"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}