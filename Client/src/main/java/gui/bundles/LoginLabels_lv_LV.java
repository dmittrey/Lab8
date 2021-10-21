package gui.bundles;

import java.util.ListResourceBundle;

public class LoginLabels_lv_LV extends ListResourceBundle {

    private final Object[][] contents = {
            {"register", "Reģistrēts"},
            {"username", "Lietotājs"},
            {"password", "Parole"},
            {"submit", "Iesniegt"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}