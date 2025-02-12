import java.util.ArrayList;


public class Battleship
{
    private ArrayList<Cell> locations;
    private final String name;

    private final static String[] names = {
            "Barbarossa", "Bismarck", "Brandenburg", "Hessen",
            "Hannover", "Markgraf", "Rheinland"
        };

    public Battleship() {
        locations = new ArrayList<>(3);
        Integer i = (int) (Math.random()*7) + 1;
        this.locations.add(new Cell(i, 1));
        this.locations.add(new Cell(i+1, 1));
        this.locations.add(new Cell(i+2, 1));
        this.name = this.chooseName();
    }

    public Battleship(ArrayList<Cell> locations, int temp) {
        this.locations = new ArrayList<>(locations);
        this.name = this.chooseName();
    }

    private String chooseName() {
        Integer i = (int) (Math.random() * Battleship.names.length) + 1;
        return Battleship.names[i];
    }

    public String checkHit(String guess)
    {
        if (!Cell.isValidCell(guess))
            return "Invalid field coordinates. Try again.";

        Integer column = Integer.parseInt(guess.substring(0,1));
        Integer row = Integer.parseInt(guess.substring(1,2));
        Cell userGuess = new Cell(column, row);
        String result = "miss";

        if (this.locations.contains(userGuess)) {
            this.locations.remove(userGuess);
            if (this.locations.size() == 0)
                result = "kill";
            else
                result = "hit";
        }

        return result;
    }

    public String name() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.locations.toString();
    }
}

