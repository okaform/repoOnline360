package com.cit360.week06;

import java.util.Scanner;


public class ATMmachine {
    // Declaring RESET so that we can reset the color
    public static final String RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    public static final String RED = "\u001B[31m";

    //For YELLOW
    public static final String YELLOW = "\\u001B[33m\t";

    public static void main(String[] args) {
        // Create the accounts with array
        Account[] accountStorage = new Account[10];
        //create the name and password with array
        namePassword[] namePassword = new namePassword[10];

        //Use a loop to store the accounts in an array and also the name and password.
        for (int i = 0; i < 10; i++) {
            accountStorage[i] = new Account(i, 100);
            namePassword[i] = new namePassword(i,"Default name","Default Password");
        }

        int exitProgram = 0;
        while (exitProgram != 14) {
            //Ask the User to enter an Id
            System.out.println(" Enter Your Bank ID (0-9) " +
                             "OR type "+RED+"14 "+RESET+"and press Enter to End the program. ");
            Scanner input = new Scanner(System.in);
            int userId = input.nextInt();
            int correctId = 0;
            //add a counter, so we don't run Enter your bank ID twice in the statement.
            int counter = 0;

            int counter1 = 0;
            //make the exitProgram variable equal to the userId if the userId is equal to 14
            if (userId == 14) {
                exitProgram = userId;
                break;
            }
            do {
                counter1++;


                do {
                    if (counter == 0) {
                        counter++;
                    } else {
                        System.out.println("\nEnter Your Bank ID (0-9) " +
                                         " OR type "+RED+"14 "+RESET+"and Press Enter End the program. ");
                        userId = input.nextInt();
                        counter++;
                        if (userId == 14) {
                            System.exit(0); //close the program instead of breaking out of the loop
                        }
                    }
                    //used to check and select account based on the number the user chooses.
                    for (int i = 0; i < 10; i++) {
                        if (userId == accountStorage[i].getId()) {
                            correctId = i;
                            //before we break, get the user to create their name and password
                            if (namePassword[i].getName().equals("Default name")) {
                                while ((namePassword[i].getName().equals("Default name")) || (namePassword[i].getPassword().equals("Default Password"))) {
                                    System.out.println(RED + "This account has not yet been created. Please create name and Password: " + RESET);
                                    System.out.print("Name: ");
                                    input.nextLine();
                                    String accName = input.nextLine();
                                    namePassword[i].setName(accName);

                                    String pass = "null";
                                    String newPass = "im not empty";
                                    while (!(pass.equals(newPass))) {
                                        //create their password
                                        System.out.print("Password: ");
                                        pass = input.nextLine();
                                        System.out.print("Confirm Password: ");
                                        newPass = input.nextLine();

                                        if(!(pass.equals(newPass))){//compare the passwords
                                            System.out.println("The passwords do not match. Try Again");
                                        }
                                        else { //set the password
                                            namePassword[i].setPassword(newPass);
                                        }
                                    }

                                }
                        } else { //ask the user for their name and password and let them into their account
                                System.out.println("Welcome! Please put your name and password to log in.");
                                String logName;
                                String logPass;
                                boolean hasPassed = true;
                                while(hasPassed) { //(logName.equals(namePassword[i].getName())) && (logPass.equals(namePassword[i].getPassword()))
                                    input.nextLine(); //clear the name output
                                    System.out.print("Name: ");
                                    logName = input.nextLine();
                                    System.out.print("Password: ");
                                    logPass = input.nextLine();

                                    //These will only run when the name or password is incorrect.
                                    if (!(logName.equals(namePassword[i].getName())) || !(logPass.equals(namePassword[i].getPassword()))) {
                                        System.out.println("The name and/or password is not matching. Press Enter and Try again");
                                    }
                                    //Adding the hasPassed boolean makes sure the user is give the chance to add their names
                                    else{
                                        hasPassed = false;
                                    }
                                }

                            }
                            break;
                        }
                    else {
                            continue;
                        }
                    }

                }

                while (userId != accountStorage[correctId].getId());


                String choice = "";
                int counter2 = 0;
                do {
                    if (counter2 == 0) {
                        //Print out their name depending on the account.
                        System.out.println("\nWelcome " + namePassword[correctId].getName() + "!");
                        System.out.print("Main Menu"
                                + "\n1: Check balance"
                                + "\n2: withdraw"
                                + "\n3: deposit"
                                + "\n4: exit"
                                + "\nEnter a choice: ");
                        choice = input.nextLine();
                        counter2++;
                        //Selection for Choices
                        if (choice.equals("1")) {
                            System.out.printf("Your balance is $%.2f\n", accountStorage[correctId].getBalance());
                            counter2--;
                        } else if (choice.equals("2")) {
                            double currentBal = accountStorage[correctId].getBalance();
                            double withdrawMoney = Calculations.checkWithdrawal(currentBal);
                            accountStorage[correctId].withdraw(withdrawMoney);
                            counter2--;
                        } else if (choice.equals("3")) {
                            double depositMoney = Calculations.checkDeposit();
                            accountStorage[correctId].deposit(depositMoney);
                            counter2--;
                        } else if (choice.equals("4")) {
                            break;
                        } else { //Data Validation to make sure it only accepted inputs are 1,2,3,4
                            System.out.println(RED+ "Invalid Input. Try again." +RESET);
                            counter2--;
                        }

                    }

                    //Selection to continue
                    else {
                        counter2++;
                        //continue;

                    }

                }

                while (!(choice.equals("4")));


            }
            while (counter1 != 0);
        }
    }
}

