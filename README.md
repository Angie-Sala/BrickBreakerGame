# **Breakout Ball Game**

this is a simple 2D Breakout Ball Game built in Java using Swing for the graphical user interface. The player controls a paddle to bounce a ball and break bricks. The game ends when all bricks are broken or the ball falls below the paddle.


**Table of contents**
1. Game Features
2. How to Play
3. Project Structure
4. Installation and Running
5. Code Explanation
6. Screenshots
7. Credits


# **Game Features**
* Player controls a paddle to prevent the ball from falling.
* A scoring system awards points for breaking bricks.
* Levels with 21 bricks (3 rows and 7 columns).
* Restart the game by pressing "Enter" after winning or losing.


# **How to Play**
1. Use Right Arrow (→) to move the paddle to the right.
2. Use Left Arrow (←) to move the paddle to the left.
3. Bounce the ball with the paddle to hit the bricks.
4. Break all the bricks to win the game.
5. If the ball falls below the paddle, the game ends. Press Enter to restart.


# **Project Structure**

The project consists of the following classes:
1. Main.java
   
Entry point of the application. Sets up the game window.

2. GamePlay.java

   
Handles game logic, user inputs, and rendering:
* Tracks game state (play, score, total bricks, etc.).
* Handles paddle and ball movement.
* Detects collisions between ball and bricks/paddle.

3. MapGenerator.java
   
Generates the bricks for the game:
* Defines brick layout and size.
* Draws the bricks on the screen.

# **Installation and Running**

**Prerequisites**
* Install Java Development Kit (JDK) (version 8 or higher).
* Use an IDE like IntelliJ IDEA or Eclipse for better code visualization.
  
**Steps**
1. Clone or download this repository.
2. Open the project in your preferred IDE.
3. Compile and run the Main.java file.


# **Code Explanation**
**Main.java**
* Creates a JFrame window titled "Breakout Ball."
* Adds an instance of GamePlay to the frame to handle the game logic.

**GamePlay.java**
* Implements KeyListener for player input and ActionListener for game events.
* Tracks game states like score, ball position, and paddle movement.
* Detects collisions with bricks, paddle, and screen edges.
* Renders game components like bricks, ball, paddle, and score.

**MapGenerator.java**
* Generates the brick grid based on specified rows and columns.
* Handles rendering and removing bricks upon collision.


# **Screenshots**
![image](https://github.com/user-attachments/assets/cd3b1ecf-15f5-43fc-8dbf-54ce57b873fb)
During gameplay

![image](https://github.com/user-attachments/assets/cd6a17f5-943f-47d8-b4df-c93007999138)
Winning screen

![image](https://github.com/user-attachments/assets/9730ac62-d848-4880-9e2b-4a194dde52a3)
Game-over screen


# **Author**
* **Developer:** Ezangela Sala
This project was created as a learning exercise in Java game development.

