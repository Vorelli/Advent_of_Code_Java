package dev.toscanonatale;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class RucksackPrio {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Try again. You need to provide a filename for the first argument");
            return;
        }
        File f = new File(args[0]);
        System.out.println("Your answer is: " + solve(f));
    }

    public static int solve(File f) {
        int sum = 0;
        try {
            Scanner reader = new Scanner(f);
            while (reader.hasNextLine()) {
                String[] lines = new String[3];
                for (int i = 0; i < 3; i++) {
                    lines[i] = reader.nextLine();
                }
                sum += solveThreeLines(lines);
            }
            reader.close();
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("File not found... Try again");
                return 0;
            }
        }
        return sum;
    }

    private static int solveThreeLines(String[] rucksackContents) {
        List<HashSet<Character>> rucksacks = new ArrayList<HashSet<Character>>();
        for (String rucksackContent : rucksackContents) {
            HashSet<Character> h = new HashSet<>();
            rucksacks.add(h);
            for (int i = 0; i < rucksackContent.length(); i++) {
                h.add(rucksackContent.charAt(i));
            }
        }
        rucksacks.get(0).retainAll(rucksacks.get(1));
        rucksacks.get(0).retainAll(rucksacks.get(2));
        for (Character c : rucksacks.get(0)) {
            if (Character.isUpperCase(c)) {
                return ((int) c) - 38;
            } else {
                return ((int) c) - 96;
            }
        }
        return 0;
    }
}
