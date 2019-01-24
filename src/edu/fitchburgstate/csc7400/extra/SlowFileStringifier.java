package edu.fitchburgstate.csc7400.extra;

import java.io.*;
import java.util.ArrayList;

/**
 * This class is used to display contents of a text file
 * which implements FileStringifier.
 * @author vamsi
 *
 *
 */
public class SlowFileStringifier implements FileStringifier {
	
	/**
	 * Create a SlowFileStringifier object with a file name.
	 * @param filename
	 * filename is name of the file.
	 * Constructor method with a string argument to 
	 * initialize private variable file name.
	 */
	public SlowFileStringifier(String filename) {
        this.fileName = filename;
    }
	
	@Override
	/**
	 * print the file contents to the PrintWriter
	 * @param out
	 * out is a PrintWriter object 
	 * @see edu.fitchburgstate.csc7400.extra.File
	 */
    public void display(PrintWriter out) {
    	// calls stringify() method which returns a String.
    	out.println(this.stringify());
    	out.flush();
    }
	
    @Override
    /**
     * Implementation of interface method which returns a String.
     * reads text from file line by line.
     * returns combined string which contains entire file content.
     * @see edu.fitchburgstate.csc7400.extra.FileStringifier#stringify()
     */
    public String stringify() {
        FileReader f;
		try {
			/* Create a FileReader object f with the given filename. 
			   It opens given filename in read mode. */
			f = new FileReader(this.fileName);
			/* Create a BufferedReader object bf with FileReader f. 
			   It creates a buffered character input stream. */
	        BufferedReader bf = new BufferedReader(f);
	        
	        // Create an ArrayList object.
	        ArrayList<String> lines = new ArrayList<String>();
	        String line = null;
	        /* read a line of text from file via buffered reader and 
	           assign in a String variable line until end of input stream. */
	        while ((line = bf.readLine()) != null) {
	        	// sleeps current thread for 2000 milli seconds.
	            Thread.sleep(2000);
	            lines.add(line);
	        }
	        // close buffered reader object.
	        bf.close();
	        // join all the lines with a new line delimeter and return to called method.
	        return String.join("\n", lines);
        
		}
		// handle file not found exception, if directory not exists.
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("File "+this.fileName+" was not found.");
		}
		// handle I/O exception, if file is not readable.
		catch (IOException e) {
			e.printStackTrace();
			System.err.println("Problem reading file "+this.fileName+".");
		} 
		// handle Interrupted exception, if file is not reading is interrupted.
		catch (InterruptedException e) {
			e.printStackTrace();
			System.err.println("File reading interrupted: "+this.fileName);
		}
		return "";
    }
    // Declare a  final variable fileName which cannot be modified  after once assigned.

    private final String fileName;
}
