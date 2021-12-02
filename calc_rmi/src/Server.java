import java.rmi.Naming;

public class Server {
  public static void main(String[] args) {
    System.out.println("Launching server...");
    System.setProperty("java.rmi.server.hostname", "192.168.0.106");

    try {
      Adder adder = new Adder();
      String url = "rmi://192.168.0.106/adder";
      Naming.rebind(url, adder);
      System.out.println("Server listening...");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
