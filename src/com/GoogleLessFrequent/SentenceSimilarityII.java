package com.GoogleLessFrequent;

import java.util.*;

/*
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.

For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar
word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.

Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.

Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

Note:

The length of words1 and words2 will not exceed 1000.
The length of pairs will not exceed 2000.
The length of each pairs[i] will be 2.
The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 *
 *
 */
public class SentenceSimilarityII {

    public static void main(String[] args) {
        String[] words1 = new String[]{"great", "acting", "skills"};
        String[] words2 = new String[]{"fine", "drama", "talent"};
        String[][] pairs = new String[][]{{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}};
        System.out.println(areSentencesSimilarTwo(words1,words2,pairs));
    }

    /*
     * Complexity Analysis
     *
     * Time Complexity: O(NP)O(NP), where NN is the maximum length of words1 and words2, and PP is the length of pairs.
     * Each of NN searches could search the entire graph.
     *
     * Space Complexity: O(P)O(P), the size of pairs.
     */
    public static boolean areSentencesSimilarTwo(
            String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, List<String>> graph = new HashMap();
        for (String[] pair: pairs) {
            for (String p: pair) if (!graph.containsKey(p)) {
                graph.put(p, new ArrayList());
            }
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }

        for (int i = 0; i < words1.length; ++i) {
            String w1 = words1[i], w2 = words2[i];
            Stack<String> stack = new Stack();
            Set<String> seen = new HashSet();
            stack.push(w1);
            seen.add(w1);
            search: {
                while (!stack.isEmpty()) {
                    String word = stack.pop();
                    if (word.equals(w2)) break search;
                    if (graph.containsKey(word)) {
                        for (String nei: graph.get(word)) {
                            if (!seen.contains(nei)) {
                                stack.push(nei);
                                seen.add(nei);
                            }
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
}
