# Battleships

This is a CLI battleships game written in Java.

# How to play

The computer will pick random positions for three battleships on a grid<br>
of 7x7 square. Each battleship will occupy three adjacent squares set<br>
up in a line.

You will be asked for coordinates for the artillery barrage until all the<br>
enemy battleships are destroyed and sunk. To sink a battleship hit it three<br>
times in each square it occupies on the grid.

Good luck!

# Why

As I was starting again with Java after a few years I picked up a very<br>
old edition of **Head First Java**. The book was written after the Dot-com<br>
bubble, that is probably why one of the first projects is a game that<br>
sinks Dot-coms...<br><br>
I took this project on, but created a classic battleship sinking game<br>
with my own implementation and testing.

# What was learned and practiced

* How to incorporate **Maven** into the project and use it to compile,<br>
build and test<br><br>
A problem I encountered with Maven was that it was not building the<br>
project correctly and it was not running my tests. After investigations,<br>
I found the problem. On Debian, the default Maven package was version<br>
3.6.3, and this version was not working well with set up I made.<br>
To solve this issue I installed manually the latest version (3.9.9)<br>

* How to use **JUnit**;<br><br>
After setting up Maven I could use JUnit and run automated tests with it.<br>
So, I transferred my old custom tests to JUnit 5<br>
* How to use **TDD**
* How to use the Math.random() method to generate random numbers
* How to override the equals method (of the Field class) to make the contains<br>
work in the context of the project
* How to use delegation to check hits (BattleshpsGame -> Fleet -> Battleship)
