
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
    }

}

//This is for the snake_game.html page.
//onload();
document.getElementById("snake-game-theUser").innerText = localStorage.getUsername;