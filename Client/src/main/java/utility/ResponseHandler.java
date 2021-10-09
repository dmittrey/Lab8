package utility;

import Interfaces.ResponseHandlerInterface;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;

/**
 * Class to response processing
 */
public class ResponseHandler implements ResponseHandlerInterface {

    private static ResponseHandler instance;

    private ResponseHandler() {
    }

    public static ResponseHandler getInstance() {
        if (instance == null) instance = new ResponseHandler();
        return instance;
    }

    @Override
    public Response receive(ByteBuffer buffer) {
        try {
            ObjectInputStream inObj = new ObjectInputStream(new ByteArrayInputStream(buffer.array()));
            return (Response) inObj.readObject();
        } catch (ClassNotFoundException | InvalidClassException e) {
            return new Response(TypeOfAnswer.ANOTHERVERSION);
        } catch (IOException e) {
            return new Response(TypeOfAnswer.NETPROBLEM);
        }
    }

    @Override
    public Response receive(TypeOfAnswer errorInformation) {
        return new Response(errorInformation);
    }
}