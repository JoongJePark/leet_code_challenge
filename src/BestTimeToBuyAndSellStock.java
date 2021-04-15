import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int sol = 0;
        int length = prices.length;
        int max = prices[length - 1];
        int[] afterMax = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            if (max <= prices[i]) {
                afterMax[i] = prices[i];
                max=prices[i];
            } else {
                afterMax[i] = max;
            }
        }
        for (int i = 0; i < length; i++) {
            if (afterMax[i] - prices[i] > sol) {
                sol = afterMax[i] - prices[i];
            }
        }
        return sol;
    }
// 1 ms solution

//    public int maxProfit(int[] prices) {
//        int days = prices.length;
//        int profit = 0;
//        int min = prices[0];
//        for (int i = 0; i < days; ++i) {
//            int p = prices[i];
//            if (p < min) {
//                min = p;
//            } else {
//                int cur = p - min;
//                if (cur > profit) {
//                    profit = cur;
//                }
//            }
//        }
//        return profit;
//    }
}
