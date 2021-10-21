package gui.bundles;

import java.util.ListResourceBundle;

public class RegisterLabels_ru extends ListResourceBundle {

    private final Object[][] contents = {
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