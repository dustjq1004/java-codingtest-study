package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 문자열판별 {
    static int[] dp;
    static String[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = Integer.parseInt(bf.readLine());
        dp = new int[s.length()];
        a = new String[n];

        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            a[i] = bf.readLine();
        }

        System.out.println(isMakeStringS(s, 0));
    }

    static int isMakeStringS(String s, int pos) {
        if (s.length() == pos) return 1;

        if (dp[pos] != -1) {
            return dp[pos];
        }

        dp[pos] = 0;
        for (int i = 0; i < a.length; i++) {
            final String word = a[i];
            if (s.length() - pos < word.length()) continue;

            String substring = s.substring(pos, pos + word.length());
            if (substring.equals(word)) {
                dp[pos] = Math.max(isMakeStringS(s, pos + word.length()), dp[pos]);
            }
        }
        return dp[pos];
    }
}
