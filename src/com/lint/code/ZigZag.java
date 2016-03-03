package com.lint.code;

/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING", 3));
	}

	public static String convert(String s, int nRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(nRows <= 1) return s;
		StringBuilder[] list = new StringBuilder[nRows];
		for(int i = 0; i < nRows; i++) list[i] = new StringBuilder();
		int row = 0;
		int i = 0;
		boolean down = true;
		while(i < s.length()){
			list[row].append(s.charAt(i));
			System.out.println("row" + row);
			System.out.println("char at " + i + "is " + s.charAt(i));
			if(row == 0) down = true;
			if(row == nRows-1) down = false;
			if(down) row++;
			else row --;
			i++;
			System.out.println("**" +list[row]);
		}
		StringBuilder res = new StringBuilder();
		for(StringBuilder sb : list) res.append(sb.toString());
		return res.toString();
	}
}



