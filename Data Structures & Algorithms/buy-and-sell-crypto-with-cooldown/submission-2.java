class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        return calulateProfite(prices, 0, 0);
    }

    public int calulateProfite(int[] prices, int i, int buy) {
        if(i > prices.length-1) return 0;
        int profit = 0;

        if(dp[i][buy] != 0) return dp[i][buy];
        
        if(buy == 0) {
            profit = Math.max(-prices[i] + calulateProfite(prices, i+1, 1), calulateProfite(prices, i+1, 0));
        } else {
            profit = Math.max(prices[i] + calulateProfite(prices, i+2, 0), calulateProfite(prices, i+1, 1));
        }
        dp[i][buy] = profit;
        return profit;
    }
}
