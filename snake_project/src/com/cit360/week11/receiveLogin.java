package com.cit360.week11;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "receiveLogin", urlPatterns = {"/submitLogin"})
public class receiveLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get the parameters from the index.jsp page

        String username = request.getParameter("Lusername");
        String password = request.getParameter("Lpass");

        //Call the ProcessUsers function and check if their username and password matches.
        //TODO: I could make the isUserThere method return a list that I can use for the isPassThere method
        //boolean isUserThere = ProcessUsers.checkUsername(username);

        BooleanUserInfo isUserThere = ProcessUsers.checkUsername(username);
        //This takes the user's password input and checks it with the BooleanUserInfo class
        //to see if they are matching
        boolean isPassThere = ProcessUsers.checkPassword(password, isUserThere);


        PrintWriter out = response.getWriter(); //This basically builds the page
        response.setContentType("text/html");
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "  <meta name=\"description\" content=\"A Work in Progress for Servlet\">\n" +
                "  <link rel=\"stylesheet\" href=\"css/correct.css\">\n" +
                "  <link rel=\"stylesheet\" href=\"css/style.css\">\n" +
                "  <link href=\"https://fonts.googleapis.com/css2?family=Comic+Neue:wght@300&family=Ubuntu&display=swap\" rel=\"stylesheet\">\n" +
                "  <title>Login</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"stickyContainer\">\n" +
                "\n" +
                "<h2>Thank you for visiting</h2>\n" +
                "\n" +
                "</div>\n" +
                "<picture>\n" +
                "  <img src=\"images/controller-dark-cropped.jpg\" alt=\"banner image\" />\n" +
                "</picture>\n" +
                "<main>"); //Start of the HTML

        //if both of them comes out false. if username is false
        if (!isUserThere.isTrueOrNot()) {
            System.out.println("Wrong Username");
            out.println( "<script>" +
                    "//Go back to the previous page\n" +
                    "alert(\"wrong username. Going Back\");" +
                    "window.history.go(-1);"+
                    "</script>" );

        }

        //if the username is false
        else if (!isPassThere) {
            System.out.println("The Password is wrong");
            out.println( "<script>" +
                    "//Go back to the previous page\n" +
                    "alert(\"wrong password. Going Back\");" +
                    "window.history.go(-1);"+
                    "</script>" );
        }
        else {
            System.out.println("Correct. Welcome to the Game.");
            out.println(    "<script>" +
                    "localStorage.getUsername = \"" +username + "\";\n" +
                    "window.location.href = \"http://localhost:8080/snake_project_war_exploded/snake_game\""+
                    "</script>" );
        }












        out.println("</main>\n" +
                "\n" +
                "\n" +
                "<footer>\n" +
                "      <p>&copy; Simple Servlet - Marvellous Okafor\n" +
                "        <span>CIT 360 BYU - I</span>\n" +
                "</footer>\n" +
                "<script src=\"js/forPostPages.js\"></script>" +
                "</body>\n" +
                "</html>"); //end of the HTML
        out.println();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //even if you are using a POST, you need to have something here
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); //This basically builds the page
        out.println("This resource is not available directly");
    }
}
