package com.cit360.week04;
/*HTTP Server component
This component will take objects in the form of HTTP GET requests and convert them to JSON object
It will also return the converted object as a block of JSON.
*/

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
public class HTTPServer {

    public static String toJSON(cityList obj) {
        ObjectMapper toJsonMap = new ObjectMapper(); //create the object mapper
        //String objReceiver = ""; //initialize the objReceiver and add the input in a try catch block
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


}
