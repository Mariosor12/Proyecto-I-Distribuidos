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

  private String getElementByTagName(Element element, String tagName) {
    return element.getElementsByTagName(tagName).item(0).getTextContent();
  }

  public List<Book> getBooks() {
    NodeList nodeList = this.document.getElementsByTagName("book");
    List<Book> books = new ArrayList<Book>();

    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node = nodeList.item(i);

      if (node.getNodeType() == Node.ELEMENT_NODE) {

        Element element = (Element) node;

        String libro = getElementByTagName(element, "vol");
        String autor = getElementByTagName(element, "autor");
        String editorial = getElementByTagName(element, "editorial");
        String fecha = getElementByTagName(element, "fecha");

        books.add(new Book(libro, autor, editorial, fecha, "C"));
      }
    }

    return books;
  }
}