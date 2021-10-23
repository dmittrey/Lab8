package gui.sgInfo;

import data.StudyGroup;

import java.util.Locale;

public class SGInfoController {

    private final SGInfoModel model;

    public SGInfoController() {
        model = new SGInfoModel();
    }

    public void showInfo(StudyGroup studyGroup) {
        model.setFields(studyGroup);
        model.setVisible(true);
    }

    public void switchLanguage(Locale locale){
        model.switchLanguage(locale);
    }
}
