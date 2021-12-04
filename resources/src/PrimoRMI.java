import java.rmi.Remote;

//Creamos la interfaz remota para la aplicación
public interface PrimoRMI extends Remote {
    //Definimos los métodos de la interfaz remota

    //Método que lee un número pasado por parámetro
    //y devuelve true si es primo, false si no lo es
    boolean esPrimo(int numero) throws java.rmi.RemoteException;
}