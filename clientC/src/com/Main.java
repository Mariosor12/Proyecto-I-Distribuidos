package com;

import java.rmi.Naming;
import java.util.*;

import com.books.services.IBooksService;
import com.books.views.BooksViews;
import com.Trace.Trace;

public class Main {
    public static void main(String[] args) {
        BooksViews booksViews = new BooksViews();
        Trace trace;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        boolean exit = false;

        int option;
        while(!exit){
        System.out.println("1. Author");
        System.out.println("2. Vol");
        System.out.println("3. Exit");

        System.out.println("Choose the library");
        String library = scanner3.nextLine();

        switch (library) {
            case "C":
        try {

            System.out.println("Choose one of the options above");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Author name? ");
                    String authorName = scanner2.nextLine();

                    try {
                        IBooksService booksService = (IBooksService) Naming.lookup(Constants.URL);
                        booksViews.printBooks(booksService.getVolsByAuthor(authorName));
                        System.out.println("");
                        trace = new Trace("C", "getVolsByAuthor", authorName, new Date());
                        trace.guardarTraza();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.print("Vol number? ");
                    Integer authorName2 = scanner2.nextLine();

                    try {
                        IBooksService booksService = (IBooksService) Naming.lookup(Constants.URL);
                        booksViews.printBook(booksService.getVolByNumber(authorName2));
                        System.out.println("");
                        trace = new Trace("C", "getVolByNumber", authorName2, new Date());
                        trace.guardarTraza();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Only numbers between 1 and 3");
            }
        } catch (InputMismatchException e) {
            System.out.println("A number between 1 and 3 must be inserted");
            scanner.next();
        }
        break;
        case "":
        try {

            System.out.println("Choose one of the options above");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Author name? ");
                    String authorName = scanner2.nextLine();

                    try {
                        IBooksService booksService = (IBooksService) Naming.lookup(Constants.URL);
                        booksViews.printBooks(booksService.getVolsByAuthor(authorName));
                        System.out.println("");
                        trace = new Trace("C", "getVolsByAuthor", authorName, new Date());
                        trace.guardarTraza();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.print("Vol number? ");
                    Integer authorName2 = scanner2.nextLine();

                    try {
                        IBooksService booksService = (IBooksService) Naming.lookup(Constants.URL);
                        booksViews.printBook(booksService.getVolByNumber(authorName2));
                        System.out.println("");
                        trace = new Trace("C", "getVolByNumber", authorName2, new Date());
                        trace.guardarTraza();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Only numbers between 1 and 3");
            }
        } catch (InputMismatchException e) {
            System.out.println("A number between 1 and 3 must be inserted");
            scanner.next();
        }
        break;
    }
    }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        scanner.close();
        scanner2.close();
        scanner3.close();
    }
}
