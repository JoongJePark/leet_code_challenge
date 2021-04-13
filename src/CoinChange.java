import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        for (int coin : coins) {
            if (coin <= amount) {
                memo[coin] = 1;
            }
        }
        for (int i = 1; i < amount + 1; i++) {
            for (int coin: coins) {
                if (i - coin >= 0) {
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
                }
            }
        }
        if (memo[amount] >= amount + 1) {
            return -1;
        }
        return memo[amount];
    }

    public static void main(String[] args) {

    }
}
