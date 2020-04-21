package main.java.com.pluralsight.abstractFactory;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

public class AbstractFactoryDemo {

    public static void main(String[] args) throws Exception {

        String input = "<document><body><stock>AAPL</stock></body></document>";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        DocumentBuilderFactory abstractFactory = DocumentBuilderFactory.newInstance();  //AbstractFactory
        DocumentBuilder documentBuilder = abstractFactory.newDocumentBuilder();         //Factory
        Document document = documentBuilder.parse(inputStream);                         //Concrete class created from those factory

        document.getDocumentElement().normalize();
        System.out.println("Root tag: " + document.getDocumentElement().getNodeName());
        System.out.println(document.getDocumentElement().getLastChild().getTextContent());

        System.out.println(abstractFactory.getClass());
        System.out.println(documentBuilder.getClass());

    }
}
