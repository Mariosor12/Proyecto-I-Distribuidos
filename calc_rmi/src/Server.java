import java.rmi.Naming;

public class Server {
  public static void main(String[] args) {
    System.out.println("Launching server...");

    try {
      Adder adder = new Adder();
      String url = "rmi://10.0.2.4:1099/adder";
      Naming.rebind(url, adder);
      System.out.println("Server listening...");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
