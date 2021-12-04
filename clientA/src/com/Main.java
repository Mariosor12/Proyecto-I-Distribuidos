package com;

import java.rmi.Naming;
import java.util.*;

import com.books.services.IBooksService;
import com.books.domain.Book;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Book name? ");
        String bookName = scanner.nextLine();

        scanner.close();

        try {
            IBooksService booksService = (IBooksService) Naming.lookup(Constants.URL);

            System.out.println(booksService.getBookByName(bookName));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
