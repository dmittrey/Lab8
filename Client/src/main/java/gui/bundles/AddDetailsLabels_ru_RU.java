package gui.bundles;

import java.util.ListResourceBundle;

public class AddDetailsLabels_ru_RU extends ListResourceBundle {

    private final Object[][] contents = {
            {"name", "Имя"},
            {"coordinates", "Координаты"},
            {"coordinateX", "Координата X"},
            {"coordinateY", "Координата Y"},
            {"studentsCount", "Количество студентов"},
            {"averageMark", "Средняя оценка"},
            {"formOfEducation", "Форма обучения"},
            {"semester", "Семестр"},
            {"groupAdmin", "Администратор группы"},
            {"groupAdminName", "Имя"},
            {"groupAdminWeight", "Вес"},
            {"groupAdminHairColor", "Цвет волос"},
            {"submit", "Подтвердить"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}