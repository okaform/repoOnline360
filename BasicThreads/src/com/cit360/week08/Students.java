package com.cit360.week08;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Students implements Runnable {

    private String name;
    private List<String> subjects;
    int studyTime;
    int breakTime;


    public Students(String name, List<String> subjects ) {
        this.name  = name;
        this.subjects = subjects;
        studyTime = ThreadLocalRandom.current().nextInt(10, 100);
        breakTime = ThreadLocalRandom.current().nextInt(10, 50);

    }




    @Override
    public void run() {


        //declare credits for the classes
        int math = 4; int bus = 3; int phy = 4; int chem = 4; int cit = 6;

        //When the program starts, each student will start studying for x amount of time
        System.out.println("\n"+name +"\nStudy Time Given:" +studyTime+"\nBreak Time Given: " + breakTime +"\n");

        //run a loop that goes through the list
        for (int i = 0; i < subjects.size(); i++) { //start of first loop
            //if statement that checks for the subjects
            if (subjects.get(i).equals("MATH315")) {//for Math class
                for (int j = 1; j < math * studyTime; j++) { //the student studies the subject for x amount of time
                    if (j % 10 == 0) {
                        System.out.print(name + " is studying Math. ");
                    }

                }
                System.out.println("\n"+name + " is taking a break\n");
                try {
                    Thread.sleep(math * breakTime); //Student takes a break before moving on to next subject
                }
                catch (InterruptedException ie) {
                    System.err.println(ie.toString());

                }
                System.out.println(name + " is done with their Math Study and Rest.\n");

            }
            else if (subjects.get(i).equals("BUS301")) {//for business class
                for (int j = 1; j < math * studyTime; j++) { //the student studies the subject for x amount of time
                    if (j % 10 == 0) {
                        System.out.print(name + " is studying Business. ");
                    }

                }
                System.out.println("\n"+name + " is taking a break\n");
                try {
                    Thread.sleep(math * breakTime); //Student takes a break before moving on to next subject
                }
                catch (InterruptedException ie) {
                    System.err.println(ie.toString());

                }
                System.out.println(name + " is done with their Business Study and Rest.\n");

            }
            else if (subjects.get(i).equals("PHY406")) {//physic lab class
                for (int j = 1; j < math * studyTime; j++) { //the student studies the subject for x amount of time
                    if (j % 10 == 0) {
                        System.out.print(name + " is studying Physics Lab materials. ");
                    }

                }
                System.out.println("\n"+name + " is taking a break\n");
                try {
                    Thread.sleep(math * breakTime); //Student takes a break before moving on to next subject
                }
                catch (InterruptedException ie) {
                    System.err.println(ie.toString());

                }
                System.out.println(name + " is done with their Physics lab and Rest.\n");

            }
            else if (subjects.get(i).equals("CHEM301")) {//chemistry class
                for (int j = 1; j < math * studyTime; j++) { //the student studies the subject for x amount of time
                    if (j % 10 == 0) {
                        System.out.print(name + " is studying Chemistry. ");
                    }

                }
                System.out.println("\n"+name + " is taking a break\n");
                try {
                    Thread.sleep(math * breakTime); //Student takes a break before moving on to next subject
                }
                catch (InterruptedException ie) {
                    System.err.println(ie.toString());

                }
                System.out.println(name + " is done with their Chem Study and Rest.\n");

            }
            else if (subjects.get(i).equals("CIT360")) { //Object Oriented Development class
                for (int j = 1; j < math * studyTime; j++) { //the student studies the subject for x amount of time
                    if (j % 10 == 0) {
                        System.out.print(name + " is writing code. ");
                    }

                }
                System.out.println("\n"+name + " is taking a break");
                try {
                    Thread.sleep(math * breakTime); //Student takes a break before moving on to next subject
                }
                catch (InterruptedException ie) {
                    System.err.println(ie.toString());

                }
                System.out.println(name + " is done with their Programming and Resting.\n");

            }
            else {
                for (int j = 1; j < studyTime; j++) {
                    if (j % 10 == 0) {
                        System.out.print(name + " is wasting away by not studying or resting.\n");
                    }

                }

            }
        } //end of first loop



        //after the program is done
        System.out.println(name +" is done with Studying.\n\n");


    }
}
