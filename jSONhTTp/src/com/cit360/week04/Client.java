package com.cit360.week04;
/*
THis is the client part of the package. It takes the JSON convert file from the server component and converts it to
a java object.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static com.cit360.week04.HTTPServer.toJSON;

public class Client {

    public static cityList cityListToObject(String fromJson) {
        ObjectMapper forCityMap = new ObjectMapper();
        cityList cityList = null;
        try {
            cityList = forCityMap.readValue(fromJson, cityList.class);
        }
        catch (JsonProcessingException jpe) {
            System.out.println("This is not working. I wonder why.");
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return cityList;
    }

    public static void main(String[] args) {
        cityList name = new cityList();
        name.setId(6616170);
        name.setName("Montignac");
        name.setState("Don't know");
        name.setCountry("France");
        name.setCoord(new double[]{1.1618, 45.185});

        String testJson = toJSON(name); //This calls the toJSON class/component

        System.out.println("THis is without json:\n" + name);
        System.out.println("This is with JSON:\n" + testJson);

        //This takes the JSON object and converts it to String and returns the object
        cityList cityList2 = cityListToObject(testJson);
        System.out.println("JSON Object to JAVa String Object: " + cityList2);
    }



}
