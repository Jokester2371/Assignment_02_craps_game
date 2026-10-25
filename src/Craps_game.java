import java.util.Random;
import java.util.Scanner;
public class Craps_game {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    /** Rolls two dice, prints each die and the sum, and returns the sum. */
    private static int rollDice() {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.println("You rolled " + die1 + " + " + die2 + " = " + sum);
        return sum;
    }

    /** Plays one game. Returns true if the player won. */
    private static boolean playGame() {
        int sum = rollDice();

        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("Craps! You crapped out and lose.");
            return false;
        }
        if (sum == 7 || sum == 11) {
            System.out.println("Natural! You win.");
            return true;
        }

        int point = sum;
        System.out.println("The point is now " + point + ".");

        while (true) {
            sum = rollDice();
            if (sum == point) {
                System.out.println("Made point and won!");
                return true;
            }
            if (sum == 7) {
                System.out.println("Got a seven and lost.");
                return false;
            }
            System.out.println("Trying for point...");
        }
    }

    /** Asks the user whether to play again. */
    private static boolean askToContinue() {
        while (true) {
            System.out.print("\nPlay again? (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("y") || answer.equals("yes")) {
                return true;
            }
            if (answer.equals("n") || answer.equals("no")) {
                return false;
            }
            System.out.println("Please enter 'y' or 'n'.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Craps!\n");
        int wins = 0;
        int losses = 0;

        do {
            if (playGame()) {
                wins++;
            } else {
                losses++;
            }
        } while (askToContinue());

        System.out.println("\nThanks for playing! Final record: "
                + wins + " win(s), " + losses + " loss(es).");
    }
}
