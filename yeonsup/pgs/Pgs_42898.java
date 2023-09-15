package pog;

public class Pgs_42898 {

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        int num = 1000000007;

        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][0]][puddles[i][1]] = -1;
        }

        dp[1][1] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(dp[i][j] == -1) continue;
                if(dp[i -1][j] > 0) dp[i][j] += dp[i - 1][j] % num;
                if(dp[i][j - 1] > 0) dp[i][j] += dp[i][j - 1] % num;
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(new Pgs_42898().solution(4, 3, new int[][]{{2, 2}}));
    }
}
