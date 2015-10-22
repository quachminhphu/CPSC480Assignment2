import static org.junit.Assert.*;

import org.junit.Test;






import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Scanner;

public class ReversalTest {
	private static final String INPUT  = "input.txt";
	private static final String OUTPUT = "output.txt";
	
	@Test
	public void testReversal() {
		Reversal myReversal = new Reversal();
		boolean isReversalClass = (myReversal.getClass()==Reversal.class);
		assertTrue(isReversalClass);
	}
	@Test
	public void testInputFileEmpty() {
		try {
			File inputFile  = new File( INPUT  );
			File outputFile = new File( OUTPUT ); 
			
			// If assert fails it is (usually) because the file was (wrongly) left open in an earlier run.  
			// Using a file manager application (e.g. explorer), go to project directory and delete it.
			// Make sure that your program closes these files before ending.
			if (inputFile.exists() ) {
				assertTrue( "Your program left \""+INPUT +"\" open in a previous test.", inputFile .delete() );
			}
			if (outputFile.exists()) {
				assertTrue( "Your program left \""+OUTPUT+"\" open in a previous test.", outputFile.delete() );
			
			}
			
			// create INPUT file
			PrintWriter input = new PrintWriter( inputFile );
			input.println( "" );
			input.close();

			// invoke program
			Reversal.reverseFile(inputFile, outputFile);
			
			// verify OUTPUT file exists and is empty
			assertTrue ( "Output file doesn't exist", outputFile.exists() );
			Scanner output = new Scanner( outputFile );
			boolean empty  = !output.hasNext(); 
			output.close();

			assertTrue( "Output file should be empty", empty );

			// delete I/O files (if they exist)
			inputFile.delete();
			outputFile.delete();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	
	@Test
	public void testInputFileWithOneWord() {
		try {
			File inputFile  = new File( INPUT  );
			File outputFile = new File( OUTPUT );
			
			// If assert fails it is (usually) because the file was (wrongly) left open in an earlier run.  
			// Using a file manager application (e.g. explorer), go to project directory and delete it.
			// Make sure that your program closes these files before ending.
			if (inputFile.exists() ) {
				assertTrue( "Your program left \""+INPUT +"\" open in a previous test.", inputFile .delete() );
			}
			if (outputFile.exists()) {
				assertTrue( "Your program left \""+OUTPUT+"\" open in a previous test.", outputFile.delete() );
			}
			
			// create INPUT file
			PrintWriter input = new PrintWriter( inputFile );
			input.println( "aribaca" );
			input.close();

			// invoke program
			Reversal.reverseFile(inputFile, outputFile);
			
			// verify OUTPUT file exists and has values
			assertTrue ( "Output file doesn't exist", outputFile.exists() );
			// (a) read file into list
			ArrayList<String> file   = new ArrayList<String>();
			Scanner           output = new Scanner( outputFile );
			while (output.hasNext()) {
				String    line = output.nextLine(); 
				file.add( line );
			}
			output.close();
			// (b) check results from list
			assertEquals( "Incorrect number of results", 1,  file.size() );
			assertEquals( "Incorrect result", "aribaca", file.get( 0 ));

			// delete I/O files (if they exist)
			inputFile .delete();
			outputFile.delete();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	
	@Test
	public void testInputFileMultipleWordWithoutBlankLine() {
		try {
			File inputFile  = new File( INPUT  );
			File outputFile = new File( OUTPUT );
			
			// If assert fails it is (usually) because the file was (wrongly) left open in an earlier run.  
			// Using a file manager application (e.g. explorer), go to project directory and delete it.
			// Make sure that your program closes these files before ending.
			if (inputFile.exists() ) {
				assertTrue( "Your program left \""+INPUT +"\" open in a previous test.", inputFile .delete() );
			}
			if (outputFile.exists()) {
				assertTrue( "Your program left \""+OUTPUT+"\" open in a previous test.", outputFile.delete() );
			}
			
			// create INPUT file
			PrintWriter input = new PrintWriter( inputFile );
			input.println( "brabra nanana dedede." );
			input.println( "apapa. djdjdj; nina nanana" );
			input.println( "zebra ect." );
			input.println( "kitet itchyyyy" );
			input.println( "kappa" );
			input.println( " ");
			input.println( "River is long" );
			input.println( "  " );
			input.close();

			// invoke program
			Reversal.reverseFile(inputFile, outputFile);
			
			// verify OUTPUT file exists and has values
			assertTrue ( "Output file doesn't exist", outputFile.exists() );
			// (a) read file into list
			ArrayList<String> file   = new ArrayList<String>();
			Scanner           output = new Scanner( outputFile );
			while (output.hasNext()) {
				String    line = output.nextLine(); 
				file.add( line );
			}
			output.close();
			// (b) check results from list
			assertEquals( "Incorrect number of results",					 6, file.size() );
			assertEquals( "Incorrect result", "long is River",      			file.get(  0 ));
			assertEquals( "Incorrect result", "kappa",       					file.get(  1 ));
			assertEquals( "Incorrect result", "itchyyyy kitet",      			file.get(  2 ));
			assertEquals( "Incorrect result", "ect. zebra",    					file.get(  3 ));
			assertEquals( "Incorrect result", "nanana nina djdjdj; apapa.",     file.get(  4 ));
			assertEquals( "Incorrect result", "dedede. nanana brabra",     		file.get(  5 ));
			
			// delete I/O files (if they exist)
			inputFile .delete();
			outputFile.delete();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
	
	@Test
	public void testInputFileMultipleWordWithBlankLine() {
		try {
			File inputFile  = new File( INPUT  );
			File outputFile = new File( OUTPUT );
			
			// If assert fails it is (usually) because the file was (wrongly) left open in an earlier run.  
			// Using a file manager application (e.g. explorer), go to project directory and delete it.
			// Make sure that your program closes these files before ending.
			if (inputFile.exists() ) {
				assertTrue( "Your program left \""+INPUT +"\" open in a previous test.", inputFile .delete() );
			}
			if (outputFile.exists()) {
				assertTrue( "Your program left \""+OUTPUT+"\" open in a previous test.", outputFile.delete() );
			}
			
			// create INPUT file
			PrintWriter input = new PrintWriter( inputFile );
			input.println( "brabra nanana dedede." );
			input.println( "apapa. djdjdj; nina nanana" );
			input.println( "zebra ect." );
			input.println( "    " );
			input.println( "kitet itchyyyy" );
			input.println( "kappa" );
			input.println( "River is long" );
			input.println( "" );
			input.close();

			// invoke program
			Reversal.reverseFile(inputFile, outputFile);
			
			// verify OUTPUT file exists and has values
			assertTrue ( "Output file doesn't exist", outputFile.exists() );
			// (a) read file into list
			ArrayList<String> file   = new ArrayList<String>();
			Scanner           output = new Scanner( outputFile );
			while (output.hasNext()) {
				String    line = output.nextLine(); 
				file.add( line );
			}
			output.close();
			// (b) check results from list
			assertEquals( "Incorrect number of results",					 6, file.size() );
			assertEquals( "Incorrect result", "long is River",      			file.get(  0 ));
			assertEquals( "Incorrect result", "kappa",       					file.get(  1 ));
			assertEquals( "Incorrect result", "itchyyyy kitet",      			file.get(  2 ));
			assertEquals( "Incorrect result", "ect. zebra",    					file.get(  3 ));
			assertEquals( "Incorrect result", "nanana nina djdjdj; apapa.",     file.get(  4 ));
			assertEquals( "Incorrect result", "dedede. nanana brabra",     		file.get(  5 ));
			
			// delete I/O files (if they exist)
			inputFile .delete();
			outputFile.delete();
		} 
		catch (IOException e) {
			fail( "No exception should be thrown" );
		}
	}
}
