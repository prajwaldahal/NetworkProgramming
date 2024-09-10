package Unit12.MessageSent;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws RemoteException {
        Registry registry= LocateRegistry.createRegistry(1234);
        MessageServices msg = new RemoteMessageServices();
        msg.sentMessage("hello");
        registry.rebind("msg", msg);
    }
}
