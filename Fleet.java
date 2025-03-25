import java.util.ArrayList;


class Fleet {
    static final int DEFAULT_FLEET_SIZE = 3;
    final ArrayList<Battleship> fleet = initFleet();

    public static ArrayList<Battleship> initFleet()
    {
        ArrayList<Battleship> result = new ArrayList<>(DEFAULT_FLEET_SIZE);

        for (int i = 0; i < DEFAULT_FLEET_SIZE; ++i) {
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
