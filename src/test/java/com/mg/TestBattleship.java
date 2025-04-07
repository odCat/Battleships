package com.mg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;


class TestBattleship
{
    @Test
    void testIsValidField()
    {
        String[] goodTestValues = { "11", "77", "A1", "b4" };
        String[] badTestValues = { "ABC", "88", "00", "AA", "Z1" };

        for (String value : goodTestValues)
            assertTrue(Field.isValidField(value));

        for (String value : badTestValues)
            assertFalse(Field.isValidField(value));
    }

    @Test
    void testHittingMissingAndKilling()
    {
        ArrayList<Field> locations = new ArrayList<>();
        locations.add(new Field(2, 1));
        locations.add(new Field(3, 1));
        locations.add(new Field(4, 1));
        Battleship battleship = new Battleship(locations);

        assertEquals("miss", battleship.checkHit("11"));
        assertEquals("hit", battleship.checkHit("21"));

        battleship.checkHit("31");
        assertEquals("kill", battleship.checkHit("41"));
    }

    @Test
    void testHittingTheSameSpot()
    {
        ArrayList<Field> locations = new ArrayList<>();

        locations.add(new Field(2, 1));
        locations.add(new Field(3, 1));
        locations.add(new Field(4, 1));
        Battleship battleship = new Battleship(locations);

        assertEquals("hit", battleship.checkHit("21"));
        assertEquals("miss", battleship.checkHit("21"));
    }

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
    void testBattleshipsDontCollide()
    {
        ArrayList<Field> locations1 = new ArrayList<>();
        locations1.add(new Field(2, 1));
        locations1.add(new Field(3, 1));
        locations1.add(new Field(4, 1));
        Battleship battleship1 = new Battleship(locations1);

        ArrayList<Field> locations2 = new ArrayList<>();
        locations2.add(new Field(4, 1));
        locations2.add(new Field(4, 2));
        locations2.add(new Field(4, 3));
        Battleship battleship2 = new Battleship(locations2);

        ArrayList<Field> locations3 = new ArrayList<>();
        locations3.add(new Field(3, 6));
        locations3.add(new Field(4, 6));
        locations3.add(new Field(5, 6));
        Battleship battleship3 = new Battleship(locations3);

        assertTrue(battleship1.collides(battleship1));
        assertFalse(battleship1.collides(null));
        assertTrue(battleship1.collides(battleship2));
        assertFalse(battleship1.collides(battleship3));
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

