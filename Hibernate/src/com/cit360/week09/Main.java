package com.cit360.week09;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        //How to insert into a database
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        //query a table
        Query query = session.createQuery("select m.firstName, m.lastName from com.cit360.week09.EmployeeEntity m");
        List<EmployeeEntity> emp = query.list();
        System.out.println(emp);
        //query a table


/*
        //Add new Employee
        EmployeeEntity emp = new EmployeeEntity();
        emp.setId(75);
        emp.setFirstName("Mikanos");
        emp.setLastName("Greek");
        emp.setAge(60);

        //save employee in the database
        session.save(emp);


        //commit the transaction
        session.getTransaction().commit();
        HibernateUtils.shutdown();*/
    }
}
