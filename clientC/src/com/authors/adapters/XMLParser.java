package com.authors.adapters;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLParser {
  Document document;

  XMLParser() {
    File authorsDatabase = new File("database/bibliotecaA.xml");
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    try {
      DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
      this.document = documentBuilder.parse(authorsDatabase);
      this.document.getDocumentElement().normalize();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}