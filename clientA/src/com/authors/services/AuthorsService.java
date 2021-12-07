package com.authors.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import com.authors.adapters.AuthorsXMLRepository;
import com.authors.domain.Author;

public class AuthorsService extends UnicastRemoteObject implements IAuthorsService {
    AuthorsXMLRepository authorRepository = new AuthorsXMLRepository();
  List<Author> authors;

  public AuthorsService() throws RemoteException {
    super();
    this.authors = this.authorRepository.getAuthors();
  }

  public List<Author> getAuthors() {
    return this.authors;
  }

  public Author getAuthorsByName(String name) {
    for (Author author : this.authors) {
      if (name.equals(author.getName())) {
        return author;
      }
    }

    return null;
  }
}
