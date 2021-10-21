package gui;

import data.StudyGroup;
import utility.Response;
import utility.TypeOfAnswer;

import javax.swing.*;

public class MainModelAnimator {

    private final SGTableModel sgTableModel;
    private final FrameHandler frameHandler;
    private final JTextField clientInfo;
    private final JTextField serverInfo;

    public MainModelAnimator(FrameHandler aFrameHandler, JTextField aClientInfo, JTextField aServerInfo) {
        sgTableModel = SGTableModel.getInstance();
        frameHandler = aFrameHandler;
        clientInfo = aClientInfo;
        serverInfo = aServerInfo;
    }

    public void animateShow(Response aResponse) {
        if (aResponse.getSetOfStudyGroups() != null) {
            sgTableModel.clearTable();
            aResponse.getSetOfStudyGroups().forEach(sgTableModel::addData);
            sgTableModel.fireTableDataChanged();
        }
    }

    public void animate(Response aResponse) {

        clientInfo.setText("");
        serverInfo.setText("");

        if (aResponse.getStatus().equals(TypeOfAnswer.SUCCESSFUL)) {
            clientInfo.setText("Command executed successful!");
            serverInfo.setText("Command executed successful!");
            StringBuilder sb = new StringBuilder();

            if (aResponse.getInformation() != null) {
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
                frameHandler.printInfo(sb.toString());
            } else if (aResponse.getSetOfStudyGroups() != null) {
                sgTableModel.clearTable();
                aResponse.getSetOfStudyGroups().forEach(sgTableModel::addData);
                frameHandler.stopSynchronize();
                sgTableModel.fireTableDataChanged();
            } else if (aResponse.getStudyGroup() != null) {
                sgTableModel.clearTable();
                StudyGroup newStudyGroup = aResponse.getStudyGroup();
                sgTableModel.addData(newStudyGroup);
                frameHandler.stopSynchronize();
                sgTableModel.fireTableDataChanged();
            } else if (aResponse.getCount() != null) {
                sb.append("Amount of elements: ")
                        .append(aResponse.getCount())
                        .append("\n");
                serverInfo.setText(sb.toString());
            }
        } else {
            switch (aResponse.getStatus()) {
                case OBJECTNOTEXIST:
                    clientInfo.setText("Command executed successful!");
                    serverInfo.setText("No object was found!");
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