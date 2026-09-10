class Solution {
    public int maxJump(int[] stones) {
        int mSize = stones[1] - stones[0];
        for(int i = 2 ; i < stones.length ; i++){
            mSize = Math.max(mSize,stones[i] - stones[i-2]);
        }
        return mSize;
        
    }
}