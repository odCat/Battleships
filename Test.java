import java.util.ArrayList;


class Test {

    public static void main (String[] args)
    {
        TestHittingMissingAndKilling();
        TestHittingTheSameSpot();
    }

    public static void TestHittingMissingAndKilling()
    {
        String result = null;
        ArrayList<Field> locations = new ArrayList<>();
        locations.add(new Field(2, 1));
        locations.add(new Field(3, 1));
        locations.add(new Field(4, 1));
        Battleship battleship = new Battleship(locations, 1);

        if (battleship.checkHit("11").equals("miss"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);

        if (battleship.checkHit("21").equals("hit"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);

        battleship.checkHit("31");
        if (battleship.checkHit("41").equals("kill"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);
    }

    public static void TestHittingTheSameSpot()
    {
        String result = null;
        ArrayList<Field> locations = new ArrayList<>();

        locations.add(new Field(2, 1));
        locations.add(new Field(3, 1));
        locations.add(new Field(4, 1));
        Battleship battleship = new Battleship(locations, 2);

        battleship.checkHit("21");
        if (battleship.checkHit("21").equals("miss"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);
    }
}

