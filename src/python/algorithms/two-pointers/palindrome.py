"""
A palindrome is any word or phrase or sentence 
or dates of the year that reads the same both 
forward and backward. Examples are civic, radar, 
level, rotor, kayak, madam, and refer

Time Complexity: O(n)
Space Complexity: O(1)

"""

# Function to check if string is a palindrome
def check_if_palindrome(s):
    left = 0
    right = len(s) - 1

    while left < right:
        if s[left] != s[right]:
            return False
        left += 1
        right -= 1

    return True

str1 = "racecar"
print("str1: " + str1 + " isPalindrome: " + str(check_if_palindrome(str1)))

