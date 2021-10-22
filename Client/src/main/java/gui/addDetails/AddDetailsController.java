package gui.addDetails;

import Interfaces.Localizable;
import gui.FrameHandler;
import utility.Command;
import utility.FieldsValidator;
import utility.StudyGroupFactory;

import java.util.Locale;

public class AddDetailsController implements Localizable {

    private final AddDetailsModel model;
    private FieldsValidator fieldsValidator;
    private final StudyGroupFactory studyGroupFactory;
    private final FrameHandler frameHandler;
    private Command command;

    public AddDetailsController(FrameHandler aFrameHandler) {
        studyGroupFactory = new StudyGroupFactory();
        model = new AddDetailsModel(this);
        frameHandler = aFrameHandler;
    }

    public void spawnModel(Command aCommand) {
        command = aCommand;
        fieldsValidator = new FieldsValidator(model);
        model.setVisible(true);
    }

    public void addStudyGroup() {
        model.clearAlerts();
        if (fieldsValidator.validate()) {
            command.addStudyGroup(studyGroupFactory.createGUIStudyGroup(model));
            model.clearFields();
            model.dispose();
        }
    }

    public void switchLanguage(Locale locale) {
        model.switchLanguage(locale);
    }

    @Override
    public void notifySwitchLanguage(Locale locale) {
        frameHandler.switchLanguage(locale);
    }
}