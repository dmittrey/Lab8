package gui.addDetails;

import data.StudyGroup;
import utility.Command;
import utility.FieldsValidator;
import utility.StudyGroupFactory;

import java.util.Locale;

public class AddDetailsController {

    private final AddDetailsModel model;
    private final FieldsValidator fieldsValidator;
    private final StudyGroupFactory studyGroupFactory;

    public AddDetailsController(Command aCommand) {
        model = new AddDetailsModel(this, aCommand);
        fieldsValidator = new FieldsValidator(model);
        studyGroupFactory = new StudyGroupFactory();
    }

    public void spawnModel() {
        model.setVisible(true);
    }

    public StudyGroup addStudyGroup() {
        if (fieldsValidator.validate()) {
            model.dispose();
            return studyGroupFactory.createGUIStudyGroup(model);
        } else return null;
    }

//    public void switchLanguage(Locale locale){
//        model.switchLanguage(locale);
//    }
//
//    public void notifySwitchLanguage(Locale locale){
//        frameHandler.switchLanguage(locale);
//    }
}