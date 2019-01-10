package edu.fitchburgstate.csc7400.extra;

import java.io.*;
import java.util.ArrayList;

public class SlowFileStringifier implements FileStringifier {

    public SlowFileStringifier(String filename) {
        this.fileName = filename;
    }

    public void display(PrintWriter out) {
    	out.println(this.stringify());
    	out.flush();
    }
    
    public String stringify() {
        FileReader f;
		try {
			f = new FileReader(this.fileName);
	        BufferedReader bf = new BufferedReader(f);
	
	        ArrayList<String> lines = new ArrayList<String>();
	        String line = null;
	        while ((line = bf.readLine()) != null) {
	            Thread.sleep(2000);
	            lines.add(line);
	        }
	        bf.close();
	        return String.join("\n", lines);
        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("File "+this.fileName+" was not found.");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Problem reading file "+this.fileName+".");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.err.println("File reading interrupted: "+this.fileName);
		}
		return "";
    }

    private final String fileName;
}
