import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;


public class Reversal {
	
	/*
	 * This method receives input file and put word in container 
	 */
	
	
	
	public static void readFile (File input ,Stack<String> container) throws FileNotFoundException{
		Scanner reader = new Scanner(input);
		while (reader.hasNextLine()){
			// Start a new line 
			container.add(new String("\0"));
			
			String line = reader.nextLine();
			Scanner lineProcessor = new Scanner(line);
			
			//Scan every word in the line 
			while (lineProcessor.hasNext()){
				String word = lineProcessor.next();
				container.push(word);
			}
			//finish a line 
			lineProcessor.close();
		}
		//Finish with ending character
		container.add(new String("\0"));
		
		reader.close();
		
	}
	
	/*
	 * This method receives container and write it into file in reverse order 
	 */
	public static void writeFile (File output, Stack<String> Container) throws FileNotFoundException{
		
		PrintWriter printer = new PrintWriter(output);
		String line="";
		String temp ="";
		String mynull ="\0";
		
		
		while (!Container.isEmpty()){
			temp = Container.pop();
			
			if(temp.equals(mynull)){
				if(line.isEmpty()){
					continue;
				}else {
					printer.println(line);
					line ="";
				}
			}else if( temp.equals(" ")){
				continue;
			
			}else {
				if(line.isEmpty()){
					line = line + temp;
				}else {
					line = line+ " "+temp;
				}
			}
			
			
		}
		printer.close();
		
		
	}
	
	/*
	 * The method receives input file and output file 
	 * Reads lines of text from the input file and writes these lines in reverse order 
	 */
	public static void reverseFile(File input, File output) throws FileNotFoundException {
		Stack<String> container = new Stack<String>();
		Reversal.readFile(input, container);
		Reversal.writeFile(output, container);
	}
}
