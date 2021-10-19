package gui.informing;

public class InformationDialogController {

    private final InformationDialogModel model;

    public InformationDialogController() {
        model = new InformationDialogModel();
    }

    public void showInfo(String information) {
        model.setInformationArea(information);
        model.setVisible(true);
    }
}
