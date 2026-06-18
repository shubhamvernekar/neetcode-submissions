class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return calulateProfite(prices, 0, 0);
    }

    public int calulateProfite(int[] prices, int i, int buy) {
        if(i > prices.length-1) return 0;
        int profit = 0;

        if(dp[i][buy] != null) return dp[i][buy];

        if(buy == 0) {
            int buying = -prices[i] + calulateProfite(prices, i+1, 1);
            int cooldown = calulateProfite(prices, i+1, 0);
            profit = Math.max(buying, cooldown);
        } else {
            int selling = prices[i] + calulateProfite(prices, i+2, 0);
            int cooldown = calulateProfite(prices, i+1, 1);
            profit = Math.max(selling, cooldown);
        }
        return dp[i][buy] = profit;
    }
}
