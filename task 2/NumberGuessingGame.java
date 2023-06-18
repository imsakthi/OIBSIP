package numberguessinggame;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame{

	    public static void main(String[] args) {
	        // Generate a random number between 1 and 100
	        Random random = new Random();
	        int randomNumber = random.nextInt(100) + 1;

	        // Initialize variables
	        int attempts = 0;
	        boolean hasWon = false;

	        System.out.println("Welcome to the Number Guessing Game!");

	        // Create a Scanner object to read user input
	        Scanner scanner = new Scanner(System.in);

	        // Loop until the user guesses the correct number or runs out of attempts
	        while (attempts < 5) {
	            System.out.print("Enter your guess (between 1 and 100): ");
	            int guess = scanner.nextInt();
	            attempts++;

	            // Compare the guess with the random number
	            if (guess == randomNumber) {
	                hasWon = true;
	                break;
	            } else if (guess < randomNumber) {
	                System.out.println("Too low!");
	            } else {
	                System.out.println("Too high!");
	            }
	        }

	        // Display the result
	        if (hasWon) {
	            System.out.println("Congratulations! You guessed the number in " + attempts + " attempts!");
	        } else {
	            System.out.println("Game over! You ran out of attempts. The number was: " + randomNumber);
	        }

	        // Close the Scanner
	        scanner.close();
	    }
	}
