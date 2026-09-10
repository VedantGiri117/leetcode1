class Solution(object):
    def maxJump(self, stones):
        n = len(stones)
        mSize = stones[1] - stones[0]
        for i in range(2,n):
            mSize = max(mSize,stones[i] - stones[i-2])
        return mSize
        