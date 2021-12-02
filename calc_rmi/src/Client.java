import java.rmi.Naming;

public class Client {
  public static void main(String[] args) {
    int a = 10;
    int b = 5;

    try {
      String url = "rmi://10.0.2.4:1099/adder";
      IAdder remote = (IAdder) Naming.lookup(url);
      System.out.println("10 + 5 = " + remote.add(a, b));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}