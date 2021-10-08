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
    public TypeOfAnswer receive(ByteBuffer buffer) {
        try {
            ObjectInputStream inObj = new ObjectInputStream(new ByteArrayInputStream(buffer.array()));
            return ((Response) inObj.readObject()).getStatus();
            // FIXME: 08.10.2021 Надо как-то обрабатывать полезную нагрузку
        } catch (ClassNotFoundException | InvalidClassException e) {
            return TypeOfAnswer.ANOTHERVERSION;
        } catch (IOException e) {
            return TypeOfAnswer.NETPROBLEM;
        }
    }

    @Override
    public TypeOfAnswer receive(TypeOfAnswer errorInformation) {
        return errorInformation;
    }
}