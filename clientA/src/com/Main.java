package com;

import java.rmi.Naming;
import java.util.*;

import com.books.services.IBooksService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        boolean exit = false;
        int option;

            System.out.println("1. Author");
            System.out.println("2. Book");
            System.out.println("3. Exit");

            try {
 
                System.out.println("Write one of the option");
                option = scanner.nextInt();
                
                switch (option) {
                    case 1:
                        System.out.print("Author name? ");
                        String authorName = scanner2.nextLine();

                        scanner2.close();

                        try {
                        IBooksService booksService = (IBooksService) Naming.lookup(Constants.URL);
                        System.out.println(booksService.getBooksByAuthor(authorName));
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
                            System.out.println(booksService.getBookByName(authorName2));
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
                System.out.println("Debes insertar un número");
                scanner.next();
            }
        scanner.close();
    }
}
