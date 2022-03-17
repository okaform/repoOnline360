package com.cit360.week11;

import java.util.List;

public class ProcessScores {
    //THis class connects with the database and returns the highscore as an int
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

            //which ever one is higher is returned.
            if (scores.get(i).getHighScore() > scores.get(i + 1).getHighScore()) {
                highscore = scores.get(i).getHighScore();
            }

        }

        return highscore;
    }

}
