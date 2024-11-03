package leetcode75.yandex.cupbackedn;

import java.io.*;

public class Second {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());  // Length of the password
        int m = Integer.parseInt(reader.readLine());  // Number of equations

        String[] xInput = reader.readLine().split(" ");
        int[] xArr = new int[m];
        for (int i = 0; i < m; i++) {
            xArr[i] = Integer.parseInt(xInput[i]);
        }

        String[] bInput = reader.readLine().split(" ");
        int[] bArr = new int[m];
        for (int i = 0; i < m; i++) {
            bArr[i] = Integer.parseInt(bInput[i]);
        }

        char[] password = new char[n];  // To hold the password
        boolean found = generateCombinations(password, 0, n, m, xArr, bArr);

        if (found) {
            System.out.println(new String(password));  // Print the found password
        } else {
            System.out.println("Пароль не найден");
        }
        reader.close();
    }

    private static boolean generateCombinations(char[] password, int position, int n, int m, int[] xArr, int[] bArr) {
        if (position == n) {
            return validate(password, m, xArr, bArr);  // Validate complete password
        }

        for (char c = 'a'; c <= 'w'; c++) {  // Iterate from 'a' to 'w'
            password[position] = c;
            if (generateCombinations(password, position + 1, n, m, xArr, bArr)) {
                return true;  // If valid combination is found
            }
        }
        return false;  // No valid combination found
    }

    private static boolean validate(char[] password, int m, int[] xArr, int[] bArr) {
        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < password.length; i++) {
                sum += (int) (Math.pow(xArr[j], i) * (password[i] - 'a'));  // Convert char to int
            }
            if (sum % 23 != bArr[j]) {
                return false;  // Invalid combination
            }
        }
        return true;  // Valid combination
    }
}
