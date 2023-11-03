"""
Given two sorted integer arrays arr1 and arr2, return a new array that 
combines/merges both of them and is also sorted.

"""

# Function to merge two sorted arrays into one
# Time Complexity : O(n1 + n2) where n1 = arr1.length and n2 = arr2.length
# Auxiliary Space : O(n1 + n2) 
def merge(arr1, arr2):
    # ans is the answer
    ans = []
    i = j = 0
    while i < len(arr1) and j < len(arr2):
        if arr1[i] < arr2[j]:
            ans.append(arr1[i])
            i += 1
        else:
            ans.append(arr2[j])
            j += 1
    
    while i < len(arr1):
        ans.append(arr1[i])
        i += 1
    
    while j < len(arr2):
        ans.append(arr2[j])
        j += 1
    
    return ans

# Function to merge two sorted arrays into one with improved performance
# Time Complexity : O(n) 
# Auxiliary Space : O(1) 
def merge2(arr1, arr2):
    # ans is the answer
    ans = []
    i = j = 0
    while i < len(arr1) and j < len(arr2):
        if arr1[i] < arr2[j]:
            ans.append(arr1[i])
            i += 1
        else:
            ans.append(arr2[j])
            j += 1
    
    while i < len(arr1):
        ans.append(arr1[i])
        i += 1
    
    while j < len(arr2):
        ans.append(arr2[j])
        j += 1
    
    return ans

nums1 = [11, 22, 33, 50]
nums2 = [37, 48, 59, 100]
print("nums1: " + str(nums1) + " nums2: " + str(nums2) + " merged: " + str(merge2(nums1, nums2)))

