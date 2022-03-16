

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
function test(){
    alert("is this happening?");
}