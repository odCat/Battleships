package com.mg;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Battleship
{
    private ArrayList<Field> location;
    private final String name;

    private static List<String> names = new ArrayList<>(Arrays.asList(
            "Barbarossa", "Bismarck", "Brandenburg", "Hessen",
            "Hannover", "Markgraf", "Rheinland"
        ));

    public Battleship() {
        this(Battleship.chooseName());
    }

    public Battleship(String name)
    {
        this.name = name;
        this.location = new ArrayList<>(3);
        Integer i = (int) (Math.random()*5) + 1;
        Integer j = (int) (Math.random()*5) + 1;
        Boolean isOrientedNS = (int) (Math.random()*2) == 0 ? false : true;
        if (isOrientedNS) {
            this.location.add(new Field(i, j));
            this.location.add(new Field(i, j+1));
            this.location.add(new Field(i, j+2));
        } else {
            this.location.add(new Field(i, j));
            this.location.add(new Field(i+1, j));
            this.location.add(new Field(i+2, j));
        }
    }

    public Battleship(ArrayList<Field> location) {
        this(Battleship.chooseName(), location);
    }

    public Battleship(String name, ArrayList<Field> location) {
        this.name = name;
        this.location = new ArrayList<>(location);
    }

    private String chooseName() {
        Integer i = (int) (Math.random() * Battleship.names.length);
        return Battleship.names[i];
    }

    public String checkHit(String guess)
    {
        if (!Field.isValidField(guess))
            return "Invalid field coordinates. Try again.";

        Field userGuess = this.processUserGuess(guess);
        String result = "miss";

        if (this.location.contains(userGuess)) {
            this.location.remove(userGuess);
            if (this.location.size() == 0)
                result = "kill";
            else
                result = "hit";
        }

        return result;
    }

    private Field processUserGuess(String guess) {
        int column;
        int row;

        column = processColumn(guess.charAt(0));
        row = Integer.parseInt(guess.substring(1,2));
        Field result = new Field(column, row);

        return result;
    }

    private int processColumn(Character column) {
        int result;

        if (Character.isLetter(column)) {
            Map<Character, Integer> charToInt = new HashMap<>();
            charToInt.put('A', 1);
            charToInt.put('B', 2);
            charToInt.put('C', 3);
            charToInt.put('D', 4);
            charToInt.put('E', 5);
            charToInt.put('F', 6);
            charToInt.put('G', 7);

            result = charToInt.get(Character.toUpperCase(column));
        } else {
            result = Integer.parseInt(Character.toString(column));
        }

        return result;
    }

    boolean collides(Battleship other) {

        if (this == other)
            return true;

        if (other == null || !(other instanceof Battleship))
            return false;

        for (Field thisField : this.location)
            for (Field otherField : other.location)
                if (thisField.equals(otherField))
                    return true;

        return false;
    }

    void reuseName() {
        if (!Battleship.names.contains(this.name()))
            Battleship.names.add(this.name());
    }

    @Override
    public String toString() {
        return this.location.toString();
    }

    public String name() {
        return this.name;
    }
}

