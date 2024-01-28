
import java.util.Scanner;

public class GuessNumberApp {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Game game = new Game();
    game.displayWelcomeMessage();

    char playAgain;
    do {
      game.generateNumberToBeGuessed();
      game.resetGuessNumber(); // Added method to reset guess count to break out of loop
      while (!game.isCorrectGuess()) {
        game.displayPleaseGuessMessage();
        int userGuess = scanner.nextInt();
        game.makeGuess(userGuess);

        if (game.isCorrectGuess()) {
          game.displayCorrectGuessMessage();
        } else {
          game.displayGuessAgainMessage();
        }
      }

      System.out.print("Do you want to play again? (y/n): ");
      playAgain = scanner.next().charAt(0);
    } while (playAgain == 'y' || playAgain == 'Y');

    System.out.println("Thanks for playing!");
    scanner.close();
  }
}
