package com.cit360.week08;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudentsStudy {
    public static void main(String[] args) {
        ExecutorService myService = Executors.newFixedThreadPool(3);


        Students student1 = new Students("Marvel", List.of("CIT360", "MATH315", "BUS301", "CHEM301", "PHY406"));
        Students student2 = new Students("Powell", List.of("CIT360", "MATH315", "BUS301", "CHEM301", "PHY406"));
        Students student3 = new Students("John", List.of("CIT360", "MATH315", "BUS301", "CHEM301", "PHY406"));
        Students student4 = new Students("Christine", List.of("CIT360", "MATH315", "BUS301", "CHEM301", "PHY406"));
        Students student5 = new Students("Max", List.of("Horizon: Forbidden West", "MATH315", "BUS301", "CHEM301", "PHY406", "Tennis"));

        myService.execute(student1);
        myService.execute(student2);
        myService.execute(student3);
        myService.execute(student4);
        myService.execute(student5);


        myService.shutdown();
    }
}
