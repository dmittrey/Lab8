package gui.bundles;

import java.util.ListResourceBundle;

public class RegisterLabels_lv_LV extends ListResourceBundle {

    private final Object[][] contents = {
            {"login", "Denník"},
            {"username", "Používateľské"},
            {"password", "Parole"},
            {"passwordAgain", "Parole vēlreiz"},
            {"submit", "Iesniegt"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}