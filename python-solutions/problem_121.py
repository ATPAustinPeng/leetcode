def maxProfit(self, prices: List[int]) -> int:
    max_profit = 0
    curr_min = prices[0]
    
    for price in prices:
        if price < curr_min:
            curr_min = price
        else:
            profit = price - curr_min
            if profit > max_profit:
                max_profit = profit
    return max_profit