package gui;

import utility.*;

import javax.swing.*;
import java.util.Arrays;
import java.util.logging.Logger;

public class FrameHandler {

    private static final Logger logger = Logger.getLogger(CommandManager.class.getName());

    private final CommandReader commandReader;
    private final AddDetailsModel addDetailsModel;
    private final LoginModel loginModel;
    private final RegisterModel registerModel;
    private final MainModel1 mainModel;
    private final JFrame jFrame;
    private static FrameHandler instance;

    public static FrameHandler getInstance() {
        if (instance == null) instance = new FrameHandler();
        return instance;
    }

    private FrameHandler() {
        commandReader = CommandReader.getInstance();
        addDetailsModel = new AddDetailsModel();
        loginModel = new LoginModel();
        registerModel = new RegisterModel();
        mainModel = new MainModel1();
        jFrame = new MainFrame();
    }

    public void start(){
        loginModel.setPanel(jFrame);
        jFrame.setVisible(true);
    }

    public void setAuth(){
        loginModel.setPanel(jFrame);
    }

    public void setRegister(){
        registerModel.setPanel(jFrame);
    }

    public void setMain(){
        mainModel.setPanel(jFrame);
    }

    public void login(String anUsername, char[] aPassword) {
        Session session = new Session(anUsername, new String(aPassword), TypeOfSession.Login);
        TypeOfAnswer status = commandReader.execute(session);
        if ((commandReader.execute(session) != TypeOfAnswer.SUCCESSFUL)) {
            loginModel.setWarn(status);
        } else {
            setMain();
        }
    }

    public void register(String anUsername, char[] aPassword){
        Session session = new Session(anUsername, new String(aPassword), TypeOfSession.Register);
        TypeOfAnswer status = commandReader.execute(session);
        if ((commandReader.execute(session) != TypeOfAnswer.SUCCESSFUL)) {
            registerModel.setWarn(status);
        } else {
            setMain();
        }
    }
}