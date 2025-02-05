import java.util.ArrayList;

public class DotCom
{
    private ArrayList<Integer> locations;
    private short numOfHits = 0;

    public DotCom() {
        locations = new ArrayList<>();
        this.locations.add(2);
        this.locations.add(3);
        this.locations.add(4);
    }

    public String checkHit(String guess)
    {
        Integer userGuess = Integer.parseInt(guess);
        String result = "miss";

        this.numOfHits++;
        if (this.locations.contains(userGuess)) {
            this.locations.remove(userGuess);
            if (this.locations.size() == 0)
                result = "kill";
            else
                result = "hit";
        }

        return result;
    }
}

