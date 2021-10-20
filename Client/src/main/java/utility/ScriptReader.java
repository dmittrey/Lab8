package utility;

import Interfaces.CommandReaderInterface;
import Interfaces.ScriptReaderInterface;
import gui.MainModelAnimator;

import java.io.*;

/**
 * Class for reading script
 */
public class ScriptReader implements ScriptReaderInterface {

    private final File file;
    private final CommandReaderInterface commandReader;

    public ScriptReader(File aFile) throws FileNotFoundException {
        file = aFile;
        commandReader = CommandReader.getInstance();
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
            } while (true);
        }
    }
}