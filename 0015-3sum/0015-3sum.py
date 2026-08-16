class Solution(object):
    def threeSum(self, nums):
        result = []
        n = len(nums)
        nums.sort()
        
        for i in range(n-2):
            left = i + 1
            right = n - 1

            if i > 0 and nums[i] == nums[i - 1]:
                continue
        
            while left < right:
                totalSum = nums[i] + nums[left] + nums[right]

                if totalSum == 0: 
                    result.append([nums[i],nums[left],nums[right]])
                    left += 1
                    right -= 1

                    while left  < right and nums[left] == nums[left - 1]: left+=1
                    while left  < right and nums[right] == nums[right + 1]: right-=1
                
                elif totalSum < 0:
                    left += 1
                else :
                    right -=1
        return result


    
        