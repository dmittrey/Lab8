package gui.bundles;

import java.util.Arrays;
import java.util.ListResourceBundle;

public class LoginLabels_en_AU extends ListResourceBundle {

    private final Object[][] contents = {
            {"language", "Language"},
            {"register", "Register"},
            {"username", "Username"},
            {"password", "Password"},
            {"submit", "Submit"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    public Object getContent(String key){
        return Arrays.stream(contents)
                .filter(obj -> obj[0].equals(key))
                .map(obj -> obj[1])
                .findFirst()
                .orElse(null);
    }
}