package gui.bundles;

import java.util.ListResourceBundle;

public class RegisterLabels_ru_RU extends ListResourceBundle {

    private final Object[][] contents = {
            {"language", "Язык"},
            {"login", "Авторизоваться"},
            {"username", "Имя пользователя"},
            {"password", "Пароль"},
            {"passwordAgain", "Повторите пароль"},
            {"submit", "Подтвердите"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}