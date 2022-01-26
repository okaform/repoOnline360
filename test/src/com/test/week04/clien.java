package com.test.week04;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.BindException;
import java.net.URLEncoder;

public class clien {
    //TO convert from JSON to Object
    public static videoGame videoGameToObject(String fromJson) {
        ObjectMapper forCityMap = new ObjectMapper();
        videoGame videoGame = null;
        try {
            videoGame = forCityMap.readValue(fromJson, videoGame.class);
        }
        catch (JsonProcessingException jpe) {
            System.out.println("This is not working. Probably because a server instance is already running.");
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return videoGame;
    }

    public static void main(String[] args) throws IOException {
        //Start the server. If server is already started, then continue.
        String contentReturn = "Server Already Started";
        try {
            //contentReturn = JavaHTTPServer.getContent("http://localhost:8500");
            contentReturn = JavaHTTPServer.getContent("http://localhost:8500/?name="
                    +"God+of+War"
                    +"&console=PlayStation+5"
                    +"&rating=10&year=2018");
        }
        catch (BindException be) {
            System.err.println("The address is already in use. Close the old server.");
        }

        System.out.println("This is the JSON response from the HTTP Server:\n"+contentReturn);

        //take the json and return the object
        videoGame videoGameObject = videoGameToObject(contentReturn);
        System.out.println("This is the Object: " +videoGameObject);

    }

}
