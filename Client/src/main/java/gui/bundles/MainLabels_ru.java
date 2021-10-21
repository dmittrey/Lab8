package gui.bundles;

import java.util.ListResourceBundle;

public class MainLabels_ru extends ListResourceBundle {

    private final Object[][] contents = {
            {"language", "Язык"},
            {"command", "Команда"},
            {"argument", "Аргумент"},
            {"submit", "Подтвердить"},
            {"clientInfo", "Информация от клиента"},
            {"serverInfo", "Информация от сервера"},
            {"visualMode", "Визуальный режим"},
            {"studyGroupTable", "Таблица учебных групп"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
