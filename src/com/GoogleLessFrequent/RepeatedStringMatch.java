package com.GoogleLessFrequent;

/*
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it.
 * If no such solution, return -1.
 *
 * For example, with A = "abcd" and B = "cdabcdab".
 *
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A
 * repeated two times ("abcdabcd").
 *
 * Note:
 * The length of A and B will be between 1 and 10000.
 *
 *
 *
 */

public class RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        if(A.length()<1 && B.length()<1){
            return -1;
        }
        int maxLoop = B.length() / A.length() + 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<=maxLoop; i++){
            sb.append(A);
            //System.out.println(sb);
            if(sb.toString().contains(B)){
                return i+1;
            }
        }
        return -1;

    }
}
