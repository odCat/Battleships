package com.mg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;


class TestFleet
{
    @Test
    void testInitFleetReturnsShips()
    {
        ArrayList<Battleship> fleet = new Fleet().initFleet();

        int defaultFleetSize = Fleet.DEFAULT_FLEET_SIZE;
        assertEquals(defaultFleetSize, fleet.size());

        assertNotNull(fleet.get(0));
        assertNotNull(fleet.get(1));
        assertNotNull(fleet.get(2));
    }

    @Test
    void testInitFleetReturnsDifferentShips()
    {
        // Class<Fleet> fleetClass = Fleet.class;
        // java.lang.reflect.Field fieldFleet;
        // java.lang.reflect.Method methodFleetInit;
        //
        // try {
        //     fieldFleet = fleetClass.getDeclaredField("fleet");
        //     fieldFleet.setAccessible(true);
        //     methodFleetInit = fleetClass.getDeclaredMethod("initFleet");
        //     methodFleetInit.setAccessible(true);
        // } catch (NoSuchFieldException | NoSuchMethodException e) {
        //     e.printStackTrace();
        // }

        ArrayList<Battleship> fleet;

        for (int k = 0; k < 100; ++k)
        {
            fleet = new Fleet().initFleet();
            for (int i = 0; i < fleet.size()-1; ++i) {
                for (int j = i+1; j < fleet.size(); ++j) {
                    assertFalse(fleet.get(i).collides(fleet.get(j)));
                }
            }
        }
    }

    @Test
    void testInitFleetWithZeroOrNegativeNoShips()
    {
        ArrayList<Battleship> fleet;

        fleet = new Fleet().initFleet(0);
        assertEquals(1, fleet.size());

        fleet = new Fleet().initFleet(-1);
        assertEquals(1, fleet.size());

        fleet = new Fleet().initFleet(100);
        assertEquals(5, fleet.size());
    }

    @Test
    void testNoShipsHaveBeenDestroyedBeforeTheStart()
    {
        Fleet fleet = new Fleet();

        String actual = fleet.getLastKill();
        String expected = "No battleships have been sunk yet.";

        assertEquals(expected, actual);
    }

    @Test
    void testBattleshipsDoNotGetTheSameName()
    {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Field> locations = new ArrayList<>();
        locations.add(new Field(2, 1));
        locations.add(new Field(3, 1));
        locations.add(new Field(4, 1));

        for (int i = 0; i < 100; ++i) {
            ArrayList<Battleship> testFleet = new Fleet().initFleet(5);

            for (Battleship ship : testFleet) {
                assertFalse(names.contains(ship.name()),
                    String.format(
                        "The name %s has already been used", ship.name()
                    ));
                names.add(ship.name());
            }
            names.clear();
        }
    }
}
