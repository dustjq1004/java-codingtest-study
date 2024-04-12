package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int n = Integer.parseInt(bf.readLine());
        dp = new int[n + 1];
        result = recursive(n, 0);

        if (result >= 50001) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }

    private static int recursive(int n, int cnt) {
        if (n < 0) {
            return 50001;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        if (n == 0) {
            return cnt;
        }

        return dp[n] = Math.min(recursive(n - 5, cnt + 1), recursive(n - 3, cnt + 1));
    }
}
