class Solution(object):
    def lengthOfLongestSubstring(self, s):
        find = {}
        j = 0
        max_length = 0
        for i in range(len(s)):
            if s[i] in find:
                j = max(j,find[s[i]]+1)
            find[s[i]] = i
            max_length = max(max_length,i-j+1)
        return max_length    
        