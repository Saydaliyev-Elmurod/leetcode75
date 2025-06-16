package leetcode75.daySolutions.july20;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Asteroid {
    public static void main(String[] args) {
        int[] a = new int[]{10, 2, -5};
        Arrays.toString(asteroidCollision(a));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        boolean isUpdate = false;
        for (int i = 0; i < asteroids.length - 1; i++) {
            if ((asteroids[i] < 0 && asteroids[i + 1] > 0) || (asteroids[i] > 0 && asteroids[i + 1] < 0)) {
                collision(i, i + 1, asteroids);
                isUpdate = true;
            }
        }

        int count = 0;
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] != 0) {
                count++;
            }
        }
        int[] a = new int[count];
        count = 0;
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] != 0) {
                a[count++] = asteroids[i];
            }
        }
        if (isUpdate) {
            return asteroidCollision(a);
        }
        return a;

    }

    private static void collision(int i, int i1, int[] asteroids) {
        if (Math.abs(asteroids[i]) > Math.abs(asteroids[i1])) {
            asteroids[i1] = 0;
        } else if (Math.abs(asteroids[i]) == Math.abs(asteroids[i1])) {
            asteroids[i] = 0;
            asteroids[i1] = 0;
        } else {
            asteroids[i] = 0;
        }
    }
}
