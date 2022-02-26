package com.cit360.week08;

import javax.swing.*;
import java.util.Scanner;

public class testExecute implements Runnable {

    @Override
    public void run() {
        Scanner input = new Scanner(System.in);

        System.out.println("What is your name");
        String name = input.nextLine();
        System.out.println("Your name is " + name);
    }
}
