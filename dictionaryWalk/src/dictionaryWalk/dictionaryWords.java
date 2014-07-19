package dictionaryWalk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class dictionaryWords 
{
	// Initialize ArrayList of dictionary words
	private ArrayList<String> dictionaryWordsArrayList;
	
	public dictionaryWords() throws IOException
	{		
		// create ArrayList to store dictionary words from Scrabble list file
		dictionaryWordsArrayList = new ArrayList<String>();
		
		// create BufferedReader to read words from TWL06.txt file 
		BufferedReader br = new BufferedReader(new FileReader("TWL06.txt"));
		
		// initialize String to hold the current line being read from the file 
		String line;
		
		// read file line by line until the end of the file is reached 
		while ((line = br.readLine()) != null) 
		{
		   dictionaryWordsArrayList.add(line);
		}
		
		// close BufferedReader stream
		br.close();
		
	} // end dictionaryWords 
	
	// getter method for dictionaryWordsArrayList
	public ArrayList<String> getWordsArrayList()
	{
		return dictionaryWordsArrayList;
	}

} // end class
