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
        locations.add(new Cell(2, 0));
        locations.add(new Cell(3, 0));
        locations.add(new Cell(4, 0));
        Battleship dot = new Battleship(locations, 1);

        if (dot.checkHit("00").equals("miss"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);

        if (dot.checkHit("20").equals("hit"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);

        dot.checkHit("30");
        if (dot.checkHit("40").equals("kill"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);
    }

    public static void TestHittingTheSameSpot()
    {
        String result = null;
        ArrayList<Cell> locations = new ArrayList<>();

        locations.add(new Cell(2, 0));
        locations.add(new Cell(3, 0));
        locations.add(new Cell(4, 0));
        Battleship dot = new Battleship(locations, 2);

        dot.checkHit("20");
        if (dot.checkHit("20").equals("miss"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);
    }
}

