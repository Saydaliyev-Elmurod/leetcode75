class Solution {

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        if (n == 1)
            return prices;
        int min = findMin(prices, 0);
        for (int i = 0; i < n; i++) {
            // if (min > i && prices[min] < prices[i]) {
            //     prices[i] = prices[i] - prices[min];
            // } else {
                min = findMin(prices, i);
                if (min != -1)
                    prices[i] = prices[i] - prices[min];
                // else
                //     break;

            // }
        }
        return prices;
    }

    public int findMin(int[] prices, int min) {
        int n = prices.length;

        for (int j = min + 1; j < n; j++) {
            if (prices[j] <= prices[min]) {
                return j;
            }
        }
        return -1;
    }
}