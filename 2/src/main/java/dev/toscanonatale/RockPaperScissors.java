package dev.toscanonatale;

import java.io.File;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String... args) {
        if (args.length == 0) {
            System.out.println("Missing file name in arguments. Please try again and provide one.");
            return;
        }
        File f = new File(args[0]);
        int res = solve(f);
        System.out.println("You got " + res + " points from this round! Good job!");
    }

    public static int outcome(String[] hands) {
        String opponent = hands[0];
        String yours = hands[1];
        int result = 0;
        switch (yours) {
            case "X":
                result = (opponent.equals("A") ? 3 : (opponent.equals("B") ? 1 : 2));
                break;
            case "Y":
                result = (opponent.equals("A") ? 1 : (opponent.equals("B") ? 2 : 3));
                break;
            case "Z":
                result = (opponent.equals("A") ? 2 : (opponent.equals("B") ? 3 : 1));
                break;
        }
        return result;
    }

    public static int justForPlaying(String playerHand) {
        int score = 0;
        switch (playerHand) {
            case "X":
                score += 0;
                break;
            case "Y":
                score += 3;
                break;
            case "Z":
                score += 6;
                break;
        }
        return score;
    }

    public static int solve(File f) {
        int score = 0;
        try {
            Scanner reader = new Scanner(f);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] hands = line.split(" ");
                if (hands.length != 2) {
                    reader.close();
                    throw new Exception("Too many or too few plays on this line: " + line);
                }
                score += justForPlaying(hands[1]);
                score += outcome(hands);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Encountered error when trying to read file: ");
            e.printStackTrace();
        }
        return score;
    }
}
