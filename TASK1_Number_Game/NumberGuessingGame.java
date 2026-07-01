import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int roundsPlayed = 0;
        int roundsWon = 0;
        int totalScore = 0;

        char playAgain;

        System.out.println("========================================");
        System.out.println("      WELCOME TO NUMBER GUESSING GAME");
        System.out.println("========================================");

        do {

            roundsPlayed++;

            int secretNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\n========== ROUND " + roundsPlayed + " ==========");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {

                System.out.print("\nAttempt " + attempt + ": ");
                int guess = sc.nextInt();

                if (guess == secretNumber) {

                    System.out.println("🎉 Congratulations! You guessed the correct number.");

                    guessedCorrectly = true;
                    roundsWon++;

                    // Score based on remaining attempts
                    int points = (maxAttempts - attempt + 1) * 10;
                    totalScore += points;

                    System.out.println("Points Earned : " + points);
                    break;
                }

                else if (guess < secretNumber) {
                    System.out.println("Too Low! Try Again.");
                }

                else {
                    System.out.println("Too High! Try Again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nYou Lost This Round.");
                System.out.println("Correct Number was : " + secretNumber);
            }

            System.out.println("\n--------- SCORE BOARD ---------");
            System.out.println("Rounds Played : " + roundsPlayed);
            System.out.println("Rounds Won    : " + roundsWon);
            System.out.println("Total Score   : " + totalScore);
            System.out.println("--------------------------------");

            System.out.print("\nDo you want to play another round? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n========================================");
        System.out.println("              GAME OVER");
        System.out.println("========================================");
        System.out.println("Rounds Played : " + roundsPlayed);
        System.out.println("Rounds Won    : " + roundsWon);
        System.out.println("Final Score   : " + totalScore);
        System.out.println("Thank You for Playing!");

        sc.close();
    }
}