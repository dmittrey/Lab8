package gui;

import gui.connection.ConnectModel;
import gui.informing.InformationDialog;
import gui.logining.LoginModel;
import gui.main.MainController;
import gui.registration.RegisterModel;
import utility.*;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class FrameHandler {
    private final CommandReader commandReader;
    private final ConnectModel connectModel;
    private final LoginModel loginModel;
    private final RegisterModel registerModel;
    private final MainController mainController;
    private final MainFrame jFrame;
    private static FrameHandler instance;
    private final InformationDialog informationDialog;

    public static FrameHandler getInstance() {
        if (instance == null) instance = new FrameHandler();
        return instance;
    }

    private FrameHandler() {
        jFrame = new MainFrame("Study groups");
        commandReader = CommandReader.getInstance();
        connectModel = new ConnectModel();
        loginModel = new LoginModel();
        registerModel = new RegisterModel();
        mainController = new MainController();
        informationDialog = new InformationDialog();
    }

    public void start() {
        connectModel.setPanel(jFrame);
        jFrame.setVisible(true);
    }

    public void connect(String remoteHostAddress, String remoteHostPort) {
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

    public void setAuth() {
        loginModel.setPanel(jFrame);
    }

    public void setRegister() {
        registerModel.setPanel(jFrame);
    }

    public void setMain() {
        mainController.setPanel(jFrame);
    }

    public void login(String anUsername, char[] aPassword) {
        Session session = new Session(anUsername, new String(aPassword), TypeOfSession.Login);
        TypeOfAnswer status = commandReader.execute(session).getStatus();
        if (status != TypeOfAnswer.SUCCESSFUL) {
            loginModel.setWarn(status);
        } else {

            Thread synchronizer = new Thread(new DataSynchronizer());
            synchronizer.start();

            setMain();
        }
    }

    public void register(String anUsername, char[] aPassword) {
        Session session = new Session(anUsername, new String(aPassword), TypeOfSession.Register);
        TypeOfAnswer status = commandReader.execute(session).getStatus();
        if (status != TypeOfAnswer.SUCCESSFUL) {
            registerModel.setWarn(status);
        } else {
            setMain();
        }
    }

    public void printInfo(String info) {
        informationDialog.setInfo(info);
        informationDialog.setVisible(true);
    }
}