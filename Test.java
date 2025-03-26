import java.util.ArrayList;


class Test
{
    public static void main (String[] args)
    {
        testIsValidField();
        testHittingMissingAndKilling();
        testHittingTheSameSpot();
        testInitFleetReturnsShips();
        testBattleshipsDontCollide();
        testInitFleetReturnsDifferentShips();
        testInitFleetWithZeroOrNegativeNoShips();
    }

    public static void testIsValidField()
    {
        String testName = "IsValidField";
        String result = null;
        String[] goodTestValues = { "11", "77", "A1", "b4" };
        String[] badTestValues = { "ABC", "88", "00", "AA", "Z1" };


        for (String value : goodTestValues) {
            if (Field.isValidField(value))
                result = "PASS";
            else
                result = "FAIL";
            System.out.println(testName + " (" + value + ")"
                    + " : " + result);
        }

        for (String value : badTestValues) {
            if (!Field.isValidField(value))
                result = "PASS";
            else
                result = "FAIL";
            System.out.println(testName + " (" + value + ")"
                    + " : " + result);
        }
    }

    public static void testHittingMissingAndKilling()
    {
        String testName = "HittingMissingAndKilling";
        String result = null;
        ArrayList<Field> locations = new ArrayList<>();
        locations.add(new Field(2, 1));
        locations.add(new Field(3, 1));
        locations.add(new Field(4, 1));
        Battleship battleship = new Battleship(locations);

        if (battleship.checkHit("11").equals("miss"))
            result = "PASS";
        else
            result = "FAIL";

        System.out.println(testName + " : " + result);

        if (battleship.checkHit("21").equals("hit"))
            result = "PASS";
        else
            result = "FAIL";

        System.out.println(testName + " : " + result);

        battleship.checkHit("31");
        if (battleship.checkHit("41").equals("kill"))
            result = "PASS";
        else
            result = "FAIL";

        System.out.println(testName + " : " + result);
    }

    public static void testHittingTheSameSpot()
    {
        String testName = "HittingTheSameSpot";
        String result = null;
        ArrayList<Field> locations = new ArrayList<>();

        locations.add(new Field(2, 1));
        locations.add(new Field(3, 1));
        locations.add(new Field(4, 1));
        Battleship battleship = new Battleship(locations);

        battleship.checkHit("21");
        if (battleship.checkHit("21").equals("miss"))
            result = "PASS";
        else
            result = "FAIL";

        System.out.println(testName + " : " + result);
    }

    public static void testInitFleetReturnsShips()
    {
        String testName = "InitFleetReturnsShips";
        String result = null;
        ArrayList<Battleship> fleet = Fleet.initFleet();

        int defaultFleetSize = Fleet.DEFAULT_FLEET_SIZE;
        assert fleet.size() == defaultFleetSize :
            "Fleet size is not " + defaultFleetSize +
            " (" + fleet.size() + ")";

        if (fleet.get(0) != null && fleet.get(1) != null
                && fleet.get(2) != null)
            result = "PASS";
        else
            result = "FAIL";

        System.out.println(testName + " : " + result);
    }

    public static void testBattleshipsDontCollide()
    {
        String testName = "testBattleshipsDontCollide";
        String result = null;

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

        if (battleship1.collides(battleship1))
            result = "PASS";
        else
            result = "FAIL";

        System.out.println(testName + " : " + result);

        if (!battleship1.collides(null))
            result = "PASS";
        else
            result = "FAIL";

        System.out.println(testName + " : " + result);

        if (battleship1.collides(battleship2))
            result = "PASS";
        else
            result = "FAIL";

        System.out.println(testName + " : " + result);

        if (!battleship1.collides(battleship3))
            result = "PASS";
        else
            result = "FAIL";

        System.out.println(testName + " : " + result);
    }

    public static void testInitFleetReturnsDifferentShips()
    {
        String testName = "InitFleetReturnsDifferentShips";
        String result = "PASS";

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

        search:
        for (int k = 0; k < 100; ++k)
        {
            fleet = Fleet.initFleet();
            for (int i = 0; i < fleet.size()-1; ++i) {
                for (int j = i+1; j < fleet.size(); ++j) {
                    if (fleet.get(i).collides(fleet.get(j))) {
                        result = "FAIL";
                        break search;
                    }
                }
            }
        }

        System.out.println(testName + " : " + result);
    }

    public static void testInitFleetWithZeroOrNegativeNoShips()
    {
        String testName = "InitFleetWithZeroOrNegativeNoShips";
        String result;

        ArrayList<Battleship> fleet;

        fleet = Fleet.initFleet(0);
        if (fleet.size() == 1)
            result = "PASS";
        else
            result = "FAIL";
        System.out.println(testName + " : " + result);

        fleet = Fleet.initFleet(-1);
        if (fleet.size() == 1)
            result = "PASS";
        else
            result = "FAIL";
        System.out.println(testName + " : " + result);

        fleet = Fleet.initFleet(100);
        if (fleet.size() == 5)
            result = "PASS";
        else
            result = "FAIL";
        System.out.println(testName + " : " + result);
    }
}

