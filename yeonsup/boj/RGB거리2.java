package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(token.nextToken());
        int[][] dp = new int[n + 1][3];
        int[][] rgb = new int[n + 1][3];


        for (int i = 1; i <= n; i++) {
            token = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(token.nextToken());
            int g = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            rgb[i][0] = r;
            rgb[i][1] = g;
            rgb[i][2] = b;
        }

        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < 3; k++) {

            for (int i = 0; i <= 2; i++) {
                if (k == i) {
                    dp[1][i] = rgb[1][i];
                } else {
                    dp[1][i] = 1000 + 1;
                }
            }

            for (int i = 2; i <= n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
            }

            for (int i = 0; i <= 2; i++) {
                if (k != i) {
                    ans = Math.min(ans, dp[n][i]);
                }
            }
        }

        System.out.println(ans);
    }
}
