package com.authors.services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.authors.domain.Author;

public interface IAuthorsService extends Remote {
    public List<Author> getAuthors() throws RemoteException;

    public Author getAuthorsByName(String name) throws RemoteException;
}
