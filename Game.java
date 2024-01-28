import java.util.Random;
import java.util.Scanner;

class Game {
  private int number;
  private int guessNumber;
  private int previousGuess = -1; 
  private int counter; 

  // Constructor
  public Game() {
    this.number = generateNumberToBeGuessed();
    this.guessNumber = 0;
    this.counter = 0;
  }

  public int generateNumberToBeGuessed() {
    Random random = new Random();
    int randomInt = random.nextInt(100) + 1;
    this.number = randomInt;
    return randomInt;
  }

  // Method to receive a guess from the user
  public void makeGuess(int guessNumber) {
    previousGuess = this.guessNumber;
    this.guessNumber = guessNumber;
    counter++;
  }

  public void resetGuessNumber() {
    this.guessNumber = 0;
  }

  // Method to check if the guess is correct
  public boolean isCorrectGuess() {
    return guessNumber == number;
  }

  // Method to display a welcome message
  public void displayWelcomeMessage() {
    System.out.println("Welcome to the Guess the Number Game!");
    System.out.println("I have selected a number between 1 and 100. Can you guess it?");
  }

  // Method to prompt the user to make a guess
  public void displayPleaseGuessMessage() {
    System.out.print("Please enter your guess: ");
  }

  // Method to display a message for a correct guess
  public void displayCorrectGuessMessage() {
    System.out.println("Congratulations! You guessed the correct number " + number + " in " + counter + " guesses.");
    giveFeedbackBasedOnAttempts(); // Call method to give feedback based on attempts
    previousGuess = -1; // Reset for new game

  }

  // Method to display a message for incorrect guesses and provide "higher or
  // lower" and "warmer or colder" feedback
  public void displayGuessAgainMessage() {
    if (guessNumber > number) {
      System.out.println("Lower!");
    } else {
      System.out.println("Higher!");
    }

    if (previousGuess != -1) { // Ensures we have a previous guess to compare with
      int currentDifference = Math.abs(guessNumber - number);
      int previousDifference = Math.abs(previousGuess - number);
      if (currentDifference < previousDifference) {
        System.out.println("Warmer!");
      } else if (currentDifference > previousDifference) {
        System.out.println("Colder!");
      } else {
        System.out.println("You're at the same temperature... Try a different number.");
      }
    }

  }

  private void giveFeedbackBasedOnAttempts() {
    if (counter <= 3) {
      System.out.println("Great work! You are a mathematical wizard.");
    } else if (counter >= 4 && counter <= 7) {
      System.out.println("Not too bad! You've got some potential.");
    } else {
      System.out.println("What took you so long?");
    }
  }
}
