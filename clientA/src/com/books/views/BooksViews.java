package com.books.views;

import java.util.*;

import com.books.domain.Book;

public class BooksViews {
  public static final String errorMessage = "No books found";

  public BooksViews() {
  }

  public String getStringInput(String prompt) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

    scanner.close();

    return input;
  }

  private void printNotFound() {
    System.out.print(errorMessage);
  }

  public void printBook(Book book) {
    if (Objects.isNull(book)) {
      printNotFound();
    } else {
      System.out.println(book);
    }
  }

  public void printBooks(List<Book> books) {
    if (books.isEmpty()) {
      printNotFound();
    } else {
      for (Book book : books) {
        printBook(book);
      }
    }
  }
}