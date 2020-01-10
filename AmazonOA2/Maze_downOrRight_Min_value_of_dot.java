package AmazonOA2;

public class Maze_downOrRight_Min_value_of_dot {
    int maxScore2D(int[][] grid) {
        // Assume there is at least one element
        int r = grid.length, c = grid[0].length;
        int[][] dp = new int[r][c];
        // Init
        dp[0][0] = Integer.MAX_VALUE; // first entry is not considered
        for (int i = 1; i < r; ++i) dp[i][0] = Math.min(dp[i - 1][0], grid[i][0]);
        for (int j = 1; j < c; ++j) dp[0][j] = Math.min(dp[0][j - 1], grid[0][j]);
        // DP
        for (int i = 1; i < r; ++i) { // row by row
            for (int j = 1; j < c; ++j) {
                if (i == r - 1 && j == c - 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // last entry is not considered
                } else {
                    int score1 = Math.min(dp[i][j - 1], grid[i][j]); // left
                    int score2 = Math.min(dp[i - 1][j], grid[i][j]); // up
                    dp[i][j] = Math.max(score1, score2);
                }
            }
        }
        return dp[r - 1][c - 1];
    }

    // DP (One Row or Column)
    // Time: O(rc) Space: O(r or c)
    // DP (One Row or Column)
    private static int maxScore1D(int[][] grid) {
        // Assume there is at least one element
        int r = grid.length, c = grid[0].length;
        int[] dp = new int[c];
        // Init
        dp[0] = Integer.MAX_VALUE; // first entry is not considered
        for (int j = 1; j < c; ++j) dp[j] = Math.min(dp[j - 1], grid[0][j]);
        // DP (for each row)
        for (int i = 1; i < r; ++i) {
            // update the first element in each row
            dp[0] = Math.min(dp[0], grid[i][0]);
            for (int j = 1; j < c; ++j) {
                if (i == r - 1 && j == c - 1) {
                    dp[j] = Math.max(dp[j - 1], dp[j]); // last entry is not considered
                } else {
                    int score1 = Math.min(dp[j - 1], grid[i][j]); // left  dp[i][j-1]
                    int score2 = Math.min(dp[j], grid[i][j]);     // up    dp[i-1][j]
                    dp[j] = Math.max(score1, score2);
                }
            }
        }
        return dp[c - 1];
    }
}
