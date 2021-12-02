import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class ClienOperation {
  private static RMIInterface rmi;

  public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
    {
      rmi = (RMIInterface) Naming.lookup("//10.0.2.4/server");
      String name = JOptionPane.showInputDialog("What is your name?");

      String response = rmi.helloTo(name);
      JOptionPane.showMessageDialog(null, response);
    }
  }
}
