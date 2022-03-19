package com.cit360.week11;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "Servlet_High_Score", urlPatterns = {"/high_score.html"})
public class Servlet_High_Score extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ConnectDB son = ConnectDB.getInstance();
        List<ScoreTableEntity> scores = son.getScores();

        Collections.sort(scores, new ScoreTableEntity.SortbyHighScore()); //I used the comparator interface for this

        //do my processing by grabbing all the highscores from the database
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta name=\"description\" content=\"A Work in Progress for Servlet\">\n" +
                "    <link rel=\"stylesheet\" href=\"css/correct.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"css/style.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"css/forSnake-game.css\">\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Comic+Neue:wght@300&family=Ubuntu&display=swap\" rel=\"stylesheet\">\n" +
                "    <title>Marvel's Snake Game High Score</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"stickyContainer\">\n" +
                "\n" +
                "    <!--I got the resources for building this game here https://www.educative.io/blog/javascript-snake-game-tutorial-->\n" +
                "    <h2> <span id=\"snake-game-theUser\">User</span> Welcome to Marvel's Snake Game. </h2>\n" +
                "\n" +
                "</div>\n" +
                "<picture>\n" +
                "    <img src=\"images/nintendo-crop.jpg\" alt=\"banner image\" />\n" +
                "</picture>");


        //Main
        //Testing out the database
        out.println("<main>\n" +
                "\n" +
                "  <table>\n" +
                "    <thead>\n" +
                "    <tr>" +
                "   <th> No.</th>" +
                "<th>Usernames</th>\n" +
                "        <th>HighScores</th></tr>\n" +
                "    </thead>\n" +
                "    <tbody>\n");


        int count = 0; //this makes sure we only display the top 5 users
        for (int i = scores.size() - 1; i >= 0; i--) {
            System.out.println("Usernames: " + scores.get(i).getUsername() + " HighScores: " + scores.get(i).getHighScore());
            int numValue = count + 1;
            //print out the table data of sorted high scores
            out.println("<tr>" +
                    "<td>" + numValue + "</td>"+
                    "<td>"+ scores.get(i).getUsername() +"</td>" +
                    "<td>" + scores.get(i).getHighScore()+"</td>" +
                    "</tr>");
            count++;
            if (count == 10) {
                break;
            }
        }



                out.println("</tbody>" +
                        "</table>" +
                        "" +
                        "<button id=\"highscore-signout\" onclick=\"goHome()\">Sign Out</button> \n" +
                        " <button class=\"highscore-goback\" onclick=\"goBack()\">Go Back to Game</button>" +
                        "</main>");



        //footer
        out.println("<footer>\n" +
                "    <p>&copy; Simple Servlet - Marvellous Okafor</p>\n" +
                "        <span>CIT 360 BYU - I</span>\n" +
                "</footer>\n" +
                "<script src=\"js/forPostPages.js\"></script>\n" +
                "<script src=\"js/forHighScore.js\"></script>\n" +
                "<script src=\"js/score.js\"></script>\n" +
                "</body>\n" +
                "</html>");


    }
}
