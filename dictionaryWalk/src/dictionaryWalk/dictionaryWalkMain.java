package dictionaryWalk;

import java.io.IOException;
import java.util.ArrayList;

public class dictionaryWalkMain 
{
	// main
	public static void main (String[]args) throws IOException
	{
		// create new instance of dictionaryWalker with two input words
		dictionaryWalker myDictionaryWalker = new dictionaryWalker("CRAWL","RUN");
		
		// call getSolution method on the instance of the dictionaryWalker object
		ArrayList<String> solution = myDictionaryWalker.getSolution();
		
		// loop through solution ArrayList and print results
		for (String s: solution)
		{
			System.out.println(s);
		} // end for 

	} // end main
	
} // end dictionaryWalkMain
