<%--
  Created by IntelliJ IDEA.
  User: Marvellous Okafor
  Date: 3/15/2022
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="A Work in Progress for Servlet">
  <link rel="stylesheet" href="css/correct.css">
  <link rel="stylesheet" href="css/style.css">
  <link href="https://fonts.googleapis.com/css2?family=Comic+Neue:wght@300&family=Ubuntu&display=swap" rel="stylesheet">
  <title>Welcome to Marvel's Snake Game. </title>
</head>
<body onload="takeUserName()">
<div class="stickyContainer">

  <h2>Welcome to Marvel's Snake Game. Please Login or Create Account to play the game. </h2>

</div>
<picture>
  <img src="images/nintendo-crop.jpg" alt="banner image" />
</picture>
<main>

    <div class="hold-account-info">
      <%--for login--%>
      <button>Login</button>
        <fieldset class="login">
          <legend>Login</legend>
          <form action="submitLogin" method="post">
            <label class="top">Username*: <input type="text" name="Lusername" required
                                id="userLog"                          title="Put your username" ></label>
            <label class="top">Password*: <input type="password" name="Lpass" required
                                                 title="Put your Password" ></label>

              <input  class="submitBtn-login" type="submit" value="Login">
          </form>

        </fieldset>
    </div>

        <%--This is for signup--%>
      <button>Sign up</button>
      <fieldset class="signup">
        <legend>Sign Up!</legend>
        <form action="submitSignup" method="post">
          <label class="top">First Name*: <input type="text" name="firstname" required pattern="[A-Za-z ]+" minlength="2"
                                                        title="You must have your first name. For example: James" ></label>

          <label class="top">Last Name*: <input type="text" name="lastname"  pattern="[A-Za-z ]+"
                                                        title="What is your last name? " ></label>

          <label class="top">Username*: <input type="text" name="username" required
                                          id="userSign"     title="Put your username" ></label>

          <%--Password 1--%>
          <label class="top">Password*: <input id="pass1" type="password" name="password1" required
                                               ></label>
          <!-- An element to toggle between password visibility -->
          <input type="checkbox" onclick="showPasswd()">Show Password

          <%--Password 2--%>
          <label class="top">Confirm Password*: <input id="pass2" type="password" name="password2" required
                                               ></label>
          <!-- An element to toggle between password visibility -->
          <input type="checkbox" onclick="showPasswd2()">Show Password

            <input class="submitBtn-signup" type="submit" value="Sign Up!" >
        </form>

        <%--<button type="submit">Confirm</button>--%>
      </fieldset>



</main>


<footer>
  <p>&copy; Simple Servlet - Marvellous Okafor</p>
    <span>CIT 360 BYU - I</span>
</footer>
<script src="js/all-js.js"></script>
<script src="js/forPostPages.js"></script>
</body>
</html>
