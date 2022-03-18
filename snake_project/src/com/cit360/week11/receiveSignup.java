package com.cit360.week11;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "receiveSignup", urlPatterns = {"/submitSignup"})
public class receiveSignup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get the parameters from the index.jsp page
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password2");

        //Call the ProcessUsers function and add them to the user's information to the database
        String responded = ProcessUsers.addUser(firstName, lastName, username, password);


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
                "  <title>Signup </title>\n" +
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

        String pattern = "already";
        Pattern r = Pattern.compile((pattern));
        Matcher m = r.matcher(responded); //I could do a try catch with the m.find()

        try { //for the exception being thrown
            m.find(); //I need to print this out for some reason or else it won't do any matching with the m.group()

            if (m.group(0).equals("already")) {
                out.println( "<script>" +
                        "alert(\"" + responded + ". Going back.\");" +
                        "//Go back to the previous page\n" +
                        "window.history.go(-1);"+
                        "</script>" );
            }
        }
        catch (Exception ise) {
            System.err.println("I expect this to happen if I want to move forward.");
            out.println(    "<script>" +
                            "localStorage.getUsername = \"" +username + "\";\n" +
                            "window.location.href = \"http://localhost:8080/snake_project_war_exploded/\""+
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
        out.println("This resource is not available directly by Marvel");
    }
}
