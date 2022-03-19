package com.cit360.week11;

import org.hibernate.Session;


import java.util.List;


public class ProcessUsers {
//TODO: I need to turn off the unique attribute on the username database. It ignores case eg.(JAMES, james)
    public static String addUser(String firstName, String lastName, String username, String password) {
        String returnMsg = "User Added Successfully";

        //Entity for the user's information
        UserInfoEntity user = new UserInfoEntity();
        //Entity for the scores
        ScoreTableEntity score = new ScoreTableEntity();

        //check for first name Entry in the database
        ConnectDB con = ConnectDB.getInstance();

        List<UserInfoEntity> userFName = con.getUsers(); //We need to change the loop so it only goes through the names

        for (int i = 0; i < userFName.size(); i++) {
            //if first name from database matches the first name given, break out
            if (firstName.equals(userFName.get(i).getFirstName())) {
                returnMsg = firstName + " has already been taken by someone else.";
                //break;
                return returnMsg;
            }
            else{
                user.setFirstName(firstName); //set the first name given
            }

        }

        for (int i = 0; i < userFName.size(); i++) {
            //if username from database matches the username given, break out
            if (username.equals(userFName.get(i).getUsername())) {
                returnMsg = username + " has already been taken by someone else.";
                //break;
                return returnMsg;
            }
            else{
                //set the username
                user.setUsername(username);
                score.setUsername(username); //to keep scores
            }

        }

                Session session = HibernateUtils.getSessionFactory().openSession();
                session.beginTransaction();

                //for the last name
                if (lastName.equals("")) {//We do this for the lastname since it is not required
                    returnMsg = "User Added Successfully with no Last name";
                }
                else {
                    user.setLastName(lastName);
                }

                //set the password
                user.setPassword(password);

                //save the user in the database
                session.save(user);
                session.save(score);

                //commit the transaction
                session.getTransaction().commit();
                //TODO add session.close
        session.close();

        return returnMsg;

        }

        //This checks for the username before entry to the game
    public static BooleanUserInfo checkUsername(String username) {
        //boolean wewantittobetrue = false;
        ConnectDB con = ConnectDB.getInstance();
        List<UserInfoEntity> user = con.getUsers();


        //This first loop checks for matching username in the database
        BooleanUserInfo theOne = new BooleanUserInfo();
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getUsername().equals(username)) {
                theOne = new BooleanUserInfo();
                theOne.setListID(i);
                theOne.setTrueOrNot(true);
                theOne.setUsername(user.get(i).getUsername());
                theOne.setPassword(user.get(i).getPassword());

                return theOne;
            }
        }


        return theOne;
    }

    //This checks for the password before entry to the game
    public static boolean checkPassword(String password, BooleanUserInfo theOne) {
        boolean wewantittobetrue = false;

        if (theOne.isTrueOrNot() == false) { //This makes sure that if there is no match in the
            //checkUsername method it doesn't throw an exception error.
            return wewantittobetrue;
        }
        if (theOne.getPassword().equals(password)) {
            wewantittobetrue = true;
        }

        return wewantittobetrue;
    }

    }

