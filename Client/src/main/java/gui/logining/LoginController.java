package gui.logining;

import gui.FrameHandler;
import gui.MainFrame;
import utility.TypeOfAnswer;

public class LoginController {

    private final LoginModel model;
    private final FrameHandler frameHandler;

    public LoginController(FrameHandler aFrameHandler) {
        model = new LoginModel(this);
        frameHandler = aFrameHandler;
    }

    public void setPanel(MainFrame jFrame) {
        jFrame.setTitle("Login");
        jFrame.setSize(400, 200);
        jFrame.setLocation();
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