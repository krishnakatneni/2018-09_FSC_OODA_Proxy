package edu.fitchburgstate.csc7400.extra;

import java.io.File;
import java.io.PrintWriter;

public class ShowFileContents {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ShowFileContents <directory>");
        }
        String dirname = args[0];

        File dir = new File(dirname);
        if (!dir.exists()) {
            System.err.println(dirname + " does not exist");
            return;
        }
        if (!dir.isDirectory()) {
            System.err.println(dirname + " is not a directory");
            return;
        }

        PrintWriter outWriter = new PrintWriter(System.out);
        for (File file: dir.listFiles()) {
        	if (file.isDirectory()) continue;
        	FileStringifier fileStringifier = new SlowFileStringifier(file.getPath());
        	fileStringifier.display(outWriter);
        }
    }
  }
