package com.books.domain;

public class Book {
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
