import java.util.ArrayList;


class Fleet
{
    static final int DEFAULT_FLEET_SIZE = 3;
    static final int MIN_FLEET_SIZE = 1;
    static final int MAX_FLEET_SIZE = 5;
    private final ArrayList<Battleship> fleet = initFleet();
    private String lastKill = "";

    public static ArrayList<Battleship> initFleet()
    {
        return initFleet(DEFAULT_FLEET_SIZE);
    }

    public static ArrayList<Battleship> initFleet(int fleetSize)
    {
        if (fleetSize < MIN_FLEET_SIZE)
            fleetSize = MIN_FLEET_SIZE;
        else if (fleetSize > MAX_FLEET_SIZE)
            fleetSize = MAX_FLEET_SIZE;

        ArrayList<Battleship> result = new ArrayList<>(fleetSize);

        for (int i = 0; i < fleetSize; ++i) {
            if (i == 0) {
                Battleship newShip = new Battleship();
                result.add(newShip);
            } else {
                while (true) {
                    boolean collides = false;
                    Battleship newShip = new Battleship();
                    for (Battleship bs : result) {
                        if (bs.collides(newShip)) {
                            collides = true;
                        }
                    }
                    if (!collides) {
                        result.add(newShip);
                        break;
                    }
                }
            }
        }

        return result;
    }

    public String checkHit(String guess)
    {
        for (Battleship bs : this.fleet) {
            String result = bs.checkHit(guess);
            if (!result.equals("miss")) {
                if (result.equals("kill"))
                {
                    this.fleet.remove(bs);
                    lastKill = bs.name();
                }
                return result;
            }
        }

        return "miss";
    }

    public int size() {
        return this.fleet.size();
    }

    public String getLastKill() {
        if (this.lastKill.isEmpty())
            return "No battleships have been sunk yet.";
        else
            return this.lastKill;
    }
}
