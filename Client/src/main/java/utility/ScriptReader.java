package utility;

import Interfaces.CommandManagerInterface;
import Interfaces.CommandReaderInterface;
import Interfaces.ScriptReaderInterface;
import gui.MainModelAnimator;

import javax.swing.*;
import java.io.*;

/**
 * Class for reading script
 */
public class ScriptReader implements ScriptReaderInterface {

    private final File file;
    private final CommandManagerInterface commandManager;
    private final CommandReaderInterface commandReader;
    private final MainModelAnimator mainModelAnimator;

    public ScriptReader(CommandManager aCommandManager, CommandReaderInterface aCommandReader, File aFile, MainModelAnimator aMainModelAnimator)
            throws FileNotFoundException {
        mainModelAnimator = aMainModelAnimator;
        file = aFile;
        commandManager = aCommandManager;
        commandReader = aCommandReader;
    }

    public void read() throws IOException {

        String nextLine;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            do {
                nextLine = bufferedReader.readLine();
                System.out.println(nextLine);
                if (nextLine == null) return;

                Console.getInstance().setBufferedReader(bufferedReader);

                Command newCommand = commandReader.readCommand(nextLine + " ");
                System.out.println(newCommand);
                mainModelAnimator.animate(commandManager.transferCommand(newCommand), new JTextField(), new JTextField());
            } while (true);
        }
    }
}