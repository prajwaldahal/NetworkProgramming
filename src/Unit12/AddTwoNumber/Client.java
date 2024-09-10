package Unit12.AddTwoNumber;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry= LocateRegistry.getRegistry("localhost",1234);
        Adder adder= (Adder) registry.lookup("adder");
        System.out.println(adder.add(1,2));
    }
}
