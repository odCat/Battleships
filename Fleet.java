import java.util.ArrayList;


class Fleet {
    static final int DEFAULT_FLEET_SIZE = 3;
    static final int MIN_FLEET_SIZE = 1;
    static final int MAX_FLEET_SIZE = 5;
    final ArrayList<Battleship> fleet = initFleet();


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
}
