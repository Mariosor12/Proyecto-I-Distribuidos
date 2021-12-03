
import java.rmi.Naming;

public class Server {
  public static void main(String[] args) {
    System.out.println("Launching server...");
    System.setProperty("java.rmi.server.hostname", Constants.IP);

    try {
      Adder adder = new Adder();
      Naming.rebind(Constants.URL, adder);
      System.out.println("Server listening...");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
