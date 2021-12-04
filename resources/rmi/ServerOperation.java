import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface {
  private static final long serialVersionUID = 1L;

  protected ServerOperation() throws RemoteException {
    super();
  }

  @Override
  public String helloTo(String name) throws RemoteException {
    System.err.println(name + " is trying to contact!");
    return "Server says hello to " + name;
  }

  public static void main(String[] args) {
    try {
      Naming.rebind("//localhost/server", new ServerOperation());
      System.err.println("Server running");
    } catch (Exception e) {
      System.err.println("Server exception: " + e.toString());
      e.printStackTrace();
    }
  }
}
