package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n + 1][2];
            dp[0][0] = 1;
            dp[0][1] = 0;

            if (n >= 1) {
                dp[1][0] = 0;
                dp[1][1] = 1;
            }

            for (int i = 2; i <= n; i++) {
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
            }
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}
