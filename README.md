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

* How to use the Math.random() method to generate random numbers
* How to override the equals method (of the Field class) to make the
contains work in the context of the project
* How to use delegation to check hits (BattleshpsGame -> Fleet -> Battleship)
* How to use TDD
