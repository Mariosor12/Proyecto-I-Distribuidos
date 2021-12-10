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

  public Book getBookByName(String name) {
    try {
      synchronized (this) {
        for (Book book : this.books) {
          if (name.equals(book.getBookName())) {
            trace = new Trace("A", "getBookByName", name, new Date());
            trace.saveTrace();

            book.start();
            book.join();

            return book;
          }
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  public List<Book> getBooksByAuthor(String author) {
    List<Book> books = new ArrayList<Book>();

    for (Book book : this.books) {
      if (author.equals(book.getAuthor())) {
        books.add(book);
      }
    }
    trace = new Trace("A", "getBooksByAuthor", author, new Date());
    trace.saveTrace();
    return books;
  }
}
