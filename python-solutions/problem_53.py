def maxSubArray(self, nums: List[int]) -> int:
    maxSubSum = -sys.maxsize - 1
    currSubSum = 0
    
    for i in nums:
        currSubSum += i
        
        maxSubSum = max(maxSubSum, currSubSum)
        currSubSum = max(currSubSum, 0)
        
#             if currSubSum > maxSubSum:
#                 maxSubSum = currSubSum
        
#             if currSubSum < 0:
#                 maxSubSum = max(maxSubSum, currSubSum)
#                 currSubSum = 0
            
    return maxSubSum