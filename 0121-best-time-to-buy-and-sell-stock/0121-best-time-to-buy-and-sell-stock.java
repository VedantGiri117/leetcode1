class Solution {
    public int maxProfit(int[] prices) {
        //int curr_price = prices[0];
        //int min_price = prices[0];
        int min_price = Integer.MAX_VALUE;
        //int profit = 0;
        int max_profit = 0;
        //for(int i = 1 ; i < prices.length ; i++){
        for(int price : prices){
            if(price < min_price){
                min_price = price;
            }
            else{
                max_profit = Math.max(max_profit,price - min_price);
            }
            //curr_price  = prices[i];
            //profit = curr_price - min_price;
            //max_profit = Math.max(profit,max_profit);
        }
        return max_profit;
        
    }
}