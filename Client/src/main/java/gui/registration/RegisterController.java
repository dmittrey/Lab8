package gui.registration;

import Interfaces.Relocatable;
import gui.FrameHandler;
import utility.TypeOfAnswer;

import javax.swing.*;
import java.util.Arrays;

public class RegisterController implements Relocatable {

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

    public void setPanel(JFrame jFrame) {
        jFrame.setTitle("Register");
        jFrame.setSize(400, 300);
        setLocation(jFrame);
        jFrame.setContentPane(model.getMainPanel());
        jFrame.revalidate();
    }

    public void setWarn(TypeOfAnswer typeOfAnswer) {
        model.getWarnField().setText(typeOfAnswer.toString());
    }
}