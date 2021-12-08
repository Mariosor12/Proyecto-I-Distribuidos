package com.authors.adapters;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.*;

import com.authors.domain.Author;

public class AuthorsXMLRepository extends XMLParser {
  public AuthorsXMLRepository() {
    super();
    getAuthors();
  }

  public List<Author> getAuthors() {
    NodeList nodeList = this.document.getElementsByTagName("author");
    List<Author> authors = new ArrayList<Author>();

    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node = nodeList.item(i);

      if (node.getNodeType() == Node.ELEMENT_NODE) {

        Element element = (Element) node;

        String libro = element.getElementsByTagName("libro").item(0).getTextContent();
        String autor = element.getElementsByTagName("autor").item(0).getTextContent();

        authors.add(new Author(libro, autor));
      }
    }

    return authors;
  }
}