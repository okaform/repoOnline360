package com.cit360.week11;

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

    //Used to get more than one user from the database
    public List<UserInfoEntity> getUsers() {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from com.cit360.week11.UserInfoEntity";
            List<UserInfoEntity> users = (List<UserInfoEntity>)session.createQuery(sql).getResultList();
            session.getTransaction().commit();
            return users;
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

    //get a single user
    public UserInfoEntity getUser(int id) {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from com.cit360.week11.UserInfoEntity where id=" + Integer.toString(id);
            UserInfoEntity users = (UserInfoEntity)session.createQuery(sql).getSingleResult();
            session.getTransaction().commit();
            return users;
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

    //multiple scores
    public List<ScoreTableEntity> getScores() {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from com.cit360.week11.ScoreTableEntity";
            List<ScoreTableEntity> scores = (List<ScoreTableEntity>)session.createQuery(sql).getResultList();
            session.getTransaction().commit();
            return scores;
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

    //get a single score
    public ScoreTableEntity getScore(String username) {
        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from com.cit360.week11.ScoreTableEntity where username=" + username;
            ScoreTableEntity score = (ScoreTableEntity)session.createQuery(sql).getSingleResult();
            session.getTransaction().commit();
            return score;
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