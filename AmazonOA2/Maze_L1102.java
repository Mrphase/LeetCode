package AmazonOA2;
/*
Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].
The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.
A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).
Example 1:
Input: [[5,4,5],[1,2,6],[7,4,6]]
Output: 4
Explanation: 
The path with the maximum score is highlighted in yellow. 
 */
import java.util.PriorityQueue;
public class Maze_L1102 {class Solution {
    public int maximumMinimumPath(int[][] A) {
        int r = A.length;
        int c = A[0].length;
        int min = Math.min(A[r-1][c-1],A[0][0]);
        //max heap
        PriorityQueue<Unit> pq = new PriorityQueue<>((x1, x2)->x2.value-x1.value);
        int[][] visited = new int[r][c];
        int i=0,j=0;
        while(i!=r-1||j!=c-1){
            visited[i][j] = 1;
            int cur = A[i][j];
            //up
            if(i-1>=0&& visited[i-1][j]==0){
                visited[i-1][j] = 1;
                pq.offer(new Unit(A[i-1][j],i-1,j));
            }
            //down
            if(i+1<r&& visited[i+1][j]==0){
                if(reach(i+1,j,r,c))return min;
                visited[i+1][j] = 1;
                pq.offer(new Unit(A[i+1][j],i+1,j));
            }
            //left
            if(j-1>=0&& visited[i][j-1]==0){
                visited[i][j-1] = 1;
                pq.offer(new Unit(A[i][j-1],i,j-1));
            }
            //right
            if(j+1<c&& visited[i][j+1]==0){
                if(reach(i,j+1,r,c))return min;
                visited[i][j+1] = 1;
                pq.offer(new Unit(A[i][j+1],i,j+1));
            }
            //pick next step
            Unit next = pq.poll();
            if(next.value<min) min = next.value;
            i = next.row;
            j = next.cal;
        }
        return min;
    }
    public boolean reach(int i , int j , int r , int c){
        if(i==r-1 && j == c-1)return true;
        return false;
    }
    public class Unit{
        public int value;
        public int row;
        public int cal;
        public Unit(int value, int i , int j ){
            this.value = value;
            this.row = i;
            this.cal = j;
        }
    }
}
}
