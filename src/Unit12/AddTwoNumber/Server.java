package Unit12.AddTwoNumber;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            Registry registry= LocateRegistry.createRegistry(1234);
            Adder adder= new AdderImpl();
            registry.rebind("adder", adder);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
