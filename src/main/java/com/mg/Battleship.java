package com.mg;

import java.util.ArrayList;


public class Battleship
{
    private ArrayList<Field> location;
    private final String name;

    private final static String[] names = {
            "Barbarossa", "Bismarck", "Brandenburg", "Hessen",
            "Hannover", "Markgraf", "Rheinland"
        };

    public Battleship() {

        this.name = this.chooseName();
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
        // System.out.println(isOrientedNS);
        // System.out.println(this.location);
    }

    public Battleship(ArrayList<Field> location) {
        this.location = new ArrayList<>(location);
        this.name = this.chooseName();
    }

    private String chooseName() {
        Integer i = (int) (Math.random() * Battleship.names.length);
        return Battleship.names[i];
    }

    public String checkHit(String guess)
    {
        if (!Field.isValidField(guess))
            return "Invalid field coordinates. Try again.";

        Integer column = Integer.parseInt(guess.substring(0,1));
        Integer row = Integer.parseInt(guess.substring(1,2));
        Field userGuess = new Field(column, row);
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

    public String name() {
        return this.name;
    }

    boolean collides(Battleship other) {
        if (other == null)
            return false;

        if (this == other)
            return true;

        if (!(other instanceof Battleship))
            return false;

        for (Field thisField : this.location)
            for (Field otherField : other.location)
                if (thisField.equals(otherField))
                    return true;

        return false;
    }

    @Override
    public String toString() {
        return this.location.toString();
    }
}

