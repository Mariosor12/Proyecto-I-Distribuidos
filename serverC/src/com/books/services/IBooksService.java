package com.books.services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.books.domain.Book;

public interface IBooksService extends Remote {
  public List<Book> getBooks() throws RemoteException;

  public Book getVolByNumber(String name) throws RemoteException;

  public List<Book> getVolsByAuthor(String author) throws RemoteException;
}
