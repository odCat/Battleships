import java.util.ArrayList;
import java.util.Scanner;


class BattleshipsGame
{
    static final int DEFAULT_FLEET_SIZE = 3;
    final ArrayList<Battleship> fleet = initFleet();

    public static void main(String [] args)
    {
        short numOfGuesses = 0;
        Battleship battleship = new Battleship();
        Scanner scan = new Scanner(System.in);

        while (true) {
            String guess = getUserInput(scan, "Take a guess:");
            String result = battleship.checkHit(guess);
            ++numOfGuesses;
            if (result.equals("kill")) {
                System.out.println("Kill");
                System.out.println("You sank the " + battleship.name());
                break;
            } else {
                System.out.println(result);
            }
        }

        System.out.println("\nYou took " + numOfGuesses + " guesses");

        scan.close();
    }

    ArrayList<Battleship> initFleet()
    {
        ArrayList<Battleship> result = new ArrayList<>(DEFAULT_FLEET_SIZE);

        for (int i = 0; i < DEFAULT_FLEET_SIZE; ++i) {
            if (i == 0) {
                Battleship newShip = new Battleship();
                result.add(newShip);
            } else {
                while (true) {
                    boolean collides = false;
                    Battleship newShip = new Battleship();
                    for (Battleship bs : result) {
                        if (bs.collides(newShip)) {
                            collides = true;
                        }
                    }
                    if (!collides) {
                        result.add(newShip);
                        break;
                    }
                }
            }
        }

        return result;
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
