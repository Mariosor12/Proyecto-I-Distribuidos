package com.books.adapters;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.*;

import com.books.domain.Book;

public class BooksXMLRepository extends XMLParser {
  public BooksXMLRepository() {
    super();
    getBooks();
  }

  public List<Book> getBooks() {
    NodeList nodeList = this.document.getElementsByTagName("book");
    List<Book> books = new ArrayList<Book>();

    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node = nodeList.item(i);

      if (node.getNodeType() == Node.ELEMENT_NODE) {

        Element element = (Element) node;

        String libro = element.getElementsByTagName("libro").item(0).getTextContent();
        String autor = element.getElementsByTagName("autor").item(0).getTextContent();

        books.add(new Book(libro, autor));
      }
    }

    return books;
  }
}