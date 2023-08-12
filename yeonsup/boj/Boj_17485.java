package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.*;

public class Boj_17485 {



    public int solution (int n, int m, int[][] arr) {
        int[][] dp1 = new int[n][m];
        int[][] dp2 = new int[n][m];
        int[][] dp3 = new int[n][m];

        for (int i = 0; i < m; i++) {
            dp1[0][i] = arr[0][i];
            dp2[0][i] = arr[0][i];
            dp3[0][i] = arr[0][i];
        }

        for (int i = 0; i < n; i++) {
            dp1[i][0] = Integer.MAX_VALUE;
            dp3[i][m-1] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp2[i][j] = arr[i][j] + min(dp1[i - 1][j], dp3[i - 1][j]);
                    dp3[i][j] = arr[i][j] + min(dp1[i - 1][j + 1], dp2[i - 1][j + 1]);
                } else if (j == m - 1) {
                    dp1[i][j] = arr[i][j] + min(dp2[i - 1][j - 1], dp3[i - 1][j - 1]);
                    dp2[i][j] = arr[i][j] + min(dp1[i - 1][j], dp3[i - 1][j]);
                } else {
                    dp1[i][j] = arr[i][j] + min(dp2[i - 1][j - 1], dp3[i - 1][j - 1]);
                    dp2[i][j] = arr[i][j] + min(dp1[i - 1][j], dp3[i - 1][j]);
                    dp3[i][j] = arr[i][j] + min(dp1[i - 1][j + 1], dp2[i - 1][j + 1]);

                }

            }
        }

        System.out.println(Arrays.toString(dp1[n-1]));
        System.out.println(Arrays.toString(dp2[n-1]));
        System.out.println(Arrays.toString(dp3[n-1]));

        return min(Arrays.stream(dp1[n-1]).min().getAsInt(),
                min(Arrays.stream(dp2[n-1]).min().getAsInt(), Arrays.stream(dp3[n-1]).min().getAsInt()));
    }

    public static void main (String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] arr = new int[nm[0]][nm[1]];

        for (int i = 0; i < nm[0]; i++) {
            arr[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Boj_17485 boj17485 = new Boj_17485();
        System.out.println(boj17485.solution(nm[0], nm[1], arr));
    }
}
