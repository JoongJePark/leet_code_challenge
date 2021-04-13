import java.util.Arrays;

public class CoinChangeSolution {
    int val = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, amount, coins.length - 1, 0);
        return (val == Integer.MAX_VALUE) ? -1 : val;
    }

    public void dfs(int[] coins, int amount, int idx, int count) {
        if (amount == 0) {
            val = Math.min(val, count);
            return;
        }
        if (idx < 0) {
            return;
        }
        for (int j = amount / coins[idx]; j >= 0 && j + count < val; j--) {
            dfs(coins, amount - (j * coins[idx]), idx - 1, count + j);
        }
    }
}
