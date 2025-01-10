class Test {

    public static void main (String[] args)
    {
        String result;
        DotCom dot = new DotCom();


        if (dot.checkHit("0") == "miss")
            result = "pass";
        else
            result = "fail";

        System.out.println(result);

        if (dot.checkHit("2") == "hit")
            result = "pass";
        else
            result = "fail";

        System.out.println(result);

        dot.checkHit("3");
        if (dot.checkHit("4") == "kill")
            result = "pass";
        else
            result = "fail";

        System.out.println(result);

        TestHitingTheSameSport();
    }

    public static void TestHitingTheSameSport()
    {
        String result = null;
        DotCom dot = new DotCom();

        dot.checkHit("2");
        if (dot.checkHit("2") == "miss")
            result = "pass";
        else
            result = "fail";

        System.out.println(result);
    }
}

