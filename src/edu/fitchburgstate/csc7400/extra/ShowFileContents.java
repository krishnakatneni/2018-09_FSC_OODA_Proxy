package edu.fitchburgstate.csc7400.extra;

// import File and PrintWriter classes
import java.io.File;
import java.io.PrintWriter;

/**
 * This program prints the contents of all the files 
 * in the given directory.
 * @author vamsi
 *
 */
public class ShowFileContents {
	
	/**
	 * Accepts a directory name as string and then prints 
	 * out the contents of all the files in that directory.
	 * @param args
	 */
	public static void main(String[] args) {
		// Check if args length is not 1, display an error message
        if (args.length != 1) {
            System.out.println("Usage: java ShowFileContents <directory>");
        }
        // store 0th argument in a string variable
        String dirname = args[0];
        // To create a new File instance with the given pathname string to abstract pathname.
        File dir = new File(dirname);
        // Tests whether the file or directory denoted by this abstract pathname exists. If not exists print the error and return
        if (!dir.exists()) {
            System.err.println(dirname + " does not exist");
            return;
        }
        // Tests whether the file denoted by this pathname is a directory. If not directory print the error string and return
        if (!dir.isDirectory()) {
            System.err.println(dirname + " is not a directory");
            return;
        }
        // Create a PrintWriter object to write on Console
        PrintWriter outWriter = new PrintWriter(System.out);
        // Iterate  for all list of files in the directory which is sent as command line argument file by file. 
        // If file is a directory, don't do any thing, continue loop
        for (File file: dir.listFiles()) {
        	if (file.isDirectory()) continue;
        	// create a SlowFileStringifier object by converting abstract pathname into a pathname string.
        	// call display method by sending outwriter to display content on console.
        	FileStringifier fileStringifier = new SlowFileStringifier(file.getPath());
        	fileStringifier.display(outWriter);
        }
    }
  }
