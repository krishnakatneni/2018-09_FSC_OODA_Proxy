/**
 * File:			FileStringifier.java
 * Created:			01/10/2019
 * Last Changed:	$Date: 02/05/2019 10:52 $
 * Author:			vamsi
 */

package edu.fitchburgstate.csc7400.extra;

import java.io.*;

/** 
 * interface class which contains 
 * two abstract methods display and stringify. 
 * 
 * These methods can be implemented by other class that 
 * implements this interface.
 * 
 * @author vamsi
 * 
 */
public interface FileStringifier {
	
	/**
	 * This method is used to print the contents of file on console.
	 * @param out is a PrintWriter object 
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
