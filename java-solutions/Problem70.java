/*
    70. Climbing Stairs

    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Example 1:
    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
    
    Example 2:
    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step

    Constraints:
    1 <= n <= 45
 */
public class Problem70 {
    // DP
    public int climbStairs(int n) {
        // dp array has size n + 1
        // dp[0] = 1, dp[1] = 2, dp[i] = dp[i - 1] + dp[i - 2]
        // Note: i - 1 = n
        if (n <= 2) {
            return n;
        }
        
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n - 1];
    }
    
    // RECURSIVE
    // public int climbStairs(int n) {
    //     int[] dp = new int[n + 2];
    //     return climbStairsH(dp, n);
    // }

    // public int climbStairsH(int[] dp, int n) {
    //     if (n <= 2) {
    //         dp[n] = n;
    //     } else if (dp[n] == 0) {
    //         dp[n] = climbStairsH(dp, n - 1) + climbStairsH(dp, n - 2);
    //     }
    //     return dp[n];
    // }
}