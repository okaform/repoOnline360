package com.cit360.week09.DB;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;

import  java.util.*;

public class FullEmployee {
    public static void main(String[] args) {
        //exit value to exit the program
        String usrAns = " ";
        do {
            System.out.println("Hello HR Rep. What do you want to do? ");
            System.out.println("1. Add new employee.\n" +
                    "2. See all employee's Info.\n" +
                    "3. See all employee's Names.\n" +
                    "4. See one Employee's Info.\n" +
                    "5. Exit.");

            Scanner usrInput = new Scanner(System.in);
            usrAns = usrInput.nextLine();

            //depending on the option chosen, guide the user.
            if (usrAns.equals("1")) {
                //If choice is equals to 1
                GetEmployee.addEmployee();
            }

            else if (usrAns.equals("2")) {
                //If choice is equals to 2
                GetEmployee.getInfo();
            }
            else if (usrAns.equals("3")) {
                //If choice is equals to 3
                GetEmployee.getNames();
            }
            else if (usrAns.equals("4")) {
                //If choice is equals to 4, see one employee's info
                GetEmployee.getOne(); //call the getOne class
            }
            else if (usrAns.equals("5")) {
                HibernateUtils.shutdown();
                break;
                //break out of the loop
            }
            else { //Data validation to make sure inputs 1,2,3,4 are accepted
                System.out.println("Invalid Input. Try Again. ");

            }

        }
        while (!(usrAns.equals("5"))); //I really don't need this because the loop will always break at =5 but oh well.

    }

}
