package Interfaces;

import utility.Response;
import utility.TypeOfAnswer;

import java.nio.ByteBuffer;

public interface ResponseHandlerInterface {

    /**
     * Return String representation of Server answer in buffer
     * @return
     */
    Response receive(ByteBuffer buffer);

    /**
     * Return reformatted errorInformation
     * @return
     */
    Response receive(TypeOfAnswer errorInformation);
}
