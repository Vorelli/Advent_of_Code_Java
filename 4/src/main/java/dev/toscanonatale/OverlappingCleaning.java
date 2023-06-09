package dev.toscanonatale;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class OverlappingCleaning {
    public static void main(String[] args) {
        if (args.length == 0)
            return;
        File f = new File(args[0]);
        System.out.println("Solved. Overlapping ranges: " + solve(f));
    }

    public static int solve(File f) {
        int overlaps = 0;
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String range = s.nextLine();
                if (rangeOverlaps(range))
                    overlaps++;
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not open the file up. Try chaning the path.");
            return 0;
        }

        return overlaps;
    }

    private static boolean rangeOverlaps(String range) {
        String[] splitRange = range.split(",");
        int[] ranges = new int[4];
        int i = 0;
        for (String numbers : splitRange) {
            String[] nums = numbers.split("-");
            ranges[i] = Integer.parseInt(nums[0]);
            ranges[i + 1] = Integer.parseInt(nums[1]);
            i += 2;
        }
        System.out.println("");
        return (ranges[0] >= ranges[2] && ranges[1] <= ranges[3]) || (ranges[2] >= ranges[0] && ranges[3] <= ranges[1]);
    }
}
