package leetcode75.stack;

class DailyTemperatureSolution {
    public int[] dailyTemperatures(int[] temperatures) {
        /** birinchi oddiy for bilan topib ko'ramiz */
        /** bu yechim to'gri lekin time limit error endi optimallashtirish kerak*/
        int[] arr = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int count = 0;
            for (int j = i; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    arr[i] = count;
                    break;
                }
                count++;
            }
        }
        return arr;
    }
}