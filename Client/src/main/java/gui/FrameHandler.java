package gui;

import Interfaces.CommandReaderInterface;
import gui.connection.ConnectController;
import gui.informing.InformationDialogController;
import gui.logining.LoginController;
import gui.main.MainController;
import gui.registration.RegisterController;
import utility.*;

import javax.swing.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class FrameHandler {
    private final CommandReaderInterface commandReader;
    private final ConnectController connectController;
    private final LoginController loginController;
    private final RegisterController registerController;
    private final MainController mainController;
    private final MainFrame jFrame;
    private final InformationDialogController informationDialogController;
    private final DataSynchronizer dataSynchronizer;
    private final MainModelAnimator mainModelAnimator;
    private static final Logger logger = Logger.getLogger(CommandManager.class.getName());

    public FrameHandler() {
        jFrame = new MainFrame();
        jFrame.setTitle("Study groups");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        commandReader = CommandReader.getInstance();
        connectController = new ConnectController(this);
        loginController = new LoginController(this);
        registerController = new RegisterController(this);
        mainController = new MainController(this);
        informationDialogController = new InformationDialogController();
        dataSynchronizer = new DataSynchronizer();
        mainModelAnimator = mainController.getMainModelAnimator();
    }

    public MainModelAnimator getMainModelAnimator(){
        return mainModelAnimator;
    }

    public void start() {
        connectController.setPanel(jFrame);
        jFrame.setVisible(true);
    }

    public void connect(String remoteHostAddress, String remoteHostPort) {
        if (Validator.getInstance().validateConnection(remoteHostAddress, remoteHostPort)) {
            try {
                RequestHandler.getInstance().setRemoteHostSocketAddress(
                        new InetSocketAddress(InetAddress.getByName(remoteHostAddress), Integer.parseInt(remoteHostPort)));
                setAuth();
            } catch (UnknownHostException unknownHostException) {
                connectController.setWarn(TypeOfAnswer.SERVERNOTAVAILABLE);
            }
        } else connectController.setWarn(TypeOfAnswer.NOTVALIDATE);
    }

    public void setAuth() {
        loginController.setPanel(jFrame);
    }

    public void setRegister() {
        registerController.setPanel(jFrame);
    }

    public void setMain() {
        Thread synchronizer = new Thread(dataSynchronizer);
        synchronizer.start();
        mainController.setPanel(jFrame);
    }

    public void login(String anUsername, char[] aPassword) {
        Session session = new Session(anUsername, new String(aPassword), TypeOfSession.Login);
        TypeOfAnswer status = commandReader.execute(session).getStatus();
        if (status != TypeOfAnswer.SUCCESSFUL) {
            loginController.setWarn(status);
        } else {
            setMain();
        }
    }

    public void register(String anUsername, char[] aPassword) {
        Session session = new Session(anUsername, new String(aPassword), TypeOfSession.Register);
        TypeOfAnswer status = commandReader.execute(session).getStatus();
        if (status != TypeOfAnswer.SUCCESSFUL) {
            registerController.setWarn(status);
        } else {
            setMain();
        }
    }

    public void printInfo(String info) {
        informationDialogController.showInfo(info);
    }

    public void stopSynchronize(){
        dataSynchronizer.stop();
    }

    public void resumeSynchronize(){
        dataSynchronizer.resume();
    }
}