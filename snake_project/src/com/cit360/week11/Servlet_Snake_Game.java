package com.cit360.week11;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_Snake_Game", urlPatterns = {"/snake_game"})
public class Servlet_Snake_Game extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //do back end processing
        String username = request.getParameter("username");
        int curr_score = Integer.parseInt(request.getParameter("curr_score"));
        int high_score = Integer.parseInt(request.getParameter("high_score"));

        //check with database. This updates the high score and current score of the user

        boolean haveUpdated = ProcessScores.updateScores(username, curr_score, high_score);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println(    "<script>" +
                "window.location.href = \"http://localhost:8080/snake_project_war_exploded/snake_game\""+
                "</script>" );


        //TODO: do processing with the highscore then return back to the snake_game page

        //TODO: I need to create a signout button so users can sign out


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                "    <title>Welcome to Marvel's Snake Game. </title>\n" +
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
//TODO: I need to create a signout page

                int highscore = 36;

                highscore = ProcessScores.getHighScore();
        //Main
        out.println("<main>\n" +
                "    <div id=\"snake-game-parent\">\n" +
                "       <p class=\"right-align\">Score: <span id=\"snake-game-score\">0</span> </p>\n" +
                "        <canvas id=\"snake-game-Canvas\" width=\"400\" height=\"400\"></canvas>\n" +
                "        <p>Highscore: <span id=\"snake-game-highscore\">"+highscore+"</span> </p>\n" +
                "\n" +
                "    </div>\n" +
                "\n" +
                "\n" +
                "    <div id=\"snake-game-popup\">\n" +
                "        <div class=\"snake-game-container\">\n" +
                "            <p class=\"snake-game-died\">You died :(</p>\n" +
                "            <button onclick=\"startGameAgain()\">Play Again?</button>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <div id=\"snake-game-paused\">\n" +
                "        <div class=\"snake-game-container\">\n" +
                "            <p class=\"snake-game-died\">[Paused]</p>\n" +
                "            <button>Press [Space Bar] to unpause. </button>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "" +
                "" +
                "    <!--for sending the scores to the servlet-->\n" +
                "        <form class=\"form-scores\"  name=\"form-scores\" action=\"snake_game\" method=\"post\">\n" +
                "            <label>username*: <input type=\"text\" name=\"username\" id=\"snake-game-form-username\"></label>\n" +
                "            <label>curr_score*: <input type=\"text\" name=\"curr_score\" id=\"snake-game-form-curr_score\" ></label>\n" +
                "            <label>high_score*: <input type=\"text\" name=\"high_score\" id=\"snake-game-form-high-score\"></label>\n" +
                "\n" +
                "        </form>" +


                "</main>\n");



        //footer
        out.println("<footer>\n" +
                "    <p>&copy; Simple Servlet - Marvellous Okafor</p>\n" +
                "        <span>CIT 360 BYU - I</span>\n" +
                "</footer>\n" +
                "<script src=\"js/forPostPages.js\"></script>\n" +
                "<script src=\"js/for-snake-game.js\"></script>\n" +
                "<script src=\"js/score.js\"></script>\n" +
                "</body>\n" +
                "</html>");



    }
}
