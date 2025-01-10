class DotCom
{
    private short [] locations = {2, 3, 4};
    private short numOfHits = 0;

    public String checkHit(String guess)
    {
        int userGuess = Integer.parseInt(guess);
        String result = "miss";

        for (int i = 0; i < 3; ++i)
            if (userGuess == locations[i]) {
                result = "hit";
                ++numOfHits;
                locations[i] = -1;
                break;
            }

        if (numOfHits == locations.length)
            result = "kill";

        return result;
    }
}

