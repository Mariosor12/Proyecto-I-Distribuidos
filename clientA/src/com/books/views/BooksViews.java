package com.books.views;

import java.util.*;

import com.books.domain.Book;

class BooksViews {
  public static final String errorMessage = "No hay libros disponibles con la descripción solicitada";

  public BooksViews() {

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