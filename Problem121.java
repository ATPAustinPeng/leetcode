/*
	121. Best Time to Buy and Sell Stock

	You are given an array prices where prices[i] is the price of a given stock on the ith day.
	You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
	Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

	Example 1:
	Input: prices = [7,1,5,3,6,4]
	Output: 5
	Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
	Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

	Example 2:
	Input: prices = [7,6,4,3,1]
	Output: 0
	Explanation: In this case, no transactions are done and the max profit = 0.

	Constraints:
	1 <= prices.length <= 105
	0 <= prices[i] <= 104
*/

public class Problem121 {
	public int maxProfit(int[] prices) {
        // track runningMin, always recalculate difference and save maxDifference
        // if difference is negative, don't update
        if (prices.length < 1) {
            return 0;
        }
        
        int runningMin = prices[0];
        int res = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < runningMin) {
                runningMin = prices[i];
            } else if (prices[i] - runningMin > res) {
                res = prices[i] - runningMin;
            }
        }
        return res;
    }
}
