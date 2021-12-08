package com;

import java.rmi.Naming;
import java.util.List;

import com.books.domain.Book;
import com.books.services.BooksService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Launcher Library A Server...");
        System.setProperty("java.rmi.server.hostname", Constants.IP);

        try {
            BooksService booksService = new BooksService();
            Naming.rebind(Constants.URL, booksService);
            System.out.println("Library A Server listening (" + Constants.IP + ")");

            // Leer todos los libros
            List<Book> books = booksService.getBooksByAuthor("Frank Herbert");

            // Buscar un libro
            // Book elPrincipito = booksService.getBookByName("El Principito");

            System.out.println(books);
            // System.out.println(elPrincipito);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
