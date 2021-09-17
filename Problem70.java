/*
    Problem 70. Climbing Stairs

    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class Problem70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 2];
        return climbStairsH(dp, n);
    }

    public int climbStairsH(int[] dp, int n) {
        if (n <= 2) {
            dp[n] = n;
        } else if (dp[n] == 0) {
            dp[n] = climbStairsH(dp, n - 1) + climbStairsH(dp, n - 2);
        }
        return dp[n];
    }
}
