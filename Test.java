class Test {

    public static void main (String[] args)
    {
        TestHittingMissingAndKilling();
        TestHittingTheSameSpot();
    }

    public static void TestHittingMissingAndKilling()
    {
        String result;
        DotCom dot = new DotCom();

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
        DotCom dot = new DotCom();

        dot.checkHit("2");
        if (dot.checkHit("2").equals("miss"))
            result = "pass";
        else
            result = "fail";

        System.out.println(result);
    }
}

