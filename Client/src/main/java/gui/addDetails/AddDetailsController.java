package gui.addDetails;

import data.StudyGroup;
import utility.Command;
import utility.FieldsValidator;
import utility.StudyGroupFactory;

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
}