package dictionaryWalk;

import java.io.IOException;
import java.util.ArrayList;

public class dictionaryWalker
{
	// Initialize variables used in the class 
	private String word1;
	private String word2;
	private char[] alphabet;
	
	// create constructor methods which takes two String words as inputs and returns an ArrayList
	public dictionaryWalker(String a, String b)
	{			
		// set up the two words as Strings and character arrays for processing
		word1 = a;
		word2 = b;
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
	} // end constructor 
	
	// method to get an ArrayList of the adjacent words between word1 and word2 
	public ArrayList<String> getSolution() throws IOException
	{
		// create ArrayList to store the solution words
		ArrayList<String> solutionArrayList = new ArrayList<String>();
		
		// create ArrayLists to store all sets of adjacent words for word 1 and word 2 
		ArrayList<ArrayList<String>> fullPaths1 = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> fullPaths2 = new ArrayList<ArrayList<String>>();
		
		// Initialize sets ArrayList with the set of words adjacent to word 1 and word 2
		fullPaths1.add(getAdjacentWords(word1));
		fullPaths2.add(getAdjacentWords(word2));
		
		// create variables to track looping through adjacent word sets
		int counter = 0;
		boolean midWordFound = false;
		
		// create variable which is common between extended adjacent sets of both word 1 and word 2
		String midWord = new String();
		
		// if word1 and word 2 are adjacent to each other add them to the solution ArrayList
		// and do not enter the path searching loop
		if (isAdjacent(word1,word2))
		{
			solutionArrayList.add(word1);
			solutionArrayList.add(word2);
			midWordFound = true;
		} // end if 
		
		// if the two words are not adjacent, search their lists of adjacent words for a path
		else
		{
		
			while (!midWordFound && counter < 100)
			{
				ArrayList<ArrayList<String>> currentLevelExtendedList1 = new ArrayList<ArrayList<String>>();
				ArrayList<ArrayList<String>> currentLevelExtendedList2 = new ArrayList<ArrayList<String>>();
				
				ArrayList<String> currentLevelAdditionList1 = new ArrayList<String>();
				ArrayList<String> currentLevelAdditionList2 = new ArrayList<String>();
				
				// search for a common word at the current extended ArrayList level
				for(String v:fullPaths1.get(counter))
				{
					if(fullPaths2.get(counter).contains(v))
					{
						midWordFound = true;
						midWord = v;
					} // end if 
						
				} // end for
				
				// if a common word is not found, continue extending the adjacent words lists
				if (!midWordFound)
				{
					// add a level of adjacent words from the word 1 path
					for (String w: fullPaths1.get(counter))
					{
						currentLevelExtendedList1.add(getAdjacentWords(w));
					} // end for 
					
					// add a level of adjacent words from the word 2 path
					for (String x: fullPaths2.get(counter))
					{
						currentLevelExtendedList2.add(getAdjacentWords(x));
					} // end for
					
					// store all strings from the 2D ArrayList for word 1 path in currentLevelAdditionList1
					for (ArrayList<String> w: currentLevelExtendedList1)
					{
						for (String y: w)
						{
							if (!currentLevelAdditionList1.contains(y) && !y.equals(word1))
							{
								currentLevelAdditionList1.add(y);
							} // end if 
						} // end for 
						
					} // end for 
					
					// store all strings from the 2D ArrayList for word 2 path in currentLevelAdditionList2
					for (ArrayList<String> x: currentLevelExtendedList2)
					{
						for (String z: x)
						{
							if (!currentLevelAdditionList2.contains(z) && !z.equals(word2))
							{
								currentLevelAdditionList2.add(z);
							} // end if 
						} // end for 
						
					} // end for
					
					// unload all extended adjacent Strings at the current level into the next level of the fullPaths lists
					fullPaths1.add(currentLevelAdditionList1);
					fullPaths2.add(currentLevelAdditionList2);
					counter ++;
					
				} // end if 
				
			} // end while 
		
			// if a common word is found then trace back words through the path and add to the SolutionArrayList
			if (midWordFound)
			{
				// if a common word was found in the adjacent word lists of each word
				if (counter == 0)
				{
					solutionArrayList.add(word1);
					solutionArrayList.add(midWord);
					solutionArrayList.add(word2);
				} // end if 		
				
				// if a common word is found more than one list away from the original words
				else if (counter > 0)
				{
					String currentWord = midWord;
					ArrayList<String> path1Solution = new ArrayList<String>();
					ArrayList<String> path2Solution = new ArrayList<String>();
					
					// search the path backwards to word2
					for (int j = counter-1; j >= 0; j--)
					{
						boolean stillSearching = true;
						
						for (String t: fullPaths2.get(j))
						{
							if (isAdjacent(currentWord,t) && stillSearching)
							{
								currentWord = t;
								path2Solution.add(currentWord);
								stillSearching = false;
							} // end if 
							
						} // end for 
						
					} // end for
					
					
					currentWord = midWord;
					
					// search the path backwards to word1
					for (int i = counter-1; i >= 0; i--)
					{
						boolean stillSearching = true;
						
						for (String s: fullPaths1.get(i))
						{
							if (isAdjacent(currentWord,s) && stillSearching)
							{
								currentWord = s;
								path1Solution.add(currentWord);
								stillSearching = false;
							} // end if 
							
						} // end for 
						
					} // end for 
					
					
					if (!solutionArrayList.contains(word1))
					{
						solutionArrayList.add(word1);
					} // end if 
					

					for(int i = path1Solution.size(); i > 0; i --)
					{
						if (!solutionArrayList.contains(path1Solution.get(i-1)))
						{
							solutionArrayList.add(path1Solution.get(i-1));
						} // end if 
						
					} // end for
					
					
					
					if (!solutionArrayList.contains(midWord))
					{
						solutionArrayList.add(midWord);
					} // end if 
					

					
					for(int i = 0; i < path2Solution.size(); i ++)
					{
						if (!solutionArrayList.contains(path2Solution.get(i)))
						{
							solutionArrayList.add(path2Solution.get(i));
						} // end if 
						
					} // end for
					
					if (!solutionArrayList.contains(word2))
					{
						solutionArrayList.add(word2);
					} // end if 
								
					
				} // end else if 
				
			} // end if 
	
			// if no common word was found
			else
			{
				solutionArrayList.add("No Path Found");
			}
		
		} // end else 
		
		return solutionArrayList;
		
	} // end get solution
	
	
	
	
	// tests if s is adjacent to r 
	public boolean isAdjacent(String r, String s) throws IOException
	{
		// if the list of words adjacent to r contains s, then return true
		if (getAdjacentWords(r).contains(s))
		{
			return true;
		} // end if 
		
		else
		{
			return false;
		} // end else
		
	} // end isAdjacent
	
	
	// method to get a list of all words adjacent to the input parameter String
	public ArrayList<String> getAdjacentWords(String s) throws IOException
	{
		String currentString = s;
		ArrayList<String> possibleWords = new ArrayList<String>();
		ArrayList<String> adjacentWords = new ArrayList<String>();
		ArrayList<String> dictionaryWordsList = new ArrayList<String>();
		
		dictionaryWordsList = new dictionaryWords().getWordsArrayList();
		
		for (int i = 0; i < currentString.length(); i ++)
		{
			// to add a letter at the beginning of the word and the first letter
			if (i == 0)
			{
				// add each letter of the alphabet to the beginning of currentString
				for (int j = 0; j <alphabet.length; j ++)
				{
					// add each letter of the alphabet to the beginning of the word
					possibleWords.add(String.valueOf(alphabet[j]).concat(currentString));
					// replace the current character with the current alphabet letter
					possibleWords.add(currentString.substring(i,i) + String.valueOf(alphabet[j]) + currentString.substring(i+1,currentString.length()));
					// add the current alphabet letter after the current character
					possibleWords.add(currentString.substring(i,i+1) + String.valueOf(alphabet[j]) + currentString.substring(i+1,currentString.length()));
					// delete the current character
					possibleWords.add(currentString.substring(i+1,currentString.length()));
					
				} // end for 
				
			} // end if 
			
			// replace letters and spaces in between the first and last letter
			if (i > 0 && i < currentString.length() - 1)
			{
				for (int k = 0; k < alphabet.length; k ++)
				{
					// replace the current character with the current alphabet letter
					possibleWords.add(currentString.substring(0,i) + String.valueOf(alphabet[k]) + currentString.substring(i+1,currentString.length()));
					// add the current alphabet letter after the current character
					possibleWords.add(currentString.substring(0,i+1) + String.valueOf(alphabet[k]) + currentString.substring(i+2,currentString.length()));
					// delete the current character
					possibleWords.add(currentString.substring(0,i) + currentString.substring(i+1,currentString.length()));
				} // end for
				
			} // end if 
				
			if ( i == currentString.length() - 1)
			{
				// add each letter of the alphabet to the end of currentString
				for (int j = 0; j <alphabet.length; j ++)
				{
					// replace the current character with the current alphabet letter
					possibleWords.add(currentString.substring(0,i) + String.valueOf(alphabet[j]));
					// add the current letter to the end of the currentString 
					possibleWords.add(currentString.concat(String.valueOf(alphabet[j])));
					// delete the current character
					possibleWords.add(currentString.substring(0,i));
				} // end for 
			}

			
		} // end for
		
		// loop through possible words and find which ones are valid words according to the dictionary list
		for (String q: possibleWords)
		{
			if(dictionaryWordsList.contains(q))
			{
				if (!adjacentWords.contains(q))
				{
					adjacentWords.add(q);
				} // end if 
				
			} // end if
			
		} // end for
		
		return adjacentWords;
	} // end getAdjacentWords
	
	
	/*
	// method to find if the two words are one character off from each other 
	public Boolean oneOff(String a, String b)
	{
		// initialize variables used in comparing the two char arrays
		Boolean isOneOff = false;
		int mismatches = 0;
		int backMismatches = 0;
		String wordA = a;
		String wordB = b;
		
		char[] wordACharArray = wordA.toCharArray();
		char[] wordBCharArray = wordB.toCharArray();
		
		// case for words of an equal length
		if (wordACharArray.length == wordBCharArray.length)
		{  
			// loop through word A and search for character mismatches
			for (int i = 0; i < wordACharArray.length; i ++)
			{
				if (!wordB.contains(String.valueOf(wordACharArray[i])) )
				{
					mismatches ++;
				} // end if 
				
			} // end for
			
			// loop through word B and search for character mismatches
			for (int i = 0; i < wordACharArray.length; i ++)
			{
				if (!wordA.contains(String.valueOf(wordBCharArray[i])) )
				{
					backMismatches ++;
				} // end if 
							
			} // end for
			
			// if the maximum number of mismatches found in the binary comparison is 1 
			if (Math.max(mismatches, backMismatches) == 1)
			{
				isOneOff = true;
			} // end if 
			
		} // end if 
		
		// case for words of unequal lengths
		if (wordACharArray.length != wordBCharArray.length)
		{
			
			// case for word A being 1 character longer than word B
			if (wordACharArray.length == wordBCharArray.length + 1)
			{
				for (int i = 0; i < wordBCharArray.length; i ++)
				{
					if (!wordA.contains(String.valueOf(wordBCharArray[i])) )
					{
						mismatches ++;
					} // end if 
					
				} // end for
				
				if (mismatches == 1)
				{
					isOneOff = true;
				} // end if
				
			} // end if 
			
			// case for word B being 1 character longer than word A
			if (wordBCharArray.length == wordACharArray.length + 1)
			{
				
				for (int i = 0; i < wordACharArray.length; i ++)
				{
					if (!wordB.contains(String.valueOf(wordACharArray[i])) )
					{
						mismatches ++;
					} // end if 
					
				} // end for
				
				if (mismatches == 1)
				{
					isOneOff = true;
				} // end if
				
			} // end if 			
			
		} // end if
		
		return isOneOff;
		
	} // end one off
	*/
	
} // end dictionaryWalker
