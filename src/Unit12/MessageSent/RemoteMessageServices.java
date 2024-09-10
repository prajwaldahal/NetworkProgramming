package Unit12.MessageSent;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteMessageServices extends UnicastRemoteObject implements MessageServices {
    private String message;
    protected RemoteMessageServices() throws RemoteException {
    }

    @Override
    public void sentMessage(String message) throws RemoteException {
        this.message = message;
    }

    @Override
    public String recievedMessage() throws RemoteException {
        return this.message;
    }
}
