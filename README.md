# Battleships

This is a CLI battleships game written in Java.

# How to play

The computer will pick random positions for three battleships on a
grid of 7x7 square. <br>
Each battleship will occupy three adjacent squares
set up in a line.

You will be asked for coordinates for the artillery barrage until all
the enemy battleships are destroyed and sunk. <br>
To sink a battleship
hit it three times in each square it occupies on the grid.

Good luck!

# What was learned and practiced

* How to incorporate **Maven** into the project and use it to compile,
build and test it<br><br>
A problem I encountered with Maven was that it was not building the<br>
project correctly and it was not running my tests. After investigations<br>
I found the problem. On Debian the default Maven package was version 3.6.3,<br>
and this version was not working well with the configuration I set up.<br>
To solve this issue I installed manually the latest version(3.9.9)
* How to use **JUnit**;<br><br>After setting up Maven I could use JUnit and<br>
run automate tests with it. So, I transferred my old custom tests to JUnit 5
* How to use **TDD**
* How to use the Math.random() method to generate random numbers
* How to override the equals method (of the Field class) to make the contains<br>
work in the context of the project
* How to use delegation to check hits (BattleshpsGame -> Fleet -> Battleship)
