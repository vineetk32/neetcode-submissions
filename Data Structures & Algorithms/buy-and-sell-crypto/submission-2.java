class Solution {
    public int maxProfit(int[] prices) {
        int windowStart = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - prices[windowStart];
            while (currProfit < 0 && windowStart < i) {
                windowStart++;
                currProfit = prices[i] - prices[windowStart];
            }
            maxProfit = Math.max(currProfit, maxProfit);
        }
        return maxProfit;
    }
}
