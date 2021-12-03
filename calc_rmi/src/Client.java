import java.rmi.Naming;

public class Client {
  public static void main(String[] args) {
    int a = 10;
    int b = 5;

    try {
      System.out.println("rmi://192.168.56.103/adder");
      IAdder remote = (IAdder) Naming.lookup(Constants.URL);
      System.out.println("10 + 5 = " + remote.add(a, b));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}