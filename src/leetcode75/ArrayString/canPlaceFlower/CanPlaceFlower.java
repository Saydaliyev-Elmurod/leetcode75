package leetcode75.ArrayString.canPlaceFlower;

public class CanPlaceFlower {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 0, 0};
        System.out.println(canPlaceFlowers(arr, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(n==0)return true;
        if (len == 1 && flowerbed[0] == 0) return n == 1;
        if (len <= n) return false;
        if (len > 1 && flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }
        if (len > 1 && flowerbed[len - 2] == 0 && flowerbed[len - 1] == 0) {
            flowerbed[len - 1] = 1;
            n--;
        }
        for (int i = 1; i < len - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
                if(n==0){
                    return true;
                }
            }
        }
        return n <= 0;
    }
}
