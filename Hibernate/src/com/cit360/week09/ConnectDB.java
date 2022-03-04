package com.cit360.week09;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ConnectDB {
    SessionFactory factory = null;
    Session session = null;

    private static ConnectDB single_instance = null;

    private ConnectDB() {
    factory = HibernateUtils.getSessionFactory();
    }

    /*This makes this class a singleton*/
    public static ConnectDB getInstance() {
        if (single_instance == null) {
            single_instance = new ConnectDB();
        }
        return single_instance;
    }

    //Used to get more than one employee from the database
    public List<EmployeeEntity> getEmployees() {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from com.cit360.week09.EmployeeEntity";
            List<EmployeeEntity> emp = (List<EmployeeEntity>)session.createQuery(sql).getResultList();
            session.getTransaction().commit();
            return emp;
        }

        catch (Exception e) {
            e.printStackTrace();
            //rollback the database in case of error
            session.getTransaction().rollback();
            return null;
        }
        finally {
            session.close();
        }
    }

    //get a single employee
    public EmployeeEntity getCustomer(int id) {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from com.cit360.week09.EmployeeEntity where id=" + Integer.toString(id);
            EmployeeEntity emp = (EmployeeEntity)session.createQuery(sql).getSingleResult();
            session.getTransaction().commit();
            return emp;
        }
        catch (Exception e) {
            e.printStackTrace();
            //rollback the database in case of error
            session.getTransaction().rollback();
            return null;
        }
        finally {
            session.close();
        }
    }

}
