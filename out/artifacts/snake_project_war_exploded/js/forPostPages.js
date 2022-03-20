
//THis page will take the username from the receiveSignup page and send it to the index.jsp page.

function takeUserName() {
    let userSign = document.getElementById("userSign").value;
    //let userLog = document.getElementById("userLog").value;

    if (!(userSign)) {
        document.getElementById("userLog").value = localStorage.getUsername;
        localStorage.getUsername = "";
    }
    else {
        localStorage.getUsername = "";
        document.getElementById("userSign").value = "";
    }

}

//This is for the snake_game.html page.
//onload();
try {
    document.getElementById("snake-game-theUser").innerText = localStorage.getUsername;
}

catch (e) {
    console.log("Uncaught TypeError: Cannot set properties of null (setting 'innerText')");
    console.log("This means that it can't find the property snake-game-theUser")
}