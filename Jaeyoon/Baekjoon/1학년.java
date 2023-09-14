/*
    백준 5557번: 1학년
    알고리즘 분류: #DP
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    static Long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        // dp[n][k] -> n개의 수를 이용해 k를 만드는 경우의 수
        dp = new Long[N][21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N개의 수를 배열에 입력받음
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(find(N - 1, nums[N - 1]));
    }

    // 배열의 1 ~ n 번째 수를 사용하여 k를 만들 수 있는 경우의 수를 구해서 리턴
    public static Long find(int n, int k) {
        // 0 ~ 20 의 범위를 벗어날 경우 0을 리턴
        if(k < 0 || k > 20) {
            return 0L;
        }
        // n이 1이 될 경우(더 이상 등식을 줄일 수 없음)
        // k와 배열의 첫 번째 수를 비교 후 일치하면 1을 리턴
        else if(n == 1) {
            if(nums[0] == k) {
                return 1L;
            } else {
                return 0L;
            }
        }

        if(dp[n][k] == null) {
            // dp[n][k] -> n - 1 개의 수를 사용해 (k + n번째 수), (k - n번째 수)
            // 각각을 만들 수 있는 경우의 수를 더함(이전 기호가 '+', '-'일 때를 구분해서 각 경우의 수를 계산)
            dp[n][k] = find(n - 1 ,k + nums[n - 1]) + find(n - 1 ,k - nums[n - 1]);
        }

        return dp[n][k];
    }
}