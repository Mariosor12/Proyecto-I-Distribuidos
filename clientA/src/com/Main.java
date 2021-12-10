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
                        String bookTitle = ui.getLookUpValue(command);

                        booksViews.printBook(booksService.getBookByName(bookTitle));
                        ui.saveTrace(library, "getBookByName", bookTitle);

                    } else if (command.matches("Pedir Autor \\w+.*")) {
                        String authorName = ui.getLookUpValue(command);

                        booksViews.printBooks(booksService.getBooksByAuthor(authorName));
                        ui.saveTrace(library, "getBooksByAuthor", authorName);

                    } else {
                        ui.print("ERROR: Invalid input");
                    }

                    break;

                case "B":
                    booksService = remoteService(Constants.URL_B);

                    ui.print("Available commands for library " + library);
                    ui.print("1. Buscar Titulo [TITULO]");
                    ui.print("2. Buscar Autor [AUTOR]");

                    command = scanner.nextLine();

                    if (command.matches("Buscar Titulo \\w+")) {
                        String Title = ui.getLookUpValue(command);

                        booksViews.printBook(booksService.getTitleByName(Title));
                        ui.saveTrace(library, "getTitleByName", Title);

                    } else if (command.matches("Buscar Autor \\w+.*")) {
                        String authorName = ui.getLookUpValue(command);

                        booksViews.printBooks(booksService.getTitlesByAuthor(authorName));
                        ui.saveTrace(library, "getTitlesByAuthor", authorName);

                    } else {
                        ui.print("ERROR: Invalid input");
                    }

                    break;

                case "C":
                    booksService = remoteService(Constants.URL_C);

                    ui.print("Available commands for library " + library);
                    ui.print("1. Encontrar Vol [LIBRO]");
                    ui.print("2. Encontrar Autor [AUTOR]");

                    command = scanner.nextLine();

                    if (command.matches("Encontrar Vol \\w+")) {
                        String Vol = ui.getLookUpValue(command);

                        booksViews.printBook(booksService.getVolByNumber(Vol));
                        ui.saveTrace(library, "getVolByNumber", Vol);

                    } else if (command.matches("Encontrar Autor \\w+")) {
                        String authorName = ui.getLookUpValue(command);

                        booksViews.printBooks(booksService.getVolsByAuthor(authorName));
                        ui.saveTrace(library, "getVolsByAuthor", authorName);

                    } else {
                        ui.print("ERROR: Invalid input");
                    }

                    break;
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
