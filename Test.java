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
        ArrayList<Cell> locations = new ArrayList<>();
        locations.add(new Cell(2, 1));
        locations.add(new Cell(3, 1));
        locations.add(new Cell(4, 1));
        Battleship dot = new Battleship(locations, 1);

        if (dot.checkHit("11").equals("miss"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);

        if (dot.checkHit("21").equals("hit"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);

        dot.checkHit("31");
        if (dot.checkHit("41").equals("kill"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);
    }

    public static void TestHittingTheSameSpot()
    {
        String result = null;
        ArrayList<Cell> locations = new ArrayList<>();

        locations.add(new Cell(2, 1));
        locations.add(new Cell(3, 1));
        locations.add(new Cell(4, 1));
        Battleship dot = new Battleship(locations, 2);

        dot.checkHit("21");
        if (dot.checkHit("21").equals("miss"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);
    }
}

