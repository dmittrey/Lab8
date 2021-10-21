package gui.bundles;

import java.util.ListResourceBundle;

public class ConnectLabels_en extends ListResourceBundle {

    private final Object[][] contents = {
            {"remoteHostAddress", "Remote host address"},
            {"remoteHostPort", "Remote host port"},
            {"language", "Language"},
            {"connect", "Connect"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
