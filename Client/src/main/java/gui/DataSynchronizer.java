package gui;

import utility.Command;
import utility.CommandReader;
import utility.TypeOfCommand;

/**
 * Class to synchronize collection per some time(polling)
 */
public class DataSynchronizer implements Runnable {

    private volatile boolean isSynchronizeWorks = true;

    @Override
    public void run() {
        try {
            while (true) {
                if (isSynchronizeWorks) {
                    SGTableWorker.getInstance().clearTable();
                    CommandReader.getInstance().execute(new Command(TypeOfCommand.Show, null));
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isSynchronizeWorks = false;
    }

    public void resume() {
        isSynchronizeWorks = true;
    }
}