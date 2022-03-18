


//ONLY START WHEN AN ARROW KEY HAS BEEN PRESSED
let counter = 0;

document.onkeydown = function(e) {
    //run main() to start the game
    switch (e.keyCode) {
        case 37:

            if (counter == 0) {
                main();
                counter++;
            }
            break;
        case 38:

            if (counter == 0) {
                main();
                counter++;
            }
            break;
        case 39:

            if (counter == 0) {
                main();
                counter++;
            }
            break;
        case 40:

            if (counter == 0) {
                main();
                counter++;
            }
            break;
    }
}

//END OF KEY PRESSED.


//THe JavaScript for the snake game


//create an array list that holds array that is the length of the snake.
//each array is the body part of the snake
const board_border = 'black';
const board_background = "white";
const snake_col = 'lightblue';
const snake_border = 'black';

let snake = [ {x:200, y:200}
              ,{x:190, y:200}
              ,{x:180, y:200}
              ,{x:170, y:200}
              ,{x:160, y:200}
              ,{x:150, y:200} ];

let score = 0;
let highscore = document.getElementById("snake-game-highscore").innerText;


//True if changing direction
let changing_direction = false;

// Horizontal velocity
let food_x;
let food_y;
let dx = 10;
// Vertical velocity
let dy = 0;

//get the canvas element
const snakeboard = document.getElementById("snake-game-Canvas");
//return a 2-d dimensional drawing context
const snakeboard_ctx = snakeboard.getContext("2d");

//load the screen
gen_food();
clearCanvas();
drawFood();
drawSnake();


//start the game
//main();


//list for when the key is pressed and call the change_direction variable
document.addEventListener("keydown", change_direction);

//main function that keeps the game running
function main() {
    //check if any of the variables in has_game_ended is true, then stop the game
    if (has_game_ended()) {
        //shows the game has ended pop up
        document.getElementById("snake-game-popup").style.display = "block";
        //put the score values into the form
        putScoreValues();
        return;
    }

    //TODO: when the game ends, create a pop up from a div that shows the game has ended that asks the user
    //to start again and displays their score.

    changing_direction = false;
    setTimeout(function onTick() {
        clearCanvas();
        drawFood();
        move_snake();
        drawSnake();
        //call main again
        main();
    }, 100)
}

// draw a border around the canvas
function clearCanvas() {
    //  Select the colour to fill the drawing
    snakeboard_ctx.fillStyle = board_background;
    //  Select the colour for the border of the canvas
    snakeboard_ctx.strokestyle = board_border;
    // Draw a "filled" rectangle to cover the entire canvas
    snakeboard_ctx.fillRect(0, 0, snakeboard.width, snakeboard.height);
    // Draw a "border" around the entire canvas
    snakeboard_ctx.strokeRect(0, 0, snakeboard.width, snakeboard.height);
}

//This prints out the snake's part
function drawSnake() {
    //this prints out each part
    snake.forEach(drawSnakePart);
}

//This function draws out the good on the canvas
function drawFood()
{
    snakeboard_ctx.fillStyle = 'lightgreen';
    snakeboard_ctx.strokestyle = 'darkgreen';
    snakeboard_ctx.fillRect(food_x, food_y, 10, 10);
    snakeboard_ctx.strokeRect(food_x, food_y, 10, 10);
}


//This function draws the snake on the canvas
function drawSnakePart(snakePart) {
    snakeboard_ctx.fillStyle = snake_col;
    snakeboard_ctx.strokestyle = snake_border;
    snakeboard_ctx.fillRect(snakePart.x, snakePart.y, 10, 10);
    snakeboard_ctx.strokeRect(snakePart.x, snakePart.y, 10, 10);

}


//TODO: I need to add space bar so that the game can be paused and resumed by the user.
//This function will help with changing the snake's direction with the keyboard
function change_direction(event) {
    const LEFT_KEY = 37;
    const RIGHT_KEY = 39;
    const UP_KEY = 38;
    const DOWN_KEY = 40;

    if (changing_direction) return;
    changing_direction = true;

    const keyPressed = event.keyCode;
    const goingUp = dy === -10;
    const goingDown = dy === 10;
    const goingRight = dx === 10;
    const goingLeft = dx === -10;

    //this would go left if the snake is not going right
    if (keyPressed === LEFT_KEY && !goingRight) {
        dx = -10;
        dy = 0;
    }

    //go up
    if (keyPressed === UP_KEY && !goingDown) {
        dx = 0;
        dy = -10;
    }

    //go right
    if (keyPressed === RIGHT_KEY && !goingLeft) {
        dx = 10;
        dy = 0;
    }

    //go down
    if (keyPressed === DOWN_KEY && !goingUp) {
        dx = 0;
        dy = 10;
    }
}

//This function will check if the game has ended by either the snake eating itself
//or the snake hitting the boundary of the canvas
function has_game_ended() {
    for (let i = 4; i < snake.length; i++) {
        //snake tries to eat itself
        const has_collided = snake[i].x === snake[0].x && snake[i].y === snake[0].y;
        if (has_collided) {
            return true;
        }
    }

    const hitLeftWall = snake[0].x < 0;
    const hitRightWall = snake[0].x > snakeboard.width - 10;
    const hitTopWall = snake[0].y < 0;
    const hitBottomWall = snake[0].y > snakeboard.height - 10

    return hitLeftWall || hitRightWall || hitTopWall || hitBottomWall;

}


//function to generate food. We need to make sure that the food appears within the boundary
//of the canvas and that the food doesn't appear where the snake currently is.
function random_food(min, max) {
    return Math.round((Math.random() * (max-min) + min) / 10) * 10;
}

function gen_food()
{
    food_x = random_food(0, snakeboard.width - 10);
    food_y = random_food(0, snakeboard.height - 10);
    snake.forEach(function has_snake_eaten_food(part) {
        const has_eaten = part.x == food_x && part.y == food_y;
        if (has_eaten) gen_food();
    });
}



//THis function makes the snake move
function move_snake() {
    //horizontal movement
    //create the snake's head
    const head = {x: snake[0].x + dx, y: snake[0].y + dy };
    snake.unshift(head);
    const has_eaten_food = snake[0].x === food_x && snake[0].y === food_y;
    if (has_eaten_food) {
        //increase score
        score += 9;
        //display the score on the screen
        document.getElementById("snake-game-score").innerText = score;

        //increase the score of the high score only if the current score is greater than it
        if (score >= highscore) {
            document.getElementById("snake-game-highscore").innerText = score;
        }



        //generate new food location
        gen_food();
    }
    else {
        //remove the last part of the snake body
        snake.pop();
    }

    //vertical movement
}


//TODO: I need to finish the space bar as well
//for space bar
document.addEventListener('keyup', event => {
    if (event.code === 'Space') {
        console.log('Space pressed'); //whatever you want to do when space is pressed
    }
})


//This function starts the game again after dying
function startGameAgain() {
    document.forms[0].submit();

    //This reloads the page and starts the game again. It does the reload from cache
    //document.location.reload(false);
}

//This function puts the score values into the form
function putScoreValues() {
    //get the username
    username = document.getElementById("snake-game-theUser").innerText;
    //get the current score
    curr_score = document.getElementById("snake-game-score").innerText;
    //get the high score displayed
    high_score = document.getElementById("snake-game-highscore").innerText;

    //change the value of the forms to the value from the game

    document.getElementById("snake-game-form-username").value = username;
    document.getElementById("snake-game-form-curr_score").value = curr_score;
    document.getElementById("snake-game-form-high-score").value = high_score;
}