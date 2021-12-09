package com.Trace;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Trace {
    public String destino;
    public String metodo;
    public String peticion;
    public Date fecha;

    // Constructor de la clase
    public Trace(String destino, String metodo, String peticion, Date fecha) {
        this.destino = destino;
        this.metodo = metodo;
        this.peticion = peticion;
        this.fecha = fecha;
    }

    public void guardarTraza() {
        // Definimos la clase File y FileWriter para buscar y escribir en el archivo
        File archivo;
        FileWriter fw = null;
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        try {
            // Buscamos el archivo, si no esta se crea
            archivo = new File(
                    "C:/Users/pancho/Documents/GitHub/Proyecto-I-Distribuidos/clientA/src/com/log/Clogs.txt");
            fw = new FileWriter(archivo, true);

            BufferedWriter bw = new BufferedWriter(fw);

            // Escribmos el log para cuando se vaya a realizar una respuesta
            bw.write("Destino: Biblioteca " + this.destino + " - Metodo: " + this.metodo + " - Peticion: "
                    + this.peticion + " - Fecha: " + df.format(fecha) + "\n");
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
