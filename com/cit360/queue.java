package com.cit360;

import java.util.*;

//create a class that does error validation


public class queue {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>(); // define the queue
        Scanner userInput = new Scanner(System.in); //for getting user input
        System.out.println("Please enter the length of the queue: ");
        //add a checker to make sure the values are integers
        int len = 5;
        boolean checker = false;
        while (!checker){ //error validation
            try {
                len = userInput.nextInt();
                break;
            }
            catch (Exception e) {
                userInput.nextLine(); //skip over the bad input
                System.out.println("Your input is needs only numbers. Please check your input. ");
            }
        }
        //add elements to the queue and perform error checking
        System.out.println("Please enter the elements of the Queue. ");
        for (int i = 0; i < len; i++) {
            while (!checker) {
                try {
                    q.add(userInput.nextInt());
                    if (i <= len) {
                        break;
                    }

                }
                catch (Exception ex) {
                    userInput.nextLine(); //skip over the bad input
                    System.out.println("Your input is needs only numbers. Please check your input. ");
                }
            }
        }

        System.out.println(q);
        Iterator iterator = q.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ") ;
        }

      /*  System.out.println("Enter your Age in numbers:");
        int age = 0;
        boolean test = false;
        while (!test) {
            try {
                age = userInput.nextInt();
                if (age == (int) age) {
                    test = true;
                }

            }
            catch (Exception e) {
                userInput.nextLine(); //skip over the bad input
                System.out.println("Your input is needs only numbers. Please check your input. ");
            }


        } */




    }
}
