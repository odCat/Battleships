public class Cell
{
    Integer column;
    Integer row;

    public Cell(Integer column, Integer row) {
        this.column = column;
        this.row = row;
    }

    @Override
    public String toString() {
        return "(" + this.column + ", " + this.row + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof Cell))
            return false;

        if (this == obj)
            return true;

        final Cell other = (Cell) obj;

        return this.column == other.column && this.row == other.row;
    }
}
