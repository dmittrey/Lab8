package gui.bundles;

import java.util.ListResourceBundle;

public class RegisterLabels_sk_SK extends ListResourceBundle {

    private final Object[][] contents = {
            {"login", "Prihlásenie"},
            {"username", "Používateľské"},
            {"password", "Heslo"},
            {"passwordAgain", "Heslo znova"},
            {"submit", "Predložiť"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}