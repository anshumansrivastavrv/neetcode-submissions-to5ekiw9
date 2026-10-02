class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int res=0;
        int buy=prices[0];

        for(int i=1;i<n;i++){
            buy=Math.min(buy,prices[i]);
            res=Math.max(res,prices[i]-buy);
        }

        return res;
    }
}
