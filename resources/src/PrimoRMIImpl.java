//Implementamos la interfaz remota
public class PrimoRMIImpl implements PrimoRMI {
    // Comprueba si un número es primo o no
    @Override
    public boolean esPrimo(int numero) {
        // Comprueba si es múltiplo de 2
        if (numero % 2 == 0) return false;
        // En caso contrario, comprueba los impares
        for (int i = 3; i * i <= numero; i += 2) {
            if(numero % i == 0)
                return false;
        }
        return true;
    }
}