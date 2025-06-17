package com.mg;


public class Field
{
    Integer column;
    Integer row;

    public Field(Integer column, Integer row) {
        this.column = column;
        this.row = row;
    }

    public static boolean isValidField(String guess) {
        if (guess.length() != 2)
            return false;
        if (!(guess.charAt(0) > '0' && guess.charAt(0) < '8'
                || guess.charAt(0) >= 'a' && guess.charAt(0) <= 'h'
                || guess.charAt(0) >= 'A' && guess.charAt(0) <= 'H'))
            return false;
        if (guess.charAt(1) < '1' || guess.charAt(1) > '7')
            return false;
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Field))
            return false;

        final Field other = (Field) obj;
        return this.column == other.column && this.row == other.row;
    }

    @Override
    public String toString() {
        return "(" + this.column + ", " + this.row + ")";
    }
}
