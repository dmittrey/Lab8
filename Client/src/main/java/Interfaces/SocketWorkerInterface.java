package Interfaces;

import utility.TypeOfAnswer;

public interface SocketWorkerInterface {

    /**
     * Send Request to the server
     * @return
     */
    TypeOfAnswer sendRequest(byte[] serializedRequest);
}
