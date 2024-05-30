package com.beater.game;

import java.util.ArrayList;
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

    public List<Character> getGuessWord() {
        return guessWord;
    }

    public String getSecretWord() {
        return secretWord;
    }
}
