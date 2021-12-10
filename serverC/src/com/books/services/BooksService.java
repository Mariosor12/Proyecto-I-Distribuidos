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
  Thread thread = new Thread();

  public BooksService() throws RemoteException {
    super();
    this.books = this.booksRepository.getBooks();
    thread.start();
  }

  public List<Book> getBooks() {
    return this.books;
  }

  public Book getVolByNumber(String name) {
    try {
      synchronized (this) {
        thread.join();

        for (Book book : this.books) {
          if (name.equals(book.getBookName())) {

            trace = new Trace("C", "getVolByNumber", name, new Date());
            trace.saveTrace();

            return book;
          }
        }
        trace = new Trace("C", "getVolByNumber", "No book found", new Date());
        trace.saveTrace();
      }
    } catch (Exception e) {
      System.out.println("ERROR: Resource is in use");
    }

    return null;
  }

  public List<Book> getVolsByAuthor(String author) {
    List<Book> books = new ArrayList<Book>();

    try {
      synchronized (this) {
        thread.join();

        for (Book book : this.books) {
          if (author.equals(book.getAuthor())) {
            books.add(book);
          }
        }

      }
    } catch (Exception e) {
      System.out.println("ERROR: Resource is in use");
    }

    if (books.isEmpty()) {
      trace = new Trace("C", "getVolsByAuthor", "No books found", new Date());
      trace.saveTrace();
    } else {
      trace = new Trace("C", "getVolsByAuthor", author, new Date());
      trace.saveTrace();
    }

    return books;
  }
}
