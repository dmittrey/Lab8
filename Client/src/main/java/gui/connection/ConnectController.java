package gui.connection;

import gui.FrameHandler;
import gui.MainFrame;
import utility.TypeOfAnswer;

public class ConnectController {

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

    public void setPanel(MainFrame jFrame) {
        jFrame.setTitle("Connecting");
        jFrame.setSize(400, 200);
        jFrame.setLocation();
        jFrame.setContentPane(model.getMainPanel());
        jFrame.revalidate();
    }

    public void setWarn(TypeOfAnswer typeOfAnswer) {
        model.setWarn(typeOfAnswer.toString());
    }
}