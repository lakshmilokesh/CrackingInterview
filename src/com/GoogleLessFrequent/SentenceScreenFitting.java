package com.GoogleLessFrequent;

/*
 * Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given
 * sentence can be fitted on the screen.
 *
Note:

A word cannot be split into two lines.
The order of words in the sentence must remain unchanged.
Two consecutive words in a line must be separated by a single space.
Total words in the sentence won't exceed 100.
Length of each word is greater than 0 and won't exceed 10.
1 ≤ rows, cols ≤ 20,000.
Example 1:

Input:
rows = 2, cols = 8, sentence = ["hello", "world"]

Output:
1

Explanation:
hello---
world---

The character '-' signifies an empty space on the screen.
Example 2:

Input:
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

Output:
2

Explanation:
a-bcd-
e-a---
bcd-e-
 *
 *
 *
 */
public class SentenceScreenFitting {

    public static void main(String[] args) {
        String[] sentence = new String[] {"abc", "de", "f"};
        System.out.println(wordsTyping(sentence,3,6));
    }

    public static int wordsTyping(String[] sentence, int rows, int cols) {

        String jSentence = String.join(" ", sentence) + " ";
        int nextRowStart = 0;
        for(int row = 0; row < rows; row++)
        {
            // Optimistically include everything from the new row and we'll strip it from the end
            // to see how much we can fit
            nextRowStart += cols;

            // Shrink till we find the last new space (end of a word)
            while(nextRowStart > 0 && jSentence.charAt(nextRowStart % jSentence.length()) != ' ') {
                nextRowStart--;
            }

            // We have filled up the current row, let's move on to the next row, start with the next word
            // after the space
            nextRowStart++;
        }

        // We have found all the characters we can fill
        return (nextRowStart)/jSentence.length();
    }
}
