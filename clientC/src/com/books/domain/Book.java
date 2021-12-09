package com.books.domain;

import java.beans.IntrospectionException;
import java.io.Serializable;

public class Book implements Serializable {
  private static final long serialVersionUID = 1L;
  Integer name;
  String author;
  String editorial;
  String date;
  String library;

  public Book(Integer name, String author, String editorial, String date, String library) {
    this.name = name;
    this.author = author;
    this.editorial = editorial;
    this.date = date;
    this.library = library;
  }

  public String toString() {
    return this.name + " - " + this.author + " - " + this.editorial + " - "
        + this.date + " (lib " + this.library + ")";
  }

  public Integer getName() {
    return this.name;
  }

  public String getAuthor() {
    return this.author;
  }

}
