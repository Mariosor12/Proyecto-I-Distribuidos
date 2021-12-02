import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Adder extends UnicastRemoteObject implements IAdder {
  public Adder() throws RemoteException {
    super();
  }

  public int add(int a, int b) {
    return a + b;
  }
}
