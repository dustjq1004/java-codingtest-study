package boj;

import java.io.IOException;
import java.util.Scanner;

public class 계단오르기 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] stairs = new int[m + 1];
        int[] dp = new int[m + 1];

        for (int i = 1; i <= m; i++) {
            stairs[i] = sc.nextInt();
        }

        dp[1] = stairs[1];

        if (m >= 2)
            dp[2] = stairs[1] + stairs[2];

        for (int i = 3; i <= m; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }
        System.out.println(dp[m]);
    }
}
