package com.beater.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Hangman {

    /**
     * Stores the secret word that the player wants to discover
     */
    private final String secretWord;

    /**
     * Stores letters discovered by the player. '-' stored for not discovered letters.
     */
    private final List<Character> guessWord = new ArrayList<>();

    /**
     * Stores letters that the player has used to try to discover the secret word.
     */
    private final HashSet<Character> guessedLetter = new HashSet<>();

    /**
     * Stores the remaining number of life points.
     */
    private int life = 10;

    /**
     * Build a Hangman object.
     */
    public Hangman() {
        List<String> words = List.of("kaki", "vegetables", "leek", "strawberry", "onion", "rice",
                "pear", "hake", "oats", "quince", "crow", "mouse", "urchin", "ferret", "antelope", "frog", "horse",
                "monkey", "lobster", "quail", "relative", "learned", "swarm", "distillery", "lucifer", "poor", "martian",
                "forge", "fashion", "sauna", "hanger", "mountain", "thanks", "white", "animal", "laugh", "sock",
                "slippers", "fish", "fast", "composer", "optician", "musician", "astronomer", "dancer", "chemist",
                "sculptor", "translator", "jeweler", "craftswoman"
        );

        final int randomIndex = new Random().nextInt(words.size());
        this.secretWord = words.get(randomIndex);

        for (int i = 0; i < secretWord.length(); i++) {
            guessWord.add('-');
        }
    }

    /**
     * Method which verifies if a char given by the player is discovered in the secret word.
     * @param letter The letter to validate in `secretWord` and `guessWord`.
     */
    public boolean guessLetter(char letter) {
        guessedLetter.add(letter);
        boolean asLetter = secretWord.contains(String.valueOf(letter)) && !guessWord.contains(letter);
        if (asLetter) {
            int index = secretWord.indexOf(letter);
            while (index >= 0) {
                this.guessWord.set(index, letter);
                index = secretWord.indexOf(letter, index + 1);
            }
        } else {
            life--;
        }

        return asLetter;
    }

    /**
     * Check if the game is won.
     * @return boolean true is the game is won, false otherwise.
     */
    public boolean isWon() {
        return !guessWord.contains('-');
    }


    /**
     * Check if the game is lost.
     * @return boolean true if the game is lost, false otherwise.
     */
    public boolean isLose() {
        return life <= 0;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public List<Character> getGuessWord() {
        return guessWord;
    }

    public HashSet<Character> getGuessedLetter() {
        return guessedLetter;
    }

    public int getLife() {
        return life;
    }

    @Override
    public String toString() {
        return "Hangman{" +
                "life=" + life +
                ", guessWord=" + guessWord +
                '}';
    }
}
