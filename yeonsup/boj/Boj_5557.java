package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Boj_5557 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] array = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[][] dp = new long[n][21];
        // 1. 처음 시작을 8을 넣고 시작한다.(V)
        dp[0][array[0]] = 1;
        for (int i = 1; i < array.length; i++) {
            int num1 = array[i];
            long[] sang = dp[i - 1];
            for (int j = 0; j < sang.length; j++) {
                if(sang[j] > 0) {
                    int plus = j + num1;
                    int minus = j - num1;
                    if(plus <= 20) dp[i][plus] += sang[j];
                    if(minus >= 0) dp[i][minus] += sang[j];
                }
            }
        }

        System.out.println(dp[n - 2][array[n - 1]]);
    }
}

/*

11
8 3 2 4 8 7 2 4 0 8 8

40
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 1 1
 */