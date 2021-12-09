package com;

import java.rmi.Naming;
import java.util.*;

import com.books.services.IBooksService;
import com.books.views.BooksViews;
import com.ui.UIService;
import com.Trace.Trace;

public class Main {
    public static void main(String[] args) {
        BooksViews booksViews = new BooksViews();
        Scanner scanner = new Scanner(System.in);
        UIService ui = new UIService();
        Trace trace;

        ui.print("Choose a library (A, B, C or blank)");
        String library = scanner.nextLine();

        try {
            switch (library) {
                case "A":
                    IBooksService booksService = (IBooksService) Naming.lookup(Constants.URL_C);

                    ui.print("1. Get Book by title");
                    ui.print("2. Get Books by author");
                    int option = scanner.nextInt();

                    switch (option) {
                        case 1:
                            ui.print("Book title?");
                            String bookTitle = scanner.nextLine();

                            booksViews.printBook(booksService.getBookByName(bookTitle));
                            ui.saveTrace(library, "getBookByName", bookTitle);
                            break;
                        case 2:
                            ui.print("Author name?");
                            String authorName = scanner.nextLine();

                            booksViews.printBooks(booksService.getBooksByAuthor(authorName));
                            ui.saveTrace(library, "getBooksByAuthor", authorName);
                            break;
                        default:
                            break;
                    }
                    break;

                case "B":
                    break;
                default:

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
