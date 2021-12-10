package com.Trace;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Trace {
    public String departure;
    public String method;
    public String lookUpValue;
    public Date date;

    // Constructor de la clase
    public Trace(String departure, String method, String lookUpValue, Date date) {
        this.departure = departure;
        this.method = method;
        this.lookUpValue = lookUpValue;
        this.date = date;
    }

    public void saveTrace() {
        FileWriter fileWriter = null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

            String filePath = new File("").getAbsolutePath().concat("\\log\\log.txt");
            System.out.println(filePath);
            File file = new File(filePath);
            fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("Salida: Biblioteca " + this.departure + " - Metodo: "
                    + this.method + " - Peticion: "
                    + this.lookUpValue + " - Fecha: " + dateFormat.format(date) + "\n");

            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
