package gui.bundles;

import java.util.ListResourceBundle;

public class LoginLabels_en_AU extends ListResourceBundle {

    private final Object[][] contents = {
            {"register", "Register"},
            {"username", "Username"},
            {"password", "Password"},
            {"submit", "Submit"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}