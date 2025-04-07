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
        ArrayList<Battleship> fleet = Fleet.initFleet();

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
            fleet = Fleet.initFleet();
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

        fleet = Fleet.initFleet(0);
        assertEquals(1, fleet.size());

        fleet = Fleet.initFleet(-1);
        assertEquals(1, fleet.size());

        fleet = Fleet.initFleet(100);
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
}
