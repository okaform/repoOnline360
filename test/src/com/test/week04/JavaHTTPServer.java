package com.test.week04;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;


public class JavaHTTPServer {
    public static String getContent(String s) throws IOException {
        int checker = 0;
        //run a code that starts the http server
        String serverStart = startServer(checker);
        System.out.println(serverStart);

        //send the URL string to the getHTTPContent method that does the URL and accepts GET request
        String getRequest = getHTTPContent(s);


        return getRequest;
    }

    //To start the server and use checker to make sure that the server stops
    public static String startServer(int checker) throws IOException {
        //HttpServer server = null;
     /*   if (checker == 1) {
            server.stop(10);
            return "Server has Stopped.";

        } else { */

        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8500), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(JavaHTTPServer::handleRequest);
        //System.out.println("This is the handler "+context.getHandler().toString());
        server.start();
        return "Server has started on localhost at port 8500";

    }

    //To handle requests
    public static void handleRequest(HttpExchange exchange) throws IOException {
        String requestURI;
        int checker = 0;
        String response = "Testing";
        System.out.println("---------start of request handler");
        if (exchange.getRequestURI().toString().equals("/")) { //handle request when there is no request parameter
            response = "Hi! No Request Parameters but that's okay.";
        }
        else {
            //take the object and set it to objects
            videoGame godOfWar = new videoGame();
            godOfWar.setName(exchange.getRequestURI().toString().split("//?")[1].split("[=&]+")[1].replace("+", " "));
            godOfWar.setConsole(exchange.getRequestURI().toString().split("//?")[1].split("[=&]+")[3].replace("+", " "));
            godOfWar.setRating(Integer.parseInt(exchange.getRequestURI().toString().split("//?")[1].split("[=&]+")[5]));
            godOfWar.setYear(Integer.parseInt(exchange.getRequestURI().toString().split("//?")[1].split("[=&]+")[7]));

            String getJson = toJSON(godOfWar);

            /*System.out.println("Encoded String: " +exchange.getRequestURI().toString());
            String name = exchange.getRequestURI().toString().split("//?")[1].split("[=&]+")[1].replace("+", " ");
            String console = exchange.getRequestURI().toString().split("//?")[1].split("[=&]+")[3].replace("+", " ");
            int rating = Integer.parseInt(exchange.getRequestURI().toString().split("//?")[1].split("[=&]+")[5]);
            int year = Integer.parseInt(exchange.getRequestURI().toString().split("//?")[1].split("[=&]+")[7]);

            System.out.println("This is exchange: "+name +" " +console+ " " +rating+ " " +year);*/

            response = getJson;
        }

        System.out.println(response);
        exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
        OutputStream os = exchange.getResponseBody();

        os.write(response.getBytes(StandardCharsets.UTF_8));
        os.close();
        exchange.close();
    }

    //for creating the actual URL and GET Method
    public static String getHTTPContent(String s) {

        try {
            int checker = 1;
            URL url = new URL(s); //set up a url
            HttpURLConnection http = (HttpURLConnection) url.openConnection(); //establish a connection
            http.setRequestMethod("GET"); // set the request method to GET

            BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream())); //set up an input stream
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while((line = reader.readLine()) != null) {// keep reading the line until is not. then drop out of the loop.
                stringBuilder.append(line + "\n");
            }
            //call the server stop here with checker value = 1. This makes sure the server is stopped
            //and the code can be run again
            //startServer(checker);
            return stringBuilder.toString();
        }
        catch (IOException e) {
            System.err.println(e.toString());
        }
        return "Error";
    }

    //Using Jackson to convert the object to JSON
    public static String toJSON(videoGame obj) {
        ObjectMapper toJsonMap = new ObjectMapper(); //create the object mapper
        String objReceiver2 = "";
        try {
            //objReceiver = toJsonMap.writeValueAsString((obj));
            objReceiver2 = toJsonMap.writerWithDefaultPrettyPrinter().writeValueAsString(obj); //pretty print
        }
        catch (JsonProcessingException jpe) {
            System.out.println("Something is wrong somewhere");
        }

        return objReceiver2;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(JavaHTTPServer.getContent("http://localhost:8500"));
    }

}
