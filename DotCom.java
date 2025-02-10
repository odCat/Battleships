import java.util.ArrayList;


public class DotCom
{
    // private ArrayList<Integer> locations;
    private ArrayList<Cell> new_locations;
    private short numOfHits = 0;

    public DotCom() {
        // locations = new ArrayList<>(3);
        Integer i = (int) Math.random()*5;
        // this.locations.add(i);
        // this.locations.add(i+1);
        // this.locations.add(i+2);

        new_locations = new ArrayList<>(3);
        this.new_locations.add(new Cell(i, 0));
        this.new_locations.add(new Cell(i+1, 0));
        this.new_locations.add(new Cell(i+2, 0));
    }

    // public DotCom(ArrayList<Integer> locations) {
    //     this.locations = new ArrayList<>(locations);
    // }

    public DotCom(ArrayList<Cell> new_locations, int temp) {
        this.new_locations = new ArrayList<>(new_locations);
    }


    // public String checkHit(String guess)
    // {
    //     Integer userGuess = Integer.parseInt(guess);
    //     String result = "miss";
    //
    //     this.numOfHits++;
    //     if (this.locations.contains(userGuess)) {
    //         this.locations.remove(userGuess);
    //         if (this.locations.size() == 0)
    //             result = "kill";
    //         else
    //             result = "hit";
    //     }
    //
    //     return result;
    // }

    public String checkHit(String guess)
    {
        Integer column = Integer.parseInt(guess.substring(0,1));
        Integer row = Integer.parseInt(guess.substring(1,2));
        Cell userGuess = new Cell(column, row);
        String result = "miss";

        this.numOfHits++;
        if (this.new_locations.contains(userGuess)) {
            this.new_locations.remove(userGuess);
            if (this.new_locations.size() == 0)
                result = "kill";
            else
                result = "hit";
        }

        return result;
    }

    @Override
    public String toString() {
        return this.new_locations.toString();
    }
}

