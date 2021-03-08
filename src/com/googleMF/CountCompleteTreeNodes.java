package com.googleMF;

/*
 *  Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last
 * level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:

Input:
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6


 * Complexity Analysis

Time complexity : O(N).
Space complexity : \mathcal{O}(d) = \mathcal{O}(\log N)O(d)=O(logN) to keep the recursion stack, where d is a tree depth.

 *
 */

import com.binarytree.TreeNode;

public class CountCompleteTreeNodes {

    // Linear Time
//    public int countNodes(TreeNode root) {
//        return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
//    }

        // Return tree depth in O(d) time.
        public int computeDepth(TreeNode node) {
            int d = 0;
            while (node.left != null) {
                node = node.left;
                ++d;
            }
            return d;
        }

        // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
        // Return True if last level node idx exists.
        // Binary search with O(d) complexity.
        public boolean exists(int idx, int d, TreeNode node) {
            int left = 0, right = (int)Math.pow(2, d) - 1;
            int pivot;
            for(int i = 0; i < d; ++i) {
                pivot = left + (right - left) / 2;
                if (idx <= pivot) {
                    node = node.left;
                    right = pivot;
                }
                else {
                    node = node.right;
                    left = pivot + 1;
                }
            }
            return node != null;
        }

        public int countNodes(TreeNode root) {
            // if the tree is empty
            if (root == null) return 0;

            int d = computeDepth(root);
            // if the tree contains 1 node
            if (d == 0) return 1;

            // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
            // Perform binary search to check how many nodes exist.
            int left = 1, right = (int)Math.pow(2, d) - 1;
            int pivot;
            while (left <= right) {
                pivot = left + (right - left) / 2;
                if (exists(pivot, d, root)) left = pivot + 1;
                else right = pivot - 1;
            }

            // The tree contains 2**d - 1 nodes on the first (d - 1) levels
            // and left nodes on the last level.
            return (int)Math.pow(2, d) - 1 + left;
        }

}
