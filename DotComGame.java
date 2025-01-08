import java.util.Scanner;


class DotComGame
{
    public static void main(String [] args)
    {
        short numOfGuesses = 0;
        DotCom dotCom = new DotCom();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Take a guess: ");
            String guess = scan.next();
            String result = dotCom.checkHit(guess);
            ++numOfGuesses;
            if (result.equals("kill")) {
                System.out.println("Kill");
                break;
            } else {
                System.out.println(result);
            }
        }

        System.out.println("You took " + numOfGuesses + " guesses");
    }
}
