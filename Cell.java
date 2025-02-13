public class Cell
{
    Integer column;
    Integer row;

    public Cell(Integer column, Integer row) {
        this.column = column;
        this.row = row;
    }

    public static boolean isValidCell(String guess) {
        if (guess.length() != 2)
            return false;
        if (guess.charAt(0) < '1' || guess.charAt(0) > '7')
            return false;
        if (guess.charAt(1) < '1' || guess.charAt(1) > '7')
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "(" + this.column + ", " + this.row + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Cell))
            return false;

        final Cell other = (Cell) obj;
        return this.column == other.column && this.row == other.row;
    }
}
