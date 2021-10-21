package gui.bundles;

import java.util.ListResourceBundle;

public class ConnectLabels_lv extends ListResourceBundle {

    private final Object[][] contents = {
            {"remoteHostAddress", "Attālā resursdatora adrese"},
            {"remoteHostPort", "Attālā resursdatora ports"},
            {"language", "Valoda"},
            {"connect", "Savienojums"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}