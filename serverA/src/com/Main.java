package com;

import java.util.List;

import com.books.services.BooksService;
import com.books.domain.Book;

public class Main {

    public static void main(String[] args) {
        try {
            BooksService booksService = new BooksService();

            // Leer todos los libros
            List<Book> books = booksService.getBooks();

            // Buscar un libro
            Book elPrincipito = booksService.getBookByName("El Principito");

            System.out.println(books);
            System.out.println(elPrincipito);

            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
