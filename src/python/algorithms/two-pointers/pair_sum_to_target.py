"""
Given a sorted array of unique integers and a target integer, return true 
if there exists a pair of numbers that sum to target, false otherwise. 
This problem is similar to Two Sum. (In Two Sum, the input is not sorted).

For example, given nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13, return true because 4 + 9 = 13.

Time Complexity: O(n)
Space Complexity: O(1)

"""

# Function to check if pair of nums sum up to target value
def check_for_target(nums, target):
    left = 0
    right = len(nums) - 1

    while left < right:
        # curr is the current sum
        curr = nums[left] + nums[right]
        if curr == target:
            return True
        if curr > target:
            right -= 1
        else:
            left += 1
    
    return False

target = 13
nums = [1, 2, 4, 6, 8, 9, 14, 15]
print("target sum: " + str(target) + " found in: " + str(nums) + " " + str(check_for_target(nums, target)))

