



package com.cit360.week09.DB;

import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class GetEmployee {

    public static void getOne() {
        ConnectDB con = ConnectDB.getInstance();
        List<EmployeeEntity> oneEmp = con.getEmployees();
        String empInfo = "";
        boolean canContinue = false;

        do {
            //System.out.println("The size of the employee is "+oneEmp.size());
            System.out.println("Please select an Employee ID between " +oneEmp.get(0).getId() +
                    " and " + oneEmp.get(oneEmp.size() - 1).getId() + ".");

            //get the user's information
            Scanner input = new Scanner(System.in);

            try {
                empInfo = input.nextLine();//make sure the user's input is within range

                if ((Integer.parseInt(empInfo) >= oneEmp.get(0).getId()) && (Integer.parseInt(empInfo) <= oneEmp.get(oneEmp.size() - 1).getId())) {
                    //if user's input is in range, take it and print out the employee's info.
                    EmployeeEntity em = oneEmp.get(Integer.parseInt(empInfo) - 1);//"-1" is essential so it doesn't
                    //give indexOutofBounds Exception. Interestingly, I'm going back and forth between the Starting index of
                    //arrays and the IDs of the database. The array start at zero while ids start at 1.
                    System.out.println("ID\tFirstName\t\tLastName\t\tAge");
                    System.out.printf("%-3.4s %-15.20s %-15.20s %-5s %n", em.getId(), em.getFirstName(), em.getLastName(), em.getAge() + "\n");
                    //System.out.println(em.getId()+"\t" + em.getFirstName()+"\t\t"  + em.getLastName()+"\t\t\t"  + em.getAge() + "\n");
                    canContinue = true;
                }

                else {
                    System.out.println("Invalid Input. ");
                }

            }
            catch (NumberFormatException nfe) {
                System.err.println("Invalid Input");
            }

        }
        while (canContinue == false);

    }

    public static void getNames() {
        ConnectDB con = ConnectDB.getInstance();
        List<EmployeeEntity> empNames = con.getEmployees();
        System.out.println("The Names of Employees in your Organization are: ");
        for (int i = 0; i < empNames.size(); i++) {
            System.out.println(i + 1 + ". " + empNames.get(i).getFirstName() + " " + empNames.get(i).getLastName());
        }

        System.out.println("\n");
    }

    public static void  getInfo() {
        ConnectDB con = ConnectDB.getInstance();
        List<EmployeeEntity> empNames = con.getEmployees();
        System.out.println("The Information of Employees in your Organization are: ");
        for (EmployeeEntity i : empNames) {
            System.out.println(i); //You can call the individual columns
        }

        System.out.println("\n");
    }

    public static void addEmployee() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        //Add new Employee
        EmployeeEntity emp = new EmployeeEntity();
        //Since the IDs auto increment, there's no need for for setID.
        emp.setFirstName("Kara");
        emp.setLastName("Zo-el");
        emp.setAge(25);

        //save employee in the database
        session.save(emp);


        //commit the transaction
        session.getTransaction().commit();
        //HibernateUtils.shutdown(); //I took this out of here because when this closes I can't start the session anymore. I moved it to FullEmployee.java option 5 for exit
        System.out.println("User has been added Successfully");

    }

}
