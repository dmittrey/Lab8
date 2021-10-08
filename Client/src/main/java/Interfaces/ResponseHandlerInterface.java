package Interfaces;

import utility.TypeOfAnswer;

import java.nio.ByteBuffer;

public interface ResponseHandlerInterface {

    /**
     * Return String representation of Server answer in buffer
     * @return
     */
    TypeOfAnswer receive(ByteBuffer buffer);

    /**
     * Return reformatted errorInformation
     * @return
     */
    TypeOfAnswer receive(TypeOfAnswer errorInformation);
}
