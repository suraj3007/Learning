package main.java.com.pluralsight.facade;

import java.io.*;
import java.net.URL;

public class FacadeDemo {

    public static void main(String[] args) throws IOException {

        //URL url = new URL("http", "www.pluralsight.com", 80, "/author/bryan-hansen");
        URL url = new URL("https://www.google.com/");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

        String input;
        while ((input = bufferedReader.readLine()) != null) {
            System.out.println(input);
        }
    }
}
