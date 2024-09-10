package Unit12.MessageSent;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessageServices extends Remote {
    public void sentMessage(String message) throws RemoteException;
    public String recievedMessage() throws RemoteException;
}