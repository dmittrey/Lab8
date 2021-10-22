package gui.logining;

import Interfaces.Localizable;
import Interfaces.Relocatable;
import gui.FrameHandler;
import utility.TypeOfAnswer;

import javax.swing.*;
import java.util.Locale;

public class LoginController implements Relocatable, Localizable {

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
        String username = model.getUsername().trim();
        char[] password = model.getPassword();
        frameHandler.login(username, password);
    }

    public void setWarn(TypeOfAnswer typeOfAnswer) {
        model.getWarnField().setText(typeOfAnswer.toString());
    }

    public void switchLanguage(Locale locale) {
        model.switchLanguage(locale);
    }

    @Override
    public void notifySwitchLanguage(Locale locale) {
        frameHandler.switchLanguage(locale);
    }
}