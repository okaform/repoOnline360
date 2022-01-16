package com.cit360;

import java.util.Scanner;

public class exception {
    public static void main(String[] args) {
        //a. Gather input from the user
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Two Numbers:");
        float num1 = 1545;
        float num2 = 45678;
        String input = null;
        int counter = 0;
        boolean checker = false;

        //For num1
        while(!checker) {
            //use a try block for the first number
            try {
                System.out.print("Number 1: ");
                input = userInput.nextLine();
                num1 = Integer.parseInt(input);
                counter++;
                break; //break out of the loop when all the values are good to go.
            } catch (NumberFormatException iMe) {
                System.out.println("This is what you typed: \"" + input + "\". It contains alphabet(s). " +
                        "\nPlease try again using only ARITHMETIC NUMBERS." );
                //userInput.nextLine(); //skip the bad number
            } finally {
                if (counter == 0) {//make the finally more user-friendly.
                    System.out.println("------------------------- Trying Again. -------------------------");
                                    }
                else {
                    System.out.println("------------------------- Going to Number 2. -------------------------");
                    counter = 0; //We keep it at zero for number2 checking
                }

            }
        }
        //for num2
        while(!checker) {
            //use a try block for the first number
            try {
                System.out.print("Number 2/Denominator: ");
                input = userInput.nextLine();
                num2 = Integer.parseInt(input);
                if(num2 == 0) {
                    System.out.println("You typed\" " + input + "\". The computer cannot divide by zero. " +
                            "\nEnter a number that's not zero.");
                }
                else{
                    counter++;
                    break; //break out of the loop when all the values are good to go.
                }

            } catch (NumberFormatException iMe) {
                System.out.println("This is what you typed: \"" + input + "\". It contains alphabet(s). " +
                        "\nPlease try again using only ARITHMETIC NUMBERS." );
            } finally {
                if (counter == 0) {//make the finally more user-friendly.
                    System.out.println("------------------------- Trying Again. -------------------------");
                }
                else {
                    System.out.println("------------------------- Calculating. -------------------------");
                }
            }
        }



        //Call the doDivision method
        float divide = doDivision(num1, num2);
        //Return the result
        System.out.println(num1 + " / " +num2 + " = " + divide);


        System.out.println("------------------------- THE END. -------------------------");
    }

    static float doDivision(float num1, float num2) throws ArithmeticException {
        //b. divides two numbers and return the result
        float result = num1/num2;
        return result;
    }
}
