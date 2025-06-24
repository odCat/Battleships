package com.mg;

import java.util.Scanner;


class BattleshipsGame
{
    public static void main(String [] args)
    {
        short numOfGuesses = 0;
        Fleet fleet = new Fleet(3);
        Scanner scan = new Scanner(System.in);

        while (true) {
            String guess = getUserInput(scan, "Take a guess:");
            String result = fleet.checkHit(guess);
            ++numOfGuesses;
            if (result.equals("kill")) {
                System.out.println("Kill");
                System.out.println("You sank the " + fleet.getLastKill());
            } else {
                System.out.println(result);
            }

            if (fleet.size() == 0)
                break;
        }

        System.out.println("\nYou took " + numOfGuesses + " guesses");

        scan.close();
    }

    public static String getUserInput(Scanner scan, String prompt)
    {
        String result = null;

        System.out.print(prompt + " ");
        try{
            result = scan.next();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        return result;
    }
}
