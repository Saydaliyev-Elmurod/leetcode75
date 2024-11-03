package leetcode75.yandex.cupbackedn;

public class BinaryCombinations {
    static int[] arr; // Array to hold the binary combination

    // Function to generate all combinations of 0 and 1
    public static void generateBinaryCombinations(int pos, int n) {
        if (pos == n) {
            printArray();
            return;
        }

        // Try 0 for this position
        arr[pos] = 0;
        generateBinaryCombinations(pos + 1, n);

        // Try 1 for this position
        arr[pos] = 1;
        generateBinaryCombinations(pos + 1, n);
    }

    // Function to print the generated array
    public static void printArray() {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4; // Length of the combinations
        arr = new int[n]; // Initialize the array with the given length
        generateBinaryCombinations(0, n); // Start generating combinations
    }
}
