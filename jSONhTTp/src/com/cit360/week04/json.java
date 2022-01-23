package com.cit360.week04;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;


public class json {

    public static String customertoJSON(Customer customer) {
        ObjectMapper mapper = new ObjectMapper();
        String s = "";

        try {
            s = mapper.writeValueAsString(customer);
            //System.out.println("Printing the s class: " + s);
        }
        catch (JsonProcessingException je) {
            System.err.println(je.toString());
        }

        return s;
    }

    public static Customer JSONToCustomer(String s) {
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = null;

        try{
            customer = mapper.readValue(s, Customer.class);
        }
        catch (JsonProcessingException je) {
            System.err.println(je.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customer;
    }

    public static void main(String[] args) {
        Customer cust = new Customer();
        cust.setName("Marvel");
        cust.setPhone("313-502-1785");

        String json = customertoJSON(cust);
        System.out.println("Customer to json: " + json);
        System.out.println("--------------------------");
        System.out.println("json length = "  + json.length());
        System.out.println("-------------END OF CUSTOMER 1-------------");


        //cust 2 - converts the json to a string
        Customer cust2 = JSONToCustomer(json);
        System.out.println("JSON to customer: " + cust2);

        ObjectMapper map = new ObjectMapper();
        String s = "";
        String cl = "Marvel: elder tree: the second: brother humiliate";

        try {
            s = map.writeValueAsString(cl);
        }
        catch(JsonProcessingException e) {
            System.err.println("You got it");
        }

        System.out.println(s);
        System.out.println(cl);
    }
}
