import java.util.ArrayList;


public class Battleship
{
    private ArrayList<Field> locations;
    private final String name;

    private final static String[] names = {
            "Barbarossa", "Bismarck", "Brandenburg", "Hessen",
            "Hannover", "Markgraf", "Rheinland"
        };

    public Battleship() {
        locations = new ArrayList<>(3);
        Integer i = (int) (Math.random()*5) + 1;
        this.locations.add(new Field(i, 1));
        this.locations.add(new Field(i+1, 1));
        this.locations.add(new Field(i+2, 1));
        this.name = this.chooseName();
    }

    public Battleship(ArrayList<Field> locations, int temp) {
        this.locations = new ArrayList<>(locations);
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

