package main;

public class BuySellStock {
    public static void main (String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices)); //6
    }

    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1 ; i < prices.length ; i++) {
            int sellPrice = prices[i];
            if (buyPrice > sellPrice) {
                buyPrice = sellPrice;
            } else {
                if (sellPrice - buyPrice > maxProfit) {
                    maxProfit = sellPrice - buyPrice;
                }
            }
        }
        return maxProfit;
    }
}
