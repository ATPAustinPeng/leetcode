/*
    Problem 1137. N-th Tribonacci Number

    The Tribonacci sequence Tn is defined as follows:
    T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
    Given n, return the value of Tn.

    Example 1:
    Input: n = 4
    Output: 4
    Explanation:
    T_3 = 0 + 1 + 1 = 2
    T_4 = 1 + 1 + 2 = 4

    Example 2:
    Input: n = 25
    Output: 1389537

    Constraints:
    0 <= n <= 37
    The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
public class Problem1137 {
    public int tribonacci(int n) {
        int[] dp = new int[n + 2];
        return tribonacciH(dp, n);
    }

    public int tribonacciH(int[] dp, int n) {
        if (n <= 1) {
            dp[n] = n;
        } else if (n == 2) {
            dp[n] = tribonacciH(dp, n - 1) + tribonacciH(dp, n - 2);
        } else if (dp[n] == 0) {
            dp[n] = tribonacciH(dp, n - 1) + tribonacciH(dp, n - 2) + tribonacciH(dp, n - 3);
        }
        return dp[n];
    }
}
