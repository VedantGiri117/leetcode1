class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for(int candy : candies){
            maxCandies = Math.max(maxCandies,candy);
        }

        List<Boolean> res = new ArrayList<>();
        for(int candy : candies){
            if(candy + extraCandies >= maxCandies) res.add(true);
            else res.add(false);
        }
        return res;
        
    }
}