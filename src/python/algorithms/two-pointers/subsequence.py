"""
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a sequence of characters that can be obtained by deleting 
some (or none) of the characters from the original string, while maintaining the relative 
order of the remaining characters. For example, "ace" is a subsequence of "abcde" while "aec" is not.

Time Complexity: O(n)
Space Complexity: O(1)

"""

# Function to check if string s is a subsequence of string t
def isSubsequence(s: str, t: str):
        i = j = 0
        while i < len(s) and j < len(t):
            if s[i] == t[j]:
                i += 1
            j += 1

        return i == len(s)

str1 = "ace"
str2 = "abcde"
print("str1: " + str1 + " str2: " + str2 + " isSubsequence: " + str(isSubsequence(str1, str2)))

