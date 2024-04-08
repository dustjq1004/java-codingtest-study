package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//
public class 점프 {
    static int[][] board;
    static long[][] dp;
    static int n;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        board = new int[n + 1][n + 1];
        dp = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        dp[1][1] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1;j <= n; j++) {
                int next = board[i][j];
                if(next==0) break;

                if(j + next <= n) dp[i][j + next] += dp[i][j];
                if(i + next <= n) dp[i + next][j] += dp[i][j];
            }
        }

        System.out.println(dp[n][n]);
    }
}
