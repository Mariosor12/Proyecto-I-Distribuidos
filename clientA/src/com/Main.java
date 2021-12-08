package com;

import java.rmi.Naming;
import java.util.*;

import com.books.services.IBooksService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Author name? ");
        String authorName = scanner.nextLine();

        scanner.close();

        try {
            IBooksService booksService = (IBooksService) Naming.lookup(Constants.URL);

            System.out.println(booksService.getBooksByAuthor(authorName));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
