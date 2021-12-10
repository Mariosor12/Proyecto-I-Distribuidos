package com.books.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import com.Trace.Trace;

import com.books.adapters.BooksXMLRepository;
import com.books.domain.Book;

public class BooksService extends UnicastRemoteObject implements IBooksService {
  BooksXMLRepository booksRepository = new BooksXMLRepository();
  List<Book> books;
  Trace trace;

  public BooksService() throws RemoteException {
    super();
    this.books = this.booksRepository.getBooks();
  }

  public List<Book> getBooks() {
    return this.books;
  }

  public Book getVolByNumber(String name) {
    try {
      synchronized (this) {
        for (Book book : this.books) {
          if (name.equals(book.getBookName())) {
            book.start();
            book.join();

            trace = new Trace("C", "getVolByNumber", name, new Date());
            trace.saveTrace();

            return book;
          }
        }
      }
    } catch (Exception e) {
      System.out.print("ERROR: Resource is in use");
    }

    return null;
  }

  public List<Book> getVolsByAuthor(String author) {
    List<Book> books = new ArrayList<Book>();

    try {
      synchronized (this) {
        for (Book book : this.books) {
          if (author.equals(book.getAuthor())) {
            book.start();
            book.join();
            books.add(book);
          }
        }
        trace = new Trace("C", "getVolsByAuthor", author, new Date());
        trace.saveTrace();
      }
    } catch (Exception e) {
      System.out.print("ERROR: Resource is in use");

    }

    return books;
  }
}
