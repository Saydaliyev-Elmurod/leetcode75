package leetcode75.yandexContest.revocup;

import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String access = "ACCESS IS OPEN";
        String denied = "ACCESS DENIED";
        String again = "TRY AGAIN";
        String pin = reader.readLine();
        final String string = reader.readLine();
        if (string != null) {
            int attempt = Integer.parseInt(string);
            int count = 0;
            String res = again;
            while (attempt-- > 0) {
                String str = reader.readLine();
                count++;
                if (pin.equals(str)) {
                    res = access;
                    count = 0;
                } else if (count >= 3) {
                    res = denied;
                    break;
                }
            }
            System.out.println(res);
            reader.close();
        }

    }
}
