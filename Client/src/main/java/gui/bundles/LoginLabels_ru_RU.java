package gui.bundles;

import java.util.ListResourceBundle;

public class LoginLabels_ru_RU extends ListResourceBundle {

    private final Object[][] contents = {
            {"register", "Зарегистрировать"},
            {"username", "Имя пользователя"},
            {"password", "Пароль"},
            {"submit", "Подтвердить"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}