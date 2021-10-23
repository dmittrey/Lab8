package gui.informing;

import java.util.Locale;

public class InformationDialogController {

    private final InformationDialogModel model;

    public InformationDialogController() {
        model = new InformationDialogModel();
    }

    public void showInfo(String information) {
        model.setInformationArea(information);
        model.setVisible(true);
    }

    public void switchLanguage(Locale locale) {
        model.switchLanguage(locale);
    }
}