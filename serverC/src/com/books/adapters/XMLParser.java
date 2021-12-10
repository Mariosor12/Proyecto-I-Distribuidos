package com.books.adapters;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLParser {
  Document document;

  XMLParser() {
    File booksDatabase = new File("database/bibliotecaC.xml");
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    try {
      DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
      this.document = documentBuilder.parse(booksDatabase);
      this.document.getDocumentElement().normalize();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}