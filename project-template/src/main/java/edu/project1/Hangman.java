package edu.project1;

import java.util.Scanner;
import java.util.Random;

public class Hangman {
    static Scanner input;

    public static void hangman() {
        input = new Scanner(System.in);

        String[] words = {"engine", "system", "advertising",
            "department", "activity", "food", "control",
            "recipe", "emotion", "bathroom", "version"};

        Random random = new Random();
        int rand = random.nextInt(words.length);

        String word = (words[rand]);
        word = word.toLowerCase();

        String star_word = word.replaceAll("[a-z]", "*");

        System.out.println("The word: " + star_word + "\n");

        startGame(word, star_word);
    }

    public static void startGame(String word, String star_word) {
        int mistakes = 0;
//        int temp = 5;
        String guess;
        char letter;
        boolean alreadyGuess = false;
        String guesses = "";
        boolean letter_in_word;

        while (mistakes < 5 && star_word.contains("*")) {
            System.out.print("Guess a letter: ");
            guess = input.nextLine().toLowerCase();
            if(guess.length() > 1){
                System.out.println("Letter more than 1 symbol");
                continue;
            }

            letter = guess.charAt(0);
            alreadyGuess = (guesses.indexOf(letter)) != -1;
            guesses += letter;
            System.out.println();

            if (alreadyGuess == true) {
                System.out.println("You ALREADY guessed " + letter + ". \n");
                continue;
            }
            if (letter == '0') {
                System.out.println("END GAME");
                System.out.println("The word was " + word);
                return;
            }

            letter_in_word = (word.indexOf(letter)) != -1;

            if (letter_in_word == true) {
                System.out.println("Hit!");
                System.out.print("\n");

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter && star_word.charAt(i) != letter) {
                        star_word = star_word.substring(0, i) + letter + star_word.substring(i + 1);
                    }
                }
            } else {
                mistakes++;
                System.out.println("Missed, mistake " + mistakes + " out of 5.\n");
            }

            System.out.println("The word: " + star_word + "\n");

        }

        if (mistakes == 5) {
            System.out.println("YOU LOST!");
        } else {
            System.out.print("YOU WON!");
        }
    }

    public static void main(String[] args) {
        hangman();
    }
}
