package com.books.domain;

import java.io.Serializable;

public class Book implements Serializable {
  private static final long serialVersionUID = 1L;
  String name;
  String author;

  public Book(String name, String author) {
    this.name = name;
    this.author = author;
  }

  public String toString() {
    return this.name + " - " + this.author;
  }

  public String getName() {
    return this.name;
  }

}
