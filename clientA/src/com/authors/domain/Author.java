package com.authors.domain;

import java.io.Serializable;

public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
  String name;
  String author;

  public Author(String name, String author) {
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
