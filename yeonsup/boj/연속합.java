package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속합 {
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        for (int i = 2; i < dp.length; i++) {
            int result = Integer.MAX_VALUE;

            if (i <= 3) {
                dp[i] = 1;
                continue;
            }

            if (i % 3 == 0) {
                result = Math.min(result, dp[i / 3] + 1);
            }

            if (i % 2 == 0) {
                result = Math.min(result, dp[i / 2] + 1);
            }

            result = Math.min(result, dp[i - 1] + 1);
            dp[i] = result;
        }

        System.out.println(dp[n]);
    }
}
