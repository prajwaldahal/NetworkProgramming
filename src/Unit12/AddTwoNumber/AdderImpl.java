package Unit12.AddTwoNumber;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdderImpl extends UnicastRemoteObject implements Adder {
    protected AdderImpl() throws RemoteException {

    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a+b;
    }
}
