package gui.bundles;

import java.util.ListResourceBundle;

public class RegisterLabels_ru extends ListResourceBundle {

    private final Object[][] contents = {
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