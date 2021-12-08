package com.books.domain;

import java.io.Serializable;

public class Book implements Serializable {
  private static final long serialVersionUID = 1L;
  String name;
  String author;
  String editorial;
  String date;

  public Book(String name, String author, String editorial, String date) {
    this.name = name;
    this.author = author;
    this.editorial = editorial;
    this.date = date;
  }

  public String toString() {
    return this.name + " - " + this.author + " - " + this.editorial + " - " + this.date;
  }

  public String getName() {
    return this.name;
  }

  public String getAuthor() {
    return this.author;
  }

}
