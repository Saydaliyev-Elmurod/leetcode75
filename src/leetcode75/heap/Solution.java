package leetcode75.heap;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        String merchantUserId = "50809";
        String clickKey = "rSltzXox6oV";
        Instant timestamp = Instant.now();
        String timestampString = String.valueOf(timestamp.getEpochSecond());
        System.out.println(timestampString);
        String dataToDigest = timestampString + clickKey;
        String digest = generateDigest(timestamp.getEpochSecond(), clickKey);
        String authHeader = merchantUserId + ":" + digest + ":" + timestampString;
        System.out.println(authHeader);
    }


    private static String generateDigest(long timestamp, String secretKey) {
        try {
            String input = timestamp + secretKey;
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = sha1.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-1 algorithm not found!", e);
        }
    }

}