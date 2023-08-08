package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import static java.lang.Math.max;

public class Boj_18253 {

    public int solution(int n, int[] arr) {
        int result = 0;

        // Lis 알고리즘 선언
        int[] dp = new int[n];
        int i, j;

        for (i = 0; i < n; i++) {
            dp[i] = 1;
            for(j = 0; j < i; j++) {
                if(arr[i] < arr[j]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }

            result = max(result ,dp[i]);
        }

        return n - result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(new Boj_18253().solution(n, arr));
        br.close();
    }
}
