import com.beater.game.Hangman;

public class Main {
    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        System.out.println("Welcome to Hangman Game! Try to guess the word, one letter at a time." +
                "You have a limited number of attempts, so choose wisely. Good luck!"
        );
        System.out.println(hangman.getGuessWord());
    }
}