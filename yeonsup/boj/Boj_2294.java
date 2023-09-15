package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2294 {



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] first = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = first[0];
        int k = first[1];
        int[] coins = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        System.out.println(dp[k] == 100001 ? -1 : dp[k]);
    }
}


/*
3 15
1
5
12
* */