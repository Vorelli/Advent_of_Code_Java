package dev.toscanonatale;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CalorieCounter {
    public static void checkMax(int[] max, int curTot) {
        if (curTot > max[2]) {
            max[2] = curTot;
            if (curTot > max[1]) {
                max[2] = max[1];
                max[1] = curTot;
                if (curTot > max[0]) {
                    max[1] = max[0];
                    max[0] = curTot;
                }
            }
        }
    }

    public static int[] countFile(String fileName) {
        int[] max = { 0, 0, 0 };
        int curTot = 0;
        String numOrNewLine = null;
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                numOrNewLine = reader.nextLine();
                // System.out.println("Next Line: " + numOrNewLine + " stats curTot: " + curTot
                // + ", max: " + max[0] + " " + max[1] + " " + max[2]);
                if (numOrNewLine.isEmpty()) {
                    checkMax(max, curTot);
                    curTot = 0;
                } else {
                    try {
                        int calories = Integer.parseInt(numOrNewLine);
                        curTot += calories;
                    } catch (Exception e) {
                        if (e instanceof NumberFormatException) {
                            System.out.println("Found a bad input: " + numOrNewLine);
                        }
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found: " + fileName);
            e.printStackTrace();
        }
        if (numOrNewLine != null && !numOrNewLine.isEmpty())
            checkMax(max, curTot);
        return max;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("You haven't provided a filename in the arguments. Please try again and do so.");
            return;
        }
        String fileName = args[0];
        int[] max = CalorieCounter.countFile(fileName);
        int sum = 0;
        for (int calories : max) {
            sum += calories;
        }

        System.out.println("The maximum calories the three elves are carrying is: " + sum);
        System.out.println("Each one has: " + max[0] + " " + max[1] + " " + max[2]);
    }
}
