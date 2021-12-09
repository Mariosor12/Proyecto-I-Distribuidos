package com;

import java.rmi.Naming;

import com.books.services.BooksService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Launching Library B Server...");
        System.setProperty("java.rmi.server.hostname", Constants.IP);

        try {

            BooksService booksService = new BooksService();
            Naming.rebind(Constants.URL, booksService);
            System.out.println("Library B Server listening (" + Constants.IP + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
