package gui.bundles;

import java.util.ListResourceBundle;

public class RegisterLabels_en_AU extends ListResourceBundle {

    private final Object[][] contents = {
            {"language", "Language"},
            {"login", "Login"},
            {"username", "Username"},
            {"password", "Password"},
            {"passwordAgain", "Password again"},
            {"submit", "Submit"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}