package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_14501 {
    private static int[] ti;
    private static int[] pi;
    private static int[] cache;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ti = new int[n];
        pi = new int[n];
        cache = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            ti[i] = Integer.parseInt(input[0]);
            pi[i] = Integer.parseInt(input[1]);
        }

        int result = solve(0, 0);

        System.out.println(result);
    }

    // 0, 0 시작
    private static int solve(int cost, int day) {
        if (day >= n) return cost;

        if (day + ti[day] > n) return solve(cost, day + 1);

        return Math.max(solve(cost + pi[day], day + ti[day]), solve(cost, day + 1));
    }
}
