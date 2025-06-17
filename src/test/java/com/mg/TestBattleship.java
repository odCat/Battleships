package com.mg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;


class TestBattleship
{
    @Test
    void testHittingMissingAndKilling()
    {
        ArrayList<Field> locations = new ArrayList<>();
        locations.add(new Field(2, 1));
        locations.add(new Field(3, 1));
        locations.add(new Field(4, 1));
        Battleship battleship = new Battleship("Test", locations);

        assertEquals("miss", battleship.checkHit("11"));
        assertEquals("hit", battleship.checkHit("21"));
        assertEquals("hit", battleship.checkHit("31"));
        assertEquals("kill", battleship.checkHit("41"));
    }

    @Test
    void testHittingUsingLetterCoordonates()
    {
        ArrayList<Field> locations = new ArrayList<>();
        locations.add(new Field(2, 1));
        locations.add(new Field(3, 1));
        locations.add(new Field(4, 1));
        Battleship battleship = new Battleship("Test", locations);

        assertEquals("miss", battleship.checkHit("a1"));
        assertEquals("hit", battleship.checkHit("b1"));
        assertEquals("hit", battleship.checkHit("c1"));
        assertEquals("kill", battleship.checkHit("D1"));
    }

    @Test
    void testCheckHitswithInvalidCoordinates()
    {
        ArrayList<Field> locations = new ArrayList<>();
        locations.add(new Field(2, 1));
        locations.add(new Field(3, 1));
        locations.add(new Field(4, 1));
        Battleship battleship = new Battleship("Test", locations);

        String expected = "Invalid field coordinates. Try again.";

        assertEquals(expected, battleship.checkHit("z1"));
        assertEquals(expected, battleship.checkHit("-11"));
        assertEquals(expected, battleship.checkHit("01"));
        assertEquals(expected, battleship.checkHit("1a"));
    }

    @Test
    void testHittingTheSameSpot()
    {
        ArrayList<Field> locations = new ArrayList<>();

        locations.add(new Field(2, 1));
        locations.add(new Field(3, 1));
        locations.add(new Field(4, 1));
        Battleship battleship = new Battleship("Test", locations);

        assertEquals("hit", battleship.checkHit("21"));
        assertEquals("miss", battleship.checkHit("21"));
        assertEquals("miss", battleship.checkHit("21"));
    }

    @Test
    void testBattleshipsDoNotCollide()
    {
        ArrayList<Field> locations1 = new ArrayList<>(3);
        locations1.add(new Field(2, 1));
        locations1.add(new Field(3, 1));
        locations1.add(new Field(4, 1));
        Battleship battleship1 = new Battleship("Test1", locations1);

        ArrayList<Field> locations2 = new ArrayList<>(3);
        locations2.add(new Field(4, 1));
        locations2.add(new Field(4, 2));
        locations2.add(new Field(4, 3));
        Battleship battleship2 = new Battleship("Test2", locations2);

        ArrayList<Field> locations3 = new ArrayList<>(3);
        locations3.add(new Field(3, 6));
        locations3.add(new Field(4, 6));
        locations3.add(new Field(5, 6));
        Battleship battleship3 = new Battleship("Test3", locations3);

        assertTrue(battleship1.collides(battleship1));
        assertFalse(battleship1.collides(null));
        assertTrue(battleship1.collides(battleship2));
        assertFalse(battleship1.collides(battleship3));
    }

    @Test
    void testBattleshipsDoNotGetTheSameName()
    {
        ArrayList<Field> locations = new ArrayList<>();
        locations.add(new Field(2, 1));
        locations.add(new Field(3, 1));
        locations.add(new Field(4, 1));

        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < 4; ++i) {
            Battleship battleship = new Battleship(locations);

            assertFalse(names.contains(battleship.name()),
                String.format(
                    "The name %s has already been used", battleship.name()
                ));
            names.add(battleship.name());
        }
    }
}

