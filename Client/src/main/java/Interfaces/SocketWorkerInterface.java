package Interfaces;

import utility.Response;

public interface SocketWorkerInterface {

    /**
     * Send Request to the server
     * @return
     */
    Response sendRequest(byte[] serializedRequest);
}
