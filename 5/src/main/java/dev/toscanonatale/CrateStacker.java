package dev.toscanonatale;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CrateStacker {
    public static void main(String... args) {
        if (args.length == 0) {
            System.out.println("You need to provide a filepath as your first argument");
            System.out.println("The final result is: " + solve(new File(args[0])));
        }
        String result = solve(new File(args[0]));
        System.out.println("The result of the crates: " + result);
    }

    public static ArrayList<StackOfCrates> readStacks(Scanner s) throws Exception {
        ArrayList<StackOfCrates> stacks = new ArrayList<>();
        boolean firstTime = true;
        while (s.hasNextLine()) {
            String lineOfItems = s.nextLine();
            if (lineOfItems.isEmpty()) {
                return stacks;
            }
            if (firstTime) {
                for (int i = 0; (i + 2) < lineOfItems.length(); i += 4) {
                    stacks.add(new StackOfCrates());
                }
                firstTime = false;
            }

            for (int i = 0; i + 2 < lineOfItems.length(); i += 4) {
                char c = lineOfItems.charAt(i + 1);
                System.out.println("Read character: " + c);
                if (c != ' ' && Character.isAlphabetic(c)) {
                    int index = i / 4;
                    StackOfCrates stack = stacks.get(index);
                    System.out.println("Adding to a stack of length: " + stack.stack.size() + " and index of " + index);
                    stack.addFromTop(c + "");
                }
            }

        }
        throw new Exception("Failed to provide a valid stack of crates!");
    }

    public static String fromTop(ArrayList<StackOfCrates> stacks) {
        String result = "";
        for (StackOfCrates s : stacks) {
            result += s.pop();
        }
        return result;
    }

    public static void executeInstructions(Scanner s, ArrayList<StackOfCrates> stacks) {
        while (s.hasNextLine()) {
            String[] nums = s.nextLine().split(" ");
            Integer from = Integer.parseInt(nums[3]) - 1;
            Integer to = Integer.parseInt(nums[5]) - 1;
            Integer quantity = Integer.parseInt(nums[1]);
            System.out.println("Moving " + quantity + " boxes from " + from + " to " + to);
            for (int i = 0; i < quantity; i++) {
                String temp = stacks.get(from).pop();
                System.out.println("Moving: " + temp);
                stacks.get(to).add(temp);
            }
        }
    }

    public static String solve(File f) {
        try {
            Scanner s = new Scanner(f);
            ArrayList<StackOfCrates> stack = readStacks(s);
            executeInstructions(s, stack);
            return fromTop(stack);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof FileNotFoundException) {
                System.out.println("Couldn't find file: ");
                return "Fail";
            } else {
                return "oof";
            }
        }
    }
}
