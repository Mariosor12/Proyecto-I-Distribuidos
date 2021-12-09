package com;

import java.rmi.Naming;
import java.util.*;

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
            int option;
            Trace trace;

            ui.print("Choose a library (A, B, C or blank)");
            String library = scanner.nextLine();

            switch (library) {
                case "A":
                    booksService = remoteService(Constants.URL_A);

                    ui.print("1. Get Book by name");
                    ui.print("2. Get Books by author");
                    option = scanner.nextInt();

                    switch (option) {
                        case 1:
                            ui.print("Book title?");
                            // String bookTitle = scanner.nextLine();
                            String bookTitle = "Dune";

                            booksViews.printBook(booksService.getBookByName(bookTitle));
                            ui.saveTrace(library, "getBookByName", bookTitle);
                            break;
                        case 2:
                            ui.print("Author name?");
                            String authorName = scanner.nextLine();

                            booksViews.printBooks(booksService.getBooksByAuthor(authorName));
                            // ui.saveTrace(library, "getBooksByAuthor", authorName);
                            break;
                        default:
                            break;
                    }
                    break;

                case "B":
                    booksService = remoteService(Constants.URL_B);

                    ui.print("1. Get Book by title");
                    ui.print("2. Get Books by author");
                    option = scanner.nextInt();

                    switch (option) {
                        case 1:
                            ui.print("Book title?");
                            // String bookTitle = scanner.nextLine();
                            String bookTitle = "Dune";

                            booksViews.printBook(booksService.getTitleByName(bookTitle));
                            // ui.saveTrace(library, "getBookByName", bookTitle);
                            break;
                        case 2:
                            ui.print("Author name?");
                            String authorName = scanner.nextLine();

                            booksViews.printBooks(booksService.getTitlesByAuthor(authorName));
                            // ui.saveTrace(library, "getBooksByAuthor", authorName);
                            break;
                        default:
                            break;
                    }
                    break;
                default:

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
