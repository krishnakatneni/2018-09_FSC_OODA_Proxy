

package edu.fitchburgstate.csc7400.extra;

import java.io.*;
/*FileStringifier is an interface which contains two 
 * abstract methods display and stringify. 
 * These methods can be implemented by other class 
 * that implements this interface. A class that implements 
 * this interface must implement two methods declared here.
 */

public interface FileStringifier {
	//method declaration with PrintWriter as argument.
	void display(PrintWriter out);
	//method declaration which returns a String.
	public String stringify();
}