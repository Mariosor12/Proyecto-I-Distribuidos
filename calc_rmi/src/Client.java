import java.rmi.Naming;

public class Client {
  public static void main(String[] args) {
    int a = 10;
    int b = 5;

    try {
      System.out.println(Constants.URL);
      IAdder remote = (IAdder) Naming.lookup(Constants.URL);
      System.out.println("10 + 5 = " + remote.add(a, b));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}