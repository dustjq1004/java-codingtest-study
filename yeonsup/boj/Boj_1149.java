package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_1149 {



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] dp = new int[n][3];
        int[] init = Arrays.stream(bf.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();
        dp[0][0] = init[0];
        dp[0][1] = init[1];
        dp[0][2] = init[2];

        for (int i = 1; i < n; i++) {
            int[] rgb = Arrays.stream(bf.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();
            dp[i][0] = rgb[0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = rgb[1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = rgb[2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Arrays.stream(dp[n-1]).min().getAsInt());
    }

    /*
    3
26 40 83
49 60 57
13 89 99

3
1 100 100
100 1 100
100 100 1
    * */
}
