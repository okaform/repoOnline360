package com.cit360.week11;

import org.hibernate.Session;

import java.util.List;

public class ProcessScores {
    //THis class connects with the database and returns the high score as an int
    public static int getHighScore() {
        int highscore = 0;
        ConnectDB con = ConnectDB.getInstance();
        List<ScoreTableEntity> scores = con.getScores();

        //loop through the entire score
        for (int i = 0; i < scores.size() - 1; i++) {
            //check if the highscore value is a null
            if (scores.get(i).getHighScore() == null) {
                scores.get(i).setHighScore(0); //change that value to zero
            }
            if (scores.get(i +1).getHighScore() == null) { //This second one makes sure it gets to the last one in the list
                scores.get(i +1).setHighScore(0); //change that value to zero
            }


        }

        //which ever one is higher is returned to the first page
        for (int i = 0; i < scores.size(); i++) {
            //This makes sure that the highscore is checked
            if (scores.get(i).getHighScore() > highscore) {
                highscore = scores.get(i).getHighScore();
            }
        }

        return highscore;
    }


    public static boolean updateScores(String username, int curr_score, int high_score) {
        //retrieve info from the database
        ConnectDB con = ConnectDB.getInstance();
        List<ScoreTableEntity> scores = con.getScores();

        //add info to the database
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        ScoreTableEntity userScores= new ScoreTableEntity();

        for (int i = 0; i < scores.size(); i++) {
            //check for matching username
            if (scores.get(i).getUsername().equals(username)) {
                //we always want to update the user's last score

                scores.get(i).setLastScore(curr_score);
                //update high score if the database high score is null
                if (scores.get(i).getHighScore() == null) {
                    scores.get(i).setHighScore(curr_score);
                }

                //update high score if the curr score is greater than the db high score
                if (curr_score > scores.get(i).getHighScore()) {
                    scores.get(i).setHighScore(curr_score);
                }

                session.update(scores.get(i));
                session.getTransaction().commit();
                session.close();
                break;
            }
        }



        return true;
    }

}
