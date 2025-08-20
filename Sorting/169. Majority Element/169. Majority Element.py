class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        counts = {} # Initialize Dictionary

        # Counting the appearrance of elements
        for num in nums:
            counts[num] = counts.get(num, 0) + 1

        for key, value in counts.items():
            if value > len(nums) // 2:
                return key

        return -1
