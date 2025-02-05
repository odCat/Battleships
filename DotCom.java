import java.util.ArrayList;

public class DotCom
{
    private ArrayList<Integer> locations;
    private short numOfHits = 0;

    public DotCom() {
        locations = new ArrayList<>();
        Integer i = (int) Math.random()*5;
        this.locations.add(i);
        this.locations.add(i+1);
        this.locations.add(i+2);
    }

    public DotCom(ArrayList<Integer> locations){
        this.locations = new ArrayList<>(locations);
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

