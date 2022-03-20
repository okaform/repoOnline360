

//THis shows the password when a user tries to sign up
function showPasswd() {
    let pass1 = document.getElementById("pass1"); //for the first password when signing up
    //This is for the first password
    if (pass1.type === "password") {
        pass1.type = "text";
    }
    else {
        pass1.type = "password";
    }
}

function showPasswd2() {
    let pass2 = document.getElementById("pass2"); //for the second password when signing up
    //This is for the second password
    if (pass2.type === "password") {
        pass2.type = "text";
    }
    else {
        pass2.type = "password";
    }
}

//This is to make sure that the passwords match
let password = document.getElementById("pass1")
    , confirm_password = document.getElementById("pass2");

function validatePassword(){
    if(password.value != confirm_password.value) {
        confirm_password.setCustomValidity("Passwords Don't Match");
    } else {
        confirm_password.setCustomValidity('');
    }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;

//end of password matching


//test javaScript
/*
function test(){
    alert("is this happening?");
}*/

//function that displays either the login or the sign up form
function displayLogin() {
    //TODO: make the login button be bolder so the user knows which one is being highlighted
    //if one is displayed in block then switch it to the other.
    if (document.getElementById("login").style.display === "" || document.getElementById("login").style.display === "none") {
        //do change display to block
        document.getElementById("login").style.display = "block";
        document.getElementById("war_exploded-login").style.fontWeight = "bold";
        //change/keep display of other fieldset as none
        document.getElementById("signup").style.display = "none";
        document.getElementById("war_exploded-signup").style.fontWeight = "normal";
    }



}

function displaySignUp() {
    //if display is empty or none
    if (document.getElementById("signup").style.display === "" || document.getElementById("signup").style.display === "none") {
        //do change display to block
        document.getElementById("signup").style.display = "block";
        document.getElementById("war_exploded-signup").style.fontWeight = "bold";
        //change/keep display of other fieldset as none
        document.getElementById("login").style.display = "none";
        document.getElementById("war_exploded-login").style.fontWeight = "normal";
    }
}
