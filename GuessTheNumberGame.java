import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Random random = new Random();
    
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 0;
        Scanner input = new Scanner(System.in);
        int guess;
        boolean win = false;

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("Now let's guess the number between 1 to 100.");

        while (!win) {
            System.out.print("Enter your guess number: ");
            guess = input.nextInt();
            numberOfTries++;

            if (guess < 1 || guess > 100) {
                System.out.println("Please enter a valid number between 1 and 100.");
            } else if (guess < numberToGuess) {
                System.out.println("Your guess number is smaller then compter genrated number.");
            } else if (guess > numberToGuess) {
                System.out.println("Your guess is bigger then computer genrated number .");
            } else {
                win = true;
                System.out.println("Congratulations! You've guessed the number.");
                System.out.println("It took you " + numberOfTries + " tries.");
            }
        }

        input.close();
    }
}
