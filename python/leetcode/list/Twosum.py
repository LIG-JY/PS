class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_dict = {}
        for i, v in enumerate(nums):
            nums_dict[v] = i
        for i, v in enumerate(nums):
            res = target - v
            if nums_dict.get(res) and nums_dict.get(res) != i:
                return [i , nums_dict.get(res)]
