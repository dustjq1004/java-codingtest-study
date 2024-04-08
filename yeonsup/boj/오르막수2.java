package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오르막수2 {
    private static final long MOD = 10_007;
    private static final int NINE = 9;

    static long[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10];

        for (int j = 0; j <= NINE; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= NINE; j++) {
                long sum = 0;
                for (int k = j; k <= NINE; k++) {
                    sum += dp[i - 1][k];
                }
                dp[i][j] += sum % MOD;
            }
        }

        long sum = 0;
        for (int i = 0; i <= NINE; i++) {
            sum += dp[n][i] % MOD;
        }

        System.out.println((sum % MOD));
    }
}
