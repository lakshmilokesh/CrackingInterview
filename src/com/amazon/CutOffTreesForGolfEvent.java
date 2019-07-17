package com.amazon;

/*
 * You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in
 * this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the
tree's height.
You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with
lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees.
 If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

Input:
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6

Input:
[
 [1,2,3],
 [0,0,0],
 [7,6,5]
]
Output: -1
 *
 */

import java.util.*;

public class CutOffTreesForGolfEvent {


    static int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        List<List<Integer>> trees = new ArrayList<List<Integer>>();
        List<Integer> rows = new ArrayList<>();
        rows.add(1);
        rows.add(2);
        rows.add(3);
        trees.add(rows);
        rows = new ArrayList<>();
        rows.add(0);
        rows.add(0);
        rows.add(0);
        trees.add(rows);
        rows = new ArrayList<>();
        rows.add(7);
        rows.add(6);
        rows.add(5);
        trees.add(rows);

        System.out.println(cutOffTree(trees));

    }

    public static int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) return 0;
        int m = forest.size(), n = forest.get(0).size();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new int[] {i, j, forest.get(i).get(j)});
                }
            }
        }

        int[] start = new int[2];
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int step = minStep(forest, start, tree, m, n);

            if (step < 0) return -1;
            sum += step;

            start[0] = tree[0];
            start[1] = tree[1];
        }

        return sum;
    }

    private static int minStep(List<List<Integer>> forest, int[] start, int[] tree, int m, int n) {
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == tree[0] && curr[1] == tree[1]) return step;

                for (int[] d : dir) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n
                            || forest.get(nr).get(nc) == 0 || visited[nr][nc]) continue;
                    queue.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
            step++;
        }

        return -1;
    }
}
