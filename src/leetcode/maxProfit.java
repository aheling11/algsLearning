package leetcode;

/**
 * 121. Best Time to Buy and Sell Stock
 */
class maxProfit {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int n = prices.length;
        int max = 0;
        int maxProfit = 0;
        for(int i = n - 1; i > 0; i--) {
            if(prices[i] > max) {
                max = prices[i];
            }
            if(max - prices[i - 1] > maxProfit) {
                maxProfit = max - prices[i - 1];
            }
        }
        return maxProfit;
    }
}