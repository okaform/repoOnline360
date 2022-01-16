package com.cit360;

import java.util.Scanner;

public class collections {
    public static void main(String[] args) {
        int exit = 0;
        int counter = 0; //this makes sure that we go through the loop once
        System.out.println("Welcome! Pick one by pressing the corresponding number to get started. \n" +
                "1. list\n" +
                "2. Queue\n" +
                "3. Tree\n" +
                "4. Set\n" +
                "5. Exit");
        Scanner userInput = new Scanner(System.in);
        int userAnswer = userInput.nextInt();
        if (userAnswer == 5) {
            System.out.println("Thank you for trying my program");
        }
        else {//continue with the code
            while (userAnswer !=5) {
                switch (userAnswer) {
                    case 1: //for list
                        System.out.println("----------List---------");
                        break;
                    case 2: //for Queue
                        System.out.println("----------Queue---------");
                        break;
                    case 3: //for Set
                        System.out.println("----------set---------");
                        break;
                    case 4: //for Tree
                        System.out.println("----------Tree---------");
                        break;
                }
            }





        }


    }
}
