package gui.bundles;

import java.util.ListResourceBundle;

public class VisualLabels_ru_RU extends ListResourceBundle {

    private final Object[][] contents = {
            {"language", "Язык"},
            {"command", "Команда"},
            {"argument", "Аргумент"},
            {"submit", "Подтвердить"},
            {"clientInfo", "Информация от клиента"},
            {"serverInfo", "Информация от сервера"},
            {"tableMode", "Табличный режим"},
            {"studyGroupVisual", "Визуализация учебных групп"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}