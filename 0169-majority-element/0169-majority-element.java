
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate  = Integer.MAX_VALUE;
        int count = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(count == 0){
                candidate = nums[i];
            }
            if(nums[i] == candidate){
                count++;
            }
            else count--;
        }
        return candidate;
        
    }
}