package gui.bundles;

import java.util.ListResourceBundle;

public class ConnectLabels_ru_RU extends ListResourceBundle {

    private final Object[][] contents = {
            {"remoteHostAddress", "Адрес удаленного хоста"},
            {"remoteHostPort", "Порт удаленного хоста"},
            {"language", "Язык"},
            {"connect", "Подключиться"},
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}