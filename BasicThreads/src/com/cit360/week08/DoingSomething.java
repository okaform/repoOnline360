package com.cit360.week08;

import java.util.Random;
import java.util.Scanner;

public class DoingSomething implements Runnable {

    private String name;
    private int number;
    private int sleep;
    private int rand;

    public DoingSomething(String name, int number, int sleep) {
        this.name = name;
        this.number = number;
        this.sleep = sleep;

        Random random = new Random();
        this.rand = random.nextInt(1000);
    }


    @Override
    public void run() {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Put your Name");
//        String name2 = input.nextLine();
//
//        System.out.println("Your name is " + name2);


        System.out.println("\n\n" +"Executing with these parameters: Name = " + name + " Number= " +number
        + " Sleep setting = " + sleep + " Random number = " +rand +"\n\n");

        for (int count = 1; count < rand; count++) {
           /* System.out.println(name + " running at " + count);*/
            if (count % number == 0) {
                System.out.print(name + " is sleeping. ");
                try{
                    //System.out.println("Current Thread for " + name +" is - " +Thread.currentThread().getName());
                    //System.out.println("Testing " + Thread.currentThread().getName().split("-")[3]);
                    Thread.sleep(sleep);
                }
                catch (InterruptedException ie) {
                    System.err.println(ie.toString());
                }
            }
        }
        System.out.println("\n\n"+name + " is done.\n\n");

    }
}
