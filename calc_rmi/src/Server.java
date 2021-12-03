
import java.rmi.Naming;

public class Server {
  public static void main(String[] args) {
    System.out.println("Launching server...");
    // System.setProperty("java.rmi.server.hostname", "192.168.56.103");

    try {
      Adder adder = new Adder();
      Naming.rebind(Constants.URL, adder);
      System.out.println("Server listening...");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
