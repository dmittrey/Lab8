package utility;

import data.StudyGroup;
import Interfaces.RequestHandlerInterface;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;

/**
 * Class to completing requests
 */
public class RequestHandler implements RequestHandlerInterface {

    private static RequestHandler instance;
    private InetSocketAddress socketAddress;
    private boolean socketStatus;
    private Session session;

    public static RequestHandler getInstance() {
        if (instance == null) instance = new RequestHandler();
        return instance;
    }

    @Override
    public Response send(Command aCommand) {
        try {
            Request request = new Request(aCommand, session);

            SocketWorker socketWorker = new SocketWorker(socketAddress);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            ObjectOutputStream outObj = new ObjectOutputStream(byteArrayOutputStream);
            outObj.writeObject(request);
            session.setTypeOfSession(TypeOfSession.Login);
            return socketWorker.sendRequest(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            return new Response(TypeOfAnswer.NOTSERIALIZED);
        }
    }

    @Override
    public Response send(Command aCommand, StudyGroup studyGroup) {

        if (studyGroup != null) {
            aCommand.addStudyGroup(studyGroup);
            return send(aCommand);
        } else return new Response(TypeOfAnswer.OBJECTNOTEXIST);
    }

    @Override
    public void setRemoteHostSocketAddress(InetSocketAddress aSocketAddress) {
        socketAddress = aSocketAddress;
    }

    @Override
    public String getInformation() {

        return TextFormatting.getGreenText("\n\t\t\t\t\u0020----------------") +
                TextFormatting.getGreenText("\n\t\t\t\tConnection status:") +
                TextFormatting.getGreenText("\n\t\t\t\t------------------\n") +
                "Remote host address:\t" + TextFormatting.getGreenText(String.valueOf(socketAddress.getAddress())) + "\n\n" +
                "Remote host port:\t" + TextFormatting.getGreenText(String.valueOf(socketAddress.getPort())) + "\n\n";
    }

    @Override
    public void setSocketStatus(boolean aSocketStatus) {
        socketStatus = aSocketStatus;
    }

    @Override
    public boolean getSocketStatus() {
        return socketStatus;
    }

    @Override
    public void setSession(Session aSession) {
        session = aSession;
    }

    @Override
    public Session getSession() {
        return session;
    }

    @Override
    public Response register(Session aSession) {
        setSession(aSession);
        return send(new Command(TypeOfCommand.Register, ""));
    }

    @Override
    public Response login(Session aSession) {
        setSession(aSession);
        return send(new Command(TypeOfCommand.Login, ""));
    }
}