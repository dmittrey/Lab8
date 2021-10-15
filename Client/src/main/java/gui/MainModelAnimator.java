package gui;

import data.StudyGroup;
import utility.CommandManager;
import utility.Response;
import utility.TextFormatting;
import utility.TypeOfAnswer;

import javax.swing.*;
import java.util.logging.Logger;

public class MainModelAnimator {
    private static MainModelAnimator instance;
    private final SGTableWorker sgTableWorker;

    private static final Logger logger = Logger.getLogger(CommandManager.class.getName());

    private MainModelAnimator() {
        sgTableWorker = SGTableWorker.getInstance();
    }

    public static MainModelAnimator getInstance() {
        if (instance == null) instance = new MainModelAnimator();
        return instance;
    }

    public void animate(Response aResponse, JTextField clientInfo, JTextField serverInfo) {

        clientInfo.setText("");
        serverInfo.setText("");
        SGTableWorker.getInstance().clearTable();

        if (aResponse.getStatus().equals(TypeOfAnswer.SUCCESSFUL)) {
            clientInfo.setText("Command executed successful!");
            StringBuilder sb = new StringBuilder();

            if (aResponse.getInformation() != null) {
                // FIXME: 15.10.2021 Информацию буду алертом выводить, help будет при наведении на каждую команду отдельно
                if (aResponse.getInformation().get("1") == null) {
                    aResponse.getInformation().
                            forEach((key, value) -> sb.append(key.toUpperCase())
                                    .append(" : ")
                                    .append(value.toUpperCase())
                                    .append("\n"));
                } else {
                    aResponse.getInformation()
                            .keySet()
                            .stream()
                            .map(Integer::parseInt)
                            .sorted(Integer::compareTo)
                            .map(String::valueOf)
                            .forEach(key -> sb.append(key.toUpperCase())
                                    .append(" : ")
                                    .append(aResponse.getInformation().get(key).toUpperCase())
                                    .append("\n"));
                }
                FrameHandler.getInstance().printInfo(sb.toString());
            } else if (aResponse.getSetOfStudyGroups() != null) {
                serverInfo.setText("Command executed successful!");
                aResponse.getSetOfStudyGroups().forEach(sgTableWorker::addData);
            } else if (aResponse.getStudyGroup() != null) {
                serverInfo.setText("Command executed successful!");
                StudyGroup newStudyGroup = aResponse.getStudyGroup();
                sgTableWorker.addData(newStudyGroup);
            } else if (aResponse.getCount() != null) {
                sb.append("Amount of elements: ")
                        .append(TextFormatting.getGreenText(String.valueOf(aResponse.getCount())))
                        .append("\n");
                serverInfo.setText(sb.toString());
            } else serverInfo.setText("Command executed successful!");
        } else {
            switch (aResponse.getStatus()) {
                case OBJECTNOTEXIST:
                    clientInfo.setText("Command executed successful!");
                    serverInfo.setText("No object with such parameters was found!");
                    break;
                case DUPLICATESDETECTED:
                    clientInfo.setText("Command executed successful!");
                    serverInfo.setText("This element probably duplicates existing one and can't be added");
                    break;
                case ISNTMAX:
                    clientInfo.setText("Command executed successful!");
                    serverInfo.setText("Study group isn't max!");
                    break;
                case ISNTMIN:
                    clientInfo.setText("Command executed successful!");
                    serverInfo.setText("Study group isn't min!");
                    break;
                case PERMISSIONDENIED:
                    clientInfo.setText("Command executed successful!");
                    serverInfo.setText("Permission denied!");
                    break;
                case SQLPROBLEM:
                    clientInfo.setText("Command executed successful!");
                    serverInfo.setText("Some problem's with database!");
                    break;
                case EMPTYCOLLECTION:
                    clientInfo.setText("Command executed successful!");
                    serverInfo.setText("Collection is empty!");
                    break;
                case ALREADYREGISTERED:
                    clientInfo.setText("Command executed successful!");
                    serverInfo.setText("This account already registered!");
                    break;
                case NOTMATCH:
                    clientInfo.setText("Command executed successful!");
                    serverInfo.setText("Account with this parameters doesn't exist!");
                    break;
                case COMMANDNOTGO:
                    clientInfo.setText("Command didn't go to server!");
                    break;
                case ANOTHERVERSION:
                    clientInfo.setText("Server version is higher!");
                    break;
                case NETPROBLEM:
                    clientInfo.setText("Some problem's with internet!");
                    break;
                case SERVERNOTAVAILABLE:
                    clientInfo.setText("Server not available at the moment!");
                    break;
                case NOTSERIALIZED:
                    clientInfo.setText("Command cannot be serialized!");
                case NOTVALIDATE:
                    clientInfo.setText("Data in fields is incorrect!");
            }
        }
    }
}