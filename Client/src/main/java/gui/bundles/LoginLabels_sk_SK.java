package gui.bundles;

import java.util.ListResourceBundle;

public class LoginLabels_sk_SK extends ListResourceBundle {

    private final Object[][] contents = {
            {"register", "Zaregistrovať"},
            {"username", "Používateľské"},
            {"password", "Heslo"},
            {"submit", "Predložiť"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}