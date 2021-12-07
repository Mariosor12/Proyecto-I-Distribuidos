package com.books.domain;

import java.io.Serializable;

public class Book implements Serializable {
  private static final long serialVersionUID = 1L;
  String name;
  String author;
  String editorial;
  String fecha;

  public Book(String name, String author, String editorial, String fecha) {
    this.name = name;
    this.author = author;
    this.editorial = editorial;
    this.fecha = fecha;
  }

  public String toString() {
    return this.name + " - " + this.author+ " - " + this.editorial + " - " + this.fecha;
  }

  public String getName() {
    return this.name;
  }

}
