package com;

import java.rmi.Naming;
import java.util.*;
import java.util.regex.Pattern;

import com.books.services.IBooksService;
import com.books.views.BooksViews;
import com.ui.UIService;
import com.trace.Trace;

public class Main {
    private static IBooksService remoteService(String URL) {
        try {
            return (IBooksService) Naming.lookup(URL);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        try {
            BooksViews booksViews = new BooksViews();
            Scanner scanner = new Scanner(System.in);
            UIService ui = new UIService();
            IBooksService booksService;
            String command;
            Trace trace;

            ui.print("Choose a library (A, B, C or blank)");
            String library = scanner.nextLine();

            if (library.isEmpty()) {
                library = "A";
            }

            switch (library) {
                case "A":
                    booksService = remoteService(Constants.URL_A);

                    ui.print("Available commands for library " + library);
                    ui.print("1. Pedir Libro [LIBRO]");
                    ui.print("2. Pedir Autor [AUTOR]");

                    command = scanner.nextLine();

                    if (command.matches("Pedir Libro \\w+")) {
                        String bookTitle = command.split(" ")[2];

                        booksViews.printBook(booksService.getBookByName(bookTitle));
                        ui.saveTrace(library, "getBookByName", bookTitle);

                    } else if (command.matches("Pedir Autor \\w+")) {
                        String authorName = command.split(" ")[2];

                        booksViews.printBooks(booksService.getBooksByAuthor(authorName));
                        ui.saveTrace(library, "getBooksByAuthor", authorName);

                    } else {
                        ui.print("Comando no válido");
                    }

                    break;

                case "B":
                    booksService = remoteService(Constants.URL_B);

                    ui.print("Available commands for library " + library);
                    ui.print("1. Buscar Titulo [LIBRO]");
                    ui.print("2. Buscar Autor [AUTOR]");

                    // command = scanner.nextInt();
                    // scanner.nextLine();

                    // switch (command) {
                    // case 1:
                    // ui.print("Book title?");
                    // String bookTitle = scanner.nextLine();

                    // booksViews.printBook(booksService.getTitleByName(bookTitle));
                    // ui.saveTrace(library, "getTitleByName", bookTitle);
                    // break;
                    // case 2:
                    // ui.print("Author name?");
                    // String authorName = scanner.nextLine();

                    // booksViews.printBooks(booksService.getTitlesByAuthor(authorName));
                    // ui.saveTrace(library, "getTitlesByAuthor", authorName);
                    // break;
                    // default:
                    // break;
                    // }

                    break;

                case "C":
                    booksService = remoteService(Constants.URL_C);

                    ui.print("Available commands for library " + library);
                    ui.print("1. Encontrar Vol [LIBRO]");
                    ui.print("2. Encontrar Autor [AUTOR]");

                    // command = scanner.nextInt();
                    // scanner.nextLine();

                    // switch (command) {
                    // case 1:
                    // ui.print("Book title?");
                    // String bookTitle = scanner.nextLine();

                    // booksViews.printBook(booksService.getTitleByName(bookTitle));
                    // ui.saveTrace(library, "getTitleByName", bookTitle);
                    // break;
                    // case 2:
                    // ui.print("Author name?");
                    // String authorName = scanner.nextLine();

                    // booksViews.printBooks(booksService.getTitlesByAuthor(authorName));
                    // ui.saveTrace(library, "getTitlesByAuthor", authorName);
                    // break;
                    // default:
                    // break;
                    // }

                    break;
                default:

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
