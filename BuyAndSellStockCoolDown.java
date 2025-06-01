// Time Complexity :O(n);
// Space Complexity :O(1);
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int prevBuy = -prices[0];
        int prevSell = 0;
        int sell = 0;
        int prevPrevSell = 0;
        for (int i = 1; i < n; i++) {
            int buy = Math.max(prevBuy, prevPrevSell - prices[i]);
            sell = Math.max(prevSell, prevBuy + prices[i]);
            prevPrevSell = prevSell;
            prevSell = sell;
            prevBuy = buy;
        }

        return sell;
    }
}
