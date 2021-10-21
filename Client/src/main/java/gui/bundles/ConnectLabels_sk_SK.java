package gui.bundles;

import java.util.ListResourceBundle;

public class ConnectLabels_sk_SK extends ListResourceBundle {

    private final Object[][] contents = {
            {"remoteHostAddress", "Vzdialená adresa hostiteľa"},
            {"remoteHostPort", "Vzdialený hostiteľský port"},
            {"language", "Jazyk"},
            {"connect", "Pripojiť"},
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}