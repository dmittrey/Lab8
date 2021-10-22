package gui.connection;

import Interfaces.Relocatable;
import gui.FrameHandler;
import utility.TypeOfAnswer;

import javax.swing.*;
import java.util.Locale;

public class ConnectController implements Relocatable {

    private final ConnectModel model;
    private final FrameHandler frameHandler;

    public ConnectController(FrameHandler aFrameHandler) {
        model = new ConnectModel(this);
        frameHandler = aFrameHandler;
    }

    public void connect() {
        String hostAddress = model.getAddress();
        String hostPort = model.getPort();
        frameHandler.connect(hostAddress, hostPort);
    }

    public void setPanel(JFrame jFrame) {
        jFrame.setTitle("Connecting");
        jFrame.setSize(400, 200);
        setLocation(jFrame);
        jFrame.setContentPane(model.getMainPanel());
        jFrame.revalidate();
    }

    public void setWarn(TypeOfAnswer typeOfAnswer) {
        model.setWarn(typeOfAnswer.toString());
    }

    public void switchLanguage(Locale locale){

    }
}