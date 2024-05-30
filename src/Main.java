import com.beater.game.Hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        System.out.println("Welcome to Hangman Game! Try to guess the word, one letter at a time." +
                "You have a limited number of attempts, so choose wisely. Good luck!"
        );
        System.out.println(hangman.getGuessWord());

        while (true) {
            if (!hangman.getGuessedLetter().isEmpty()) {
                System.out.println("Letters already tried: " + hangman.getGuessedLetter());
            }

            char letter = scanLetter();
            if (!hangman.guessLetter(letter)) {
                System.out.println("Aie Aie Aie... " + hangman.getLife() + " attempts left");
            } else {
                System.out.println("Great job! You found a letter !");
                System.out.println(hangman.getGuessWord());
            }

            if (hangman.isLose()) {
                System.out.println("Better luck next time! The word was " + hangman.getSecretWord());
                break;
            }

            if (hangman.isWon()) {
                System.out.println("Awesome! You figured out the word " + hangman.getSecretWord() +
                        ". You're Rock !"
                );
                break;
            }
        }
    }

    /**
     * Method which loops until the player enters a unique letter.
     *
     * @return letter enter by the player
     */
    private static char scanLetter() {
        final var scanner = new Scanner(System.in);
        String letter;
        do {
            System.out.println("Enter a letter:");
            letter = scanner.nextLine();
            if (letter.length() > 1) {
                System.out.println("You should enter only one letter:");
            }
        } while (letter.length() != 1);

        return letter.charAt(0);
    }
}
}