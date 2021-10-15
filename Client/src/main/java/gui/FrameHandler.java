package gui;

import utility.*;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class FrameHandler {

    private static final Logger logger = Logger.getLogger(CommandManager.class.getName());

    private final CommandReader commandReader;
    private AddDetailsModel addDetailsModel;
    private final ConnectModel connectModel;
    private final LoginModel loginModel;
    private final RegisterModel registerModel;
    private final MainModel mainModel;
    private final MainFrame jFrame;
    private static FrameHandler instance;
    private final InformationDialog informationDialog;

    public static FrameHandler getInstance() {
        if (instance == null) instance = new FrameHandler();
        return instance;
    }

    private FrameHandler() {
        commandReader = CommandReader.getInstance();
        connectModel = new ConnectModel();
        loginModel = new LoginModel();
        registerModel = new RegisterModel();
        mainModel = new MainModel();
        jFrame = new MainFrame("Study groups");
        addDetailsModel = new AddDetailsModel(jFrame);
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

    public void register(String anUsername, char[] aPassword) {
        Session session = new Session(anUsername, new String(aPassword), TypeOfSession.Register);
        TypeOfAnswer status = commandReader.execute(session).getStatus();
        if (status != TypeOfAnswer.SUCCESSFUL) {
            registerModel.setWarn(status);
        } else {
            setMain();
        }
    }

    public void spawnFieldsChanger(Command aCommand) {
        addDetailsModel.setVisible(true);
    }

    public void printInfo(String info) {
        informationDialog.setInfo(info);
        informationDialog.setVisible(true);
    }
}