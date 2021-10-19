package gui.registration;

import gui.FrameHandler;
import gui.MainFrame;
import utility.TypeOfAnswer;

import java.util.Arrays;

public class RegisterController {

    private final RegisterModel model;
    private final FrameHandler frameHandler;

    public RegisterController(FrameHandler aFrameHandler) {
        model = new RegisterModel(this);
        frameHandler = aFrameHandler;
    }

    public void switchLogin() {
        frameHandler.setAuth();
    }

    public void register() {
        String username = model.getUsername();
        char[] firstPassword = model.getFirstPassword();
        char[] secondPassword = model.getSecondPassword();

        if (Arrays.equals(firstPassword, secondPassword)) {
            frameHandler.register(username, firstPassword);
        } else setWarn(TypeOfAnswer.NOTMATCH);
    }

    public void setPanel(MainFrame jFrame) {
        jFrame.setTitle("Register");
        jFrame.setSize(400, 300);
        jFrame.setLocation();
        jFrame.setContentPane(model.getMainPanel());
        jFrame.revalidate();
    }

    public void setWarn(TypeOfAnswer typeOfAnswer) {
        model.getWarnField().setText(typeOfAnswer.toString());
    }
}