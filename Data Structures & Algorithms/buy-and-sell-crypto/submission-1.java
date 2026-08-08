class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice_cheaperDay = Integer.MAX_VALUE;
        for(int price  : prices){
            if(price < minPrice_cheaperDay){
                minPrice_cheaperDay = price;
            }
            else{
                maxProfit = Math.max(maxProfit, price - minPrice_cheaperDay);
            }
        }
        return maxProfit;
    }
}
