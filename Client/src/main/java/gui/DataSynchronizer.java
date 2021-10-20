package gui;

import utility.Command;
import utility.CommandReader;
import utility.Response;
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
                    Response newCollection = CommandReader.getInstance().execute(new Command(TypeOfCommand.Show, null));
                    if (newCollection.getSetOfStudyGroups() != null)
                        newCollection.getSetOfStudyGroups().forEach(SGTableWorker.getInstance()::addData);
                    SGTableWorker.getInstance().fireTableDataChanged();
                    Thread.sleep(5000);
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
        System.out.println("Включили");
    }
}