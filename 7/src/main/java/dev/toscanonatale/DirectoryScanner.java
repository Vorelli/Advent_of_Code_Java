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
            FSDir root = new FSDir("/");
            FSDir cwd = root;
            while(s.hasNextLine()) {
                String line = s.nextLine();
                if(line.startsWith("$")) {
                    // "command"
                    command = line.split("$ ")[0];
                    if(command.startsWith("cd")) {
                        String[] commands = command.split(" ")
                        cwd = commands[1].equals("/") ? root : cwd.findChild(commands[1]);
                    }
                } else {
                    // result of command
                    switch(command) {
                        case "ls":
                            String childPath = cwd.getPath() + "/" + "directoryName";
                            FSNode child;
                            // need to determine whether child is dir or file
                            if("dir".equals("dir")) {
                                child = new FSDir(childPath);
                            } else {
                                child = new FSFile(childPath, 0);
                            }
                            cwd.addChild(child);
                            break;
                    }
                }
            }
            s.close();
            return root.getDirUnder100k();
        } catch(Exception e) {
            if(e instanceof FileNotFoundException) {
                System.out.println("Failed to find file: " + f.getPath());
            }
            e.printStackTrace();
            return -1;
        }
    }
}
