package dev.toscanonatale;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TreetopCopter {
    public static void main(String... args) {
        System.out.println("args: " + args.toString());
        if (args.length <= 1) {
            System.out.println(
                    "Please provide a method number (1 or 2) for the first argument and a filename for the second.");
            return;
        }
        switch (args[0]) {
            case "1":
                System.out.println("The answer is : " + solvePartOne(new File(args[1])));
                break;
            case "2":
                System.out.println("The answer is : " + solvePartTwo(new File(args[1])));
                break;
        }
    }

    public static int solvePartTwo(File f) {
        char[] dirs = { 'l', 'r', 'u', 'd' };
        try {
            Scanner s = new Scanner(f);
            int height = 0;
            int width = 0;
            ArrayList<String> lines = new ArrayList<>();
            while (s.hasNextLine()) {
                height++;
                String line = s.nextLine();
                lines.add(line);
                if (width == 0)
                    width = line.length();
            }
            int[][] values = new int[width][height];
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                for (int j = 0; j < line.length(); j++) {
                    int next = Integer.parseInt(line.charAt(j) + "");
                    values[i][j] = next;
                }
            }
            int max = 0;

            for (int r = 1; r < values.length - 1; r++) {
                for (int c = 1; c < values[r].length - 1; c++) {
                    int scenicScore = 1;
                    for (int i = 0; i < dirs.length; i++) {
                        scenicScore *= score(dirs[i], r, c, values);
                    }
                    if (scenicScore > max)
                        max = scenicScore;
                }
            }
            s.close();
            return max;
        } catch (Exception e) {
            System.out.println("Encountered error");
            e.printStackTrace();
            return 0;
        }
    }

    public static int score(char dir, int r, int c, int[][] values) {
        int startI = 0;
        int inc = 0;
        switch (dir) {
            case 'l':
                startI = c;
                inc = -1;
                break;
            case 'r':
                startI = c;
                inc = 1;
                break;
            case 'u':
                startI = r;
                inc = -1;
                break;
            case 'd':
                startI = r;
                inc = 1;
                break;
        }
        startI += inc;

        int scenicScore = 0;
        switch (dir) {
            case 'l':
            case 'r':
                for (int i = startI; i >= 0 && i < values[0].length; i += inc) {
                    scenicScore++;
                    if (values[r][i] >= values[r][c])
                        break;
                }
                break;
            case 'u':
            case 'd':
                for (int i = startI; i >= 0 && i < values.length; i += inc) {
                    scenicScore++;
                    if (values[i][c] >= values[r][c])
                        break;
                }
                break;
        }
        return scenicScore;
    }

    public static boolean check(char dir, int r, int c, int[][] values, boolean[][] answers) {
        switch (dir) {
            case 'l':
                for (int c2 = c - 1; c2 >= 0; c2--) {
                    if (values[r][c2] >= values[r][c])
                        return false;
                }
                break;
            case 'r':
                for (int c2 = c + 1; c2 < values.length; c2++) {
                    if (values[r][c2] >= values[r][c])
                        return false;
                }
                break;
            case 'u':
                for (int r2 = r - 1; r2 >= 0; r2--) {
                    if (values[r2][c] >= values[r][c])
                        return false;
                }
                break;
            case 'd':
                for (int r2 = r + 1; r2 < values.length; r2++) {
                    if (values[r2][c] >= values[r][c])
                        return false;
                }
                break;
        }
        return true;
    }

    public static int solvePartOne(File f) {
        char[] dirs = { 'l', 'r', 'u', 'd' };
        try {
            Scanner s = new Scanner(f);
            int height = 0;
            int width = 0;
            ArrayList<String> lines = new ArrayList<>();
            while (s.hasNextLine()) {
                height++;
                String line = s.nextLine();
                lines.add(line);
                if (width == 0)
                    width = line.length();
            }
            int[][] values = new int[width][height];
            boolean[][] answers = new boolean[width][height];
            int visible = 0;
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                for (int j = 0; j < line.length(); j++) {
                    int next = Integer.parseInt(line.charAt(j) + "");
                    values[i][j] = next;
                    if (i == 0 || j == 0 || j == width - 1 || i == height - 1) {
                        visible++;
                        answers[i][j] = true;
                    }
                }
            }

            for (int r = 1; r < values.length - 1; r++) {
                for (int c = 1; c < values[r].length - 1; c++) {
                    boolean result = false;
                    for (int i = 0; i < dirs.length; i++) {
                        if (check(dirs[i], r, c, values, answers)) {
                            result = true;
                            visible++;
                            break;
                        }
                    }
                    answers[r][c] = result;
                }
            }
            s.close();
            return visible;

        } catch (Exception e) {
            System.out.println("Failed");
            e.printStackTrace();
            return 0;
        }
    }
}
