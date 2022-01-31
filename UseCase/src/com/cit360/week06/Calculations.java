package com.cit360.week06;
/*
* This class does the error handling for the withdrawal and deposit values. */

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.cit360.week06.ATMmachine.RED;
import static com.cit360.week06.ATMmachine.RESET;

public class Calculations {
    //This is for when the withdrawal option is selected
    public static double checkWithdrawal( double currentBalance) {
        boolean checker = true;
        //int counter = 0; //a counter to know if we should ask for the user's input at first
        String valueAsString;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an amount to withdraw");

        double choice = 0;
        while (checker) {
            try {
                    choice = scanner.nextDouble();
                    valueAsString = String.valueOf(choice);

                //for negative number
                if (valueAsString.charAt(0) == '-') {
                    System.out.println(RED + "You cannot add negative symbols to your balance. Please Try Again." + RESET);
                    System.out.print("Enter an amount to withdraw: ");

                } else if (choice > currentBalance) { //This makes sure that the user doesn't get to a negative
                    System.err.println("You have entered a value greater than your negative balance." +
                            "You entered " + choice + " while your current balance is $" + currentBalance +
                            ". Please Try again");
                } else {
                    checker = false;
                }
            }//For putting strings
            catch (InputMismatchException iMe) {
                System.err.println("You cannot have letters in your input. Please Try Again.");
                System.out.print("Enter an amount to withdraw: ");
                scanner.nextLine();

            }
            //return "Error";
        }
        return choice;
    }
    //This is for when the deposit option is selected
    public static double checkDeposit() {
        //This is for when the deposit option is selected
            boolean checker = true;
            //int counter = 0; //a counter to know if we should ask for the user's input at first
            String valueAsString;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter an amount to Deposit");

            double choice = 0;
            while (checker) {
                try {
                    choice = scanner.nextDouble();
                    valueAsString = String.valueOf(choice);

                    //for negative number
                    if (valueAsString.charAt(0) == '-') {
                        System.out.println(RED + "You cannot add negative symbols to your balance. Please Try Again." + RESET);
                        System.out.print("Enter an amount to Deposit: ");

                    }  else {
                        checker = false;
                    }
                }//For putting strings
                catch (InputMismatchException iMe) {
                    System.err.println("You cannot have letters in your input. Please Try Again.");
                    System.out.print("Enter an amount to Deposit: ");
                    scanner.nextLine();

                }
                //return "Error";
            }
            return choice;
    }
}
