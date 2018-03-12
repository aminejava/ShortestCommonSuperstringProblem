/**
 * Shortest Common Super String Problem 
 * Solution for SuperString 1,2 and 3
 * @author Amine Ait Mansour
 */

import java.util.*;
import java.util.ArrayList;



public class SuperStringTester {

		
		
		public String compare(String a, String b) {
			String solution = "";
			for (int i=0; i < a.length(); i++) {
				String subA = a.substring(a.length() - b.length() + i);
				String subB = b.substring(0, b.length()-i);
				
				if (subA.equals(subB)) {
					solution = a + b.substring(b.length()-i);
					break;				
				}else {
					solution = a + b;
				}
				
			}	
			
			return solution;	
		  }
		
		
	// Function that receives the sequence and calls the othe function 
	// compare and compare2 
	public String inputLoop (String [] seq) {
		
		String a = "";
		String b = "";
		String returnVal = "";
		String shorterString = "";
		String shortestShorterString = "";
		String shortestVal = "";	
		int temp = 0;
		boolean updated = false; 
		
		
		for(int k = 0; k < seq.length; k++) {
			
			ArrayList<Integer> remVals = new ArrayList<Integer>();
			
			for (int i = 0; i < seq.length; i++) {
				
				if(i == 0) {
					a = seq[k];
					remVals.add(0);
					
				}else {
					a = shortestVal;
				}
				// Iterate through all the strings 
				for (int j = 0; j < seq.length; j++) {				
					b = seq[j];
				
					// This condition verifies if the strings are already in the substring calculated 
					if (!remVals.contains(j)  || i == 0) {
						
						
						// This condition avoids comparing the same sting e.g. S[0] and S[0]		
						if (j == 0) {
							// This function takes two stings and compares them then returns the shortest substring
							shortestVal = compare(a,b); 
						
						}else {
							//This function takes two stings and compares them then returns the shortest substring
							returnVal = compare(a,b);
						}
		
						if(returnVal.length() <= shorterString.length() || shorterString.length()== 0) {
											
							shorterString = returnVal;					
							temp = j;
							updated = true; 										
						}				
					}						
				}
				// Condition to add the new string that updated the substring 
				if (!remVals.contains(temp) ) {				
					remVals.add(temp);	
					
					}
		
				if(updated == true) {
				
					shortestVal = shorterString;
					shorterString = "";
					a = shortestVal;
					updated = false; 
					
				}	
			}
			// Check whether the final sub string is the shortest of all the short sub strings found
			if ((shortestShorterString.length() >= shortestVal.length() || shortestShorterString.length() == 0) && compare2(shortestVal, remVals, seq)) {
				
				shortestShorterString = shortestVal;
			}
		}	
			return shortestShorterString;
			
			
	  }

	public Boolean compare2 (String newVal, ArrayList<Integer> remVals, String [] sequence) {
			
		for(int i = 0; i < remVals.size(); i++){
		
			if(!newVal.contains(sequence[remVals.get(i)])){
				
				return false;			
			}
		
		}
		return true;
	}
			
	}
	


