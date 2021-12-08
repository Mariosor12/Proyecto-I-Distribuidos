package com;

import java.rmi.Naming;
import java.util.*;

import com.books.services.IBooksService;
import com.books.views.BooksViews;

public class Main {
    public static void main(String[] args) {
        BooksViews booksViews = new BooksViews();

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        boolean exit = false;

        int option;

        System.out.println("1. Author");
        System.out.println("2. Book");
        System.out.println("3. Exit");

        try {

            System.out.println("Choose one of the options above");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Author name? ");
                    String authorName = scanner2.nextLine();

                    scanner2.close();

                    try {
                        IBooksService booksService = (IBooksService) Naming.lookup(Constants.URL);

                        booksViews.printBooks(booksService.getBooksByAuthor(authorName));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.print("Book name? ");
                    String authorName2 = scanner2.nextLine();

                    scanner2.close();

                    try {
                        IBooksService booksService = (IBooksService) Naming.lookup(Constants.URL);
                        booksViews.printBook(booksService.getBookByName(authorName2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 4");
            }
        } catch (InputMismatchException e) {
            System.out.println("A number between 1 and 3 must be inserted");
            scanner.next();
        }

        scanner.close();
    }
}
