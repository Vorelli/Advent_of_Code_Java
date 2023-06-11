package dev.toscanonatale;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class StringDecoder {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("The first argument should be the path to the file");
            return;
        }
        File f = new File(args[0]);
        System.out.println("First marker after character: " + solve(f));
    }

    public static int solve(File f) {
        try {
            Scanner s = new Scanner(f);
            String line = s.nextLine();
            for (int i = 0; i < line.length(); i++) {
                HashSet<Character> unique = new HashSet<>();
                for (int j = i; j < i + 14; j++) {
                    unique.add(line.charAt(j));
                }
                if (unique.size() == 14) {
                    s.close();
                    return i + 14;
                }
            }
            s.close();
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
