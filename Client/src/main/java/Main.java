import gui.FrameHandler;
import gui.MainModelAnimator;
import utility.CommandManager;
import utility.CommandReader;
import utility.RequestHandler;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws UnknownHostException {

        Locale[] supportedLocales = {
                new Locale("en", "AU"),
                new Locale("lv", "LV"),
                new Locale("ru", "RU"),
                new Locale("sk", "SK")
        };

        FrameHandler frameHandler = new FrameHandler();
        CommandManager commandManager = new CommandManager(frameHandler);
        CommandReader.getInstance().setCommandManager(commandManager);
        InetSocketAddress socketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 2323);
        RequestHandler.getInstance().setRemoteHostSocketAddress(socketAddress);

        frameHandler.start();
    }
}