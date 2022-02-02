package com.cit360.week05;

import java.util.ArrayList;
import java.util.List;

public class junitTest {

    //count the number of times a word appears
    public int countA(String word) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == 'a' || word.charAt(i) == 'A') {
                    count++;
                }
            }
            return count;
        }

    //Test for is assertFalse
    public boolean evenNumber(int number) {
            boolean result = false; //initialize the boolean
            if (number % 2 == 0) {
                result = true;
            }
            return result;
        }

    //Test for is assertTrue
    public boolean oddNumber(int number) {
            boolean result = false;
            if (number % 3 == 0) {
                result = true;
            }
            return result;
        }

    //Test for assertNotNull, assertNull, and AssertSame
    public static String getListValue(int listNo) {
        //This program takes names from an arrayList and adds them to a string.
        String Names = "";
        List<String> listOfNames = new ArrayList<String>();
        listOfNames.add("Mirabel");
        listOfNames.add("Isabel");
        listOfNames.add("Bruno");
        listOfNames.add(null);
        listOfNames.add("Mirabel");

        for (int i = 0; i< listOfNames.size(); i++) {
            Names += listOfNames.get(i) + " ";
        }
        return listOfNames.get(listNo);
    }

    /*Test for assertNotSame. The two string look the same but point to different objects.
    although they look the same the strings refer to different objects and not the same
    string literal. for example
    if String myState = "Delta" and
    String myStateAlso = "Delta" then they would be the same because they refer to the same
    string literal. In this example however, they look the same but refer to different
    String objects.*/
    public String [] sameState() {
       String myState = new String("Delta");
       String myStateAlso = new String("Delta");

       String [] stateArray = {myState, myStateAlso};

       return stateArray;
    }

    //Test for assertThat.
    public int square(int x) {
        return (int) Math.pow(x,2); //returns the square of a number
    }

    //Test for assertArrayEquals. This checks if two object arrays are equal or not.
    //It checks for length and content of the array.
    public static ArrayList<String[]> arrayOfNames() {
        String [] names1 = {"Pepa", "Mirabel", "Bruno", "Delores"};
        String [] names2 = {"Pepa", "Mirabel", "Bruno", "Delores"};
        String [] names3 = {"Pepa", "Mirabel", "Bruno", "Delores", "Luisa"};

        ArrayList<String[]> listOfArray = new ArrayList<String []>();
        listOfArray.add(names1);
        listOfArray.add(names2);
        listOfArray.add(names3);

        return listOfArray;
    }




}
