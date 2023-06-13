package dev.toscanonatale;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DirectoryScanner {
    public static void main(String... args) {
        if (args.length == 0) {
            System.out.println("Please provide a filename for your first argument");
            return;
        }
        int result = solve(new File(args[0]));
        System.out.println("The answer is: " + result);
    }

    public static int solve(File f) {
        try {
            Scanner s = new Scanner(f);
            String command = "";
            FSDir root = new FSDir("/", null);
            FSDir cwd = root;
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (line.startsWith("$")) {
                    command = line.substring(2);
                    if (command.startsWith("cd")) {
                        String[] commands = command.split(" ");
                        switch (commands[1]) {
                            case "..":
                                cwd = cwd.getParent();
                                break;
                            case "/":
                                cwd = root;
                                break;
                            default:
                                cwd = cwd.findChild(commands[1]);
                        }
                    }
                } else {
                    // result of command
                    if (command.equals("ls")) {
                        String[] lineSplit = line.split(" ");
                        String childName = lineSplit[1];
                        String childPath = cwd.getPath() + childName;
                        if (lineSplit[0].equals("dir"))
                            childPath += "/";
                        FSNode child;
                        if (line.startsWith("dir")) {
                            child = new FSDir(childPath, cwd);
                        } else {
                            int size = Integer.parseInt(lineSplit[0]);
                            child = new FSFile(childPath, cwd, size);
                        }
                        cwd.addChild(child);
                    }
                }
            }
            s.close();
            return root.getSmallestForUpdate();
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("Failed to find file: " + f.getPath());
            }
            e.printStackTrace();
            return -1;
        }
    }
}
