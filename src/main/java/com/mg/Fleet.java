package com.mg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Fleet
{
    static final int DEFAULT_FLEET_SIZE = 3;
    static final int MIN_FLEET_SIZE = 1;
    static final int MAX_FLEET_SIZE = 5;
    private final ArrayList<Battleship> fleet;
    private String lastKill = "";

    private List<String> names = new ArrayList<>(Arrays.asList(
            "Barbarossa", "Bismarck", "Brandenburg", "Hessen",
            "Hannover", "Markgraf", "Rheinland"
        ));

    public Fleet() {
        this.fleet = new ArrayList<Battleship>();
    }

    public Fleet(int size) {
        this.fleet = this.initFleet(size);
    }

    public ArrayList<Battleship> initFleet()
    {
        return initFleet(DEFAULT_FLEET_SIZE);
    }

    public ArrayList<Battleship> initFleet(int fleetSize)
    {
        if (fleetSize < MIN_FLEET_SIZE)
            fleetSize = MIN_FLEET_SIZE;
        else if (fleetSize > MAX_FLEET_SIZE)
            fleetSize = MAX_FLEET_SIZE;

        ArrayList<Battleship> result = new ArrayList<>(fleetSize);

        for (int i = 0; i < fleetSize; ++i) {
            if (i == 0) {
                Battleship newShip = buidBattleship();
                result.add(newShip);
            } else {
                while (true) {
                    boolean collides = false;
                    Battleship newShip = buidBattleship();
                    for (Battleship bs : result) {
                        if (bs.collides(newShip)) {
                            reuseName(newShip);
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

    void reuseName(Battleship bs) {
        if (!this.names.contains(bs.name()))
            names.add(bs.name());
    }

    private Battleship buidBattleship() {
        return new Battleship(this.chooseName());
    }

    private String chooseName() {
        Integer i = (int) (Math.random() * this.names.size());
        String name = this.names.get(i);
        this.names.remove(name);

        return name;
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
