import gui.FrameHandler;
import utility.CommandManager;
import utility.CommandReader;

public class Main {

    public static void main(String[] args) {

        FrameHandler frameHandler = new FrameHandler();
        CommandManager commandManager = new CommandManager(frameHandler);
        CommandReader.getInstance().setCommandManager(commandManager);

        frameHandler.start();
    }
}