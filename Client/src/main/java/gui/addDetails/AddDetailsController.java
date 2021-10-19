package gui.addDetails;

import data.StudyGroup;
import utility.Command;
import utility.FieldsValidator;
import utility.StudyGroupFactory;

import java.awt.*;

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
        setLocation();
        model.setVisible(true);
    }

    public StudyGroup addStudyGroup() {
        if (fieldsValidator.validate()) {
            model.dispose();
            return studyGroupFactory.createGUIStudyGroup(model);
        } else return null;
    }

    private void setLocation() {
        int width = model.getSize().width;
        int height = model.getSize().height;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        model.setLocation((screenSize.width / 2) - (width / 2), (screenSize.height / 2) - (height / 2));
    }
}