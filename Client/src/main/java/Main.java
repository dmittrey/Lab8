import gui.FrameHandler;
import utility.CommandManager;
import utility.CommandReader;
import utility.RequestHandler;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(CommandManager.class.getName());

    public static void main(String[] args) throws UnknownHostException {

        logger.info("start");

        FrameHandler frameHandler = new FrameHandler();
        CommandManager commandManager = new CommandManager(frameHandler.getMainModelAnimator());
        CommandReader.getInstance().setCommandManager(commandManager);
        InetSocketAddress socketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 2323);
        RequestHandler.getInstance().setRemoteHostSocketAddress(socketAddress);

        logger.info("gui");

        frameHandler.start();
    }
}