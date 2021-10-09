package gui;

import utility.*;

import javax.swing.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class FrameHandler {

    private static final Logger logger = Logger.getLogger(CommandManager.class.getName());

    private final CommandReader commandReader;
    private final AddDetailsModel addDetailsModel;
    private final ConnectModel connectModel;
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
        connectModel = new ConnectModel();
        loginModel = new LoginModel();
        registerModel = new RegisterModel();
        mainModel = new MainModel1();
        jFrame = new MainFrame();
    }

    public void start(){
        connectModel.setPanel(jFrame);
        jFrame.setVisible(true);
    }

    public void connect(String remoteHostAddress, String remoteHostPort){
        if (Validator.getInstance().validateConnection(remoteHostAddress, remoteHostPort)) {
            try {
                RequestHandler.getInstance().setRemoteHostSocketAddress(
                        new InetSocketAddress(InetAddress.getByName(remoteHostAddress), Integer.parseInt(remoteHostPort)));
                setAuth();
            } catch (UnknownHostException unknownHostException) {
                connectModel.setWarn(TypeOfAnswer.SERVERNOTAVAILABLE);
            }
        } else connectModel.setWarn(TypeOfAnswer.NOTVALIDATE);
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
        TypeOfAnswer status = commandReader.execute(session).getStatus();
        if (status != TypeOfAnswer.SUCCESSFUL) {
            loginModel.setWarn(status);
        } else {
            setMain();
        }
    }

    public void register(String anUsername, char[] aPassword){
        Session session = new Session(anUsername, new String(aPassword), TypeOfSession.Register);
        TypeOfAnswer status = commandReader.execute(session).getStatus();
        if (status != TypeOfAnswer.SUCCESSFUL) {
            registerModel.setWarn(status);
        } else {
            setMain();
        }
    }
}