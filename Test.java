import java.util.ArrayList;


class Test {

    public static void main (String[] args)
    {
        TestIsValidField();
        TestHittingMissingAndKilling();
        TestHittingTheSameSpot();
    }

    public static void TestIsValidField()
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

    public static void TestHittingMissingAndKilling()
    {
        String testName = "HittingMissingAndKilling";
        String result = null;
        ArrayList<Field> locations = new ArrayList<>();
        locations.add(new Field(2, 1));
        locations.add(new Field(3, 1));
        locations.add(new Field(4, 1));
        Battleship battleship = new Battleship(locations, 1);

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

    public static void TestHittingTheSameSpot()
    {
        String testName = "HittingTheSameSpot";
        String result = null;
        ArrayList<Field> locations = new ArrayList<>();

        locations.add(new Field(2, 1));
        locations.add(new Field(3, 1));
        locations.add(new Field(4, 1));
        Battleship battleship = new Battleship(locations, 2);

        battleship.checkHit("21");
        if (battleship.checkHit("21").equals("miss"))
            result = "PASS";
        else
            result = "FAIL";

        System.out.println(testName + " : " + result);
    }
}

