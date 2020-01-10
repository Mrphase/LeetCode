package AmazonOA2;

import java.util.*;

public class Maze_AllWay_Min_value_of_dot2 {
    public int maximumMinimumPath(int[][] A) {
        final int[][] DIRS = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        pq.add(new int[] {A[0][0], 0, 0});
        int maxscore = A[0][0];
        A[0][0] = -1; // visited
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int i = top[1], j = top[2], n = A.length, m = A[0].length;
            maxscore = Math.min(maxscore, top[0]);
            if(i == n - 1 && j == m - 1)
                return maxscore;
            for(int[] d : DIRS) {
                int newi = d[0] + i, newj = d[1] + j;
                if(newi >= 0 && newi < n && newj >= 0 && newj < m && A[newi][newj]>=0){
                    pq.add(new int[] {A[newi][newj], newi, newj});
                    A[newi][newj] = -1;
                }
            }
        }
        return -1; // shouldn't get here
    }
}
