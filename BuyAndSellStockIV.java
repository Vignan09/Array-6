// Time Complexity :O(n);
// Space Complexity :O(k);
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            buy[i] = Integer.MAX_VALUE;
        }

        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.min(buy[j], price - sell[j - 1]);
                sell[j] = Math.max(sell[j], price - buy[j]);
            }
        }

        return sell[k];
    }
}
