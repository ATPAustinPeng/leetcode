def twoSum(self, nums: List[int], target: int) -> List[int]:
    comp = dict()
    
    for i in range(len(nums)):
        if (target - nums[i]) in comp:
            return [comp[target - nums[i]], i]
        comp[nums[i]] = i