package edu.fitchburgstate.csc7400.extra;

import java.io.*;

/** 
 * FileStringifier is an interface which contains 
 * two abstract methods display and stringify. 
 * These methods can be implemented by other class that 
 * implements this interface. A class that implements 
 * this interface must implement two methods declared here.
 * @author vamsi
 */
public interface FileStringifier {
	
	/**
	 * This method is used to print the contents of file on console.
	 * @param out
	 */
	void display(PrintWriter out);
	
	/**
	 * This method returns a String.
     * reads text from file line by line.
     * returns combined string which contains entire file content.
	 * @return string
	 */
	public String stringify();
}
