package com.leet.code;

/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * 
 * 
 * 
 */
public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Length of Last word" + lengthOfLastWord("b    a   "));
	}

	public static int lengthOfLastWord(String s) {
		
		
		 if (s == null || s.length() == 0) {
		    return 0;
		}
		
		char[] c = s.trim().toCharArray();
		
		int start = c.length - 1;
		int end = 0;
		while (start >= end) {
		    if (c[start] == ' ')
		        break;
		    start--;      
		}
	    return c.length - (start+1);
	}

}
