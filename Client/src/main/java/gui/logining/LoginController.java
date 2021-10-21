package gui.logining;

import Interfaces.Relocatable;
import gui.FrameHandler;
import utility.TypeOfAnswer;

import javax.swing.*;

public class LoginController implements Relocatable {

    private final LoginModel model;
    private final FrameHandler frameHandler;

    public LoginController(FrameHandler aFrameHandler) {
        model = new LoginModel(this);
        frameHandler = aFrameHandler;
    }

    public void setPanel(JFrame jFrame) {
        jFrame.setTitle("Login");
        jFrame.setSize(400, 200);
        setLocation(jFrame);
        jFrame.setContentPane(model.getMainPanel());
        jFrame.revalidate();
    }

    public void switchRegister() {
        frameHandler.setRegister();
    }

    public void login() {
        String username = model.getUsername();
        char[] password = model.getPassword();
        frameHandler.login(username, password);
    }

    public void setWarn(TypeOfAnswer typeOfAnswer) {
        model.getWarnField().setText(typeOfAnswer.toString());
    }
}