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
        ArrayList<Integer> locations = new ArrayList<>();
        locations.add(2);
        locations.add(3);
        locations.add(4);
        DotCom dot = new DotCom(locations);

        if (dot.checkHit("0").equals("miss"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);

        if (dot.checkHit("2").equals("hit"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);

        dot.checkHit("3");
        if (dot.checkHit("4").equals("kill"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);
    }

    public static void TestHittingTheSameSpot()
    {
        String result = null;
        ArrayList<Integer> locations = new ArrayList<>();
        locations.add(2);
        locations.add(3);
        locations.add(4);
        DotCom dot = new DotCom(locations);

        dot.checkHit("2");
        if (dot.checkHit("2").equals("miss"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);
    }
}

