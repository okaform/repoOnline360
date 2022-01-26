package com.cit360.week04;

import java.net.*;
import java.io.*;

import java.net.HttpURLConnection;
import java.util.*;

public class HTTPExample {


    public static String getHTTPContent(String string) {

        try {
            URL url = new URL(string); //set up a url
            HttpURLConnection http = (HttpURLConnection) url.openConnection(); //establish a connection
            http.setRequestMethod("GET"); // set the request method to GET

            BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream())); //set up an input stream
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while((line = reader.readLine()) != null) {// keep reading the line until is not. then drop out of the loop.
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();
        }
        catch (IOException e) {
            System.err.println(e.toString());
        }
        return "Error";
    }


    public static Map getHttpHeaders(String string) {

        try {
            URL url = new URL(string); //set up a url
            HttpURLConnection http = (HttpURLConnection) url.openConnection(); //establish a connection

            return http.getHeaderFields(); // return the headers in a form of a map
        }
        catch (IOException e) {
            System.err.println(e.toString());
        }

        return null;
    }


    public static void main(String[] args) {
        System.out.println(HTTPExample.getHTTPContent("http://localhost:8500")); //reach out to the server




       /* Map<Integer, List<String>> m = HTTPExample.getHttpHeaders("http://www.google.com");

        for (Map.Entry<Integer, List<String>> entry: m.entrySet()) {
            System.out.println("Key= " + entry.getKey() + "value= " + entry.getValue());
        }*/
    }
}
