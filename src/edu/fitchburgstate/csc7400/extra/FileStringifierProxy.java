/**
 * File :			FileStringifierProxy
 * Created:			02/07/2019
 * Last Changed:	02/08/2019
 * Author:			vamsi
 */
package edu.fitchburgstate.csc7400.extra;

import java.io.PrintWriter;
import java.util.concurrent.Semaphore;
/**
 * This class implements FileStringifier and uses semaphore to control the access of threads
 */

public class FileStringifierProxy implements FileStringifier {
	
	private final String fileName;
	private final Semaphore Sem;
/*
 * This is constructor which set with the file name and semaphore
 * @param fliename which we have to display
 * @param sema which is a semaphore
 */
	FileStringifierProxy(String filename, Semaphore Sem) {
		this.fileName = filename;
		this.Sem = Sem;
	}
/*
 * This display method print the name of the file which it reads
 * Display the contents with a delay
 */
	public void display(final PrintWriter out) {
		System.out.println("Reading " + fileName);
		final SlowFileStringifier slowfilestringifier = new SlowFileStringifier(fileName);
		try {
			Sem.acquire();//acquire lock on thread
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		slowfilestringifier.display(out);// Display file content
		Sem.release();//release the lock

	}
	
/*
 * This a implemented method for class Filestringifier which returns null
 */
@Override
public String stringify() {
	// TODO Auto-generated method stub
	return null;
}
	
}
