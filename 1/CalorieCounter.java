import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CalorieCounter {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("You haven't provided a filename in the arguments. Please try again and do so.");
            return;
        }
        String filename = args[0];

        int[] max = { 0, 0, 0 };
        int curTot = 0;
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String numOrNewLine = reader.nextLine();
                if (numOrNewLine.isEmpty()) {
                    curTot = 0;
                } else {
                    try {
                        int calories = Integer.parseInt(numOrNewLine);
                        curTot += calories;
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
                    } catch (Exception e) {
                        if (e instanceof NumberFormatException) {
                            System.out.println("Found a bad input: " + numOrNewLine);
                        }
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found: " + args[0]);
            e.printStackTrace();
        }
        int sum = 0;
        for (int calories : max) {
            sum += calories;
        }
        System.out.println("The maximum calories the three elves are carrying is: " + sum);
        System.out.println("Each one has: " + max[0] + " " + max[1] + " " + max[2]);
    }
}
