class Solution {
    public String addBinary(String a, String b) {
        //
        int n = a.length();
        int m = b.length();

        int max = Math.max(m, n);
        if (max > n) {
            for (int i = 0; i < max - n; i++) {
                a = '0' + a;
            }
        } else {
            for (int i = 0; i < max - m; i++) {
                b = '0' + b;
            }
        }
        int ext = 0;
        char f = '0';
        char s = '0';
        String str = "";
        System.out.println(a);
        System.out.println(b);
        for (int i = max - 1; i >= 0; i--) {
            f = a.charAt(i);
            s = b.charAt(i);
            if (f == '0' && s == '0') {
                str += ext;
                ext = 0;
            } else if (f == '0' || s == '0') {
                if (ext == 0) {
                    str += '1';
                } else {
                    str += '0';
                    ext = 1;
                }
            } else {
                // 1 1
                if (ext == 0) {
                    str += '0';
                    ext = 1;
                } else {
                    str += '1';
                }
            }

        }
        if (ext == 1) {
            str += '1';
        }
        return new StringBuilder(str).reverse().toString();
    }
}