package com.cit360.week11;

import java.util.Collections;
import java.util.List;

public class FastTest {
    public static void main(String[] args) {
        ConnectDB son = ConnectDB.getInstance();
        List<ScoreTableEntity> scores = son.getScores();

        Collections.sort(scores,  new ScoreTableEntity.SortbyHighScore()); //I used the comparator interface for this
        //System.out.println(scores);
        System.out.println("Individual Scores with Username: ");
        for (int i = 0; i <scores.size(); i++) {
            System.out.println("Usernames: "+scores.get(i).getUsername() +" HighScores: "+ scores.get(i).getHighScore());
        }

        System.out.println("\n\n\n");
        int count = 0; //this makes sure we only display the top 5 users
        for (int i = scores.size() -1; i >= 0; i--) {
            System.out.println("Usernames: "+scores.get(i).getUsername() +" HighScores: "+ scores.get(i).getHighScore());
            count++;
            if (count ==10) {
                break;
            }
        }
    }
}
