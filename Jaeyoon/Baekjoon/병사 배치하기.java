/*
    백준 18353번: 병사 배치하기
    알고리즘 분류: #dp #LIS
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        // dp[i] -> arr[i]를 마지막 값으로 가지는 가장 긴 부분 수열의 길이
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 병사들의 정보를 배열에 입력받고 배열을 순회
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            // i보다 작은 인덱스들을 탐색
            for(int j = 0; j < i; j++) {
                // arr[i]의 이전 값들 중 더 큰 값이 있다면 (병사를 해당 인덱스 뒤에 배치할 수 있다면)
                if(arr[i] < arr[j]){
                    // (1) j번째 인덱스로 끝나는 부분 수열의 마지막에 arr[i]를 추가했을 때의 LIS 길이(dp[j] + 1)
                    // (2) 추가하지 않고 기존의 dp[i] 값 중 더 큰 값으로 업데이트
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // dp 배열을 정렬
        Arrays.sort(dp);
        // 총 병사의 수에서 LIS의 길이만큼 빼면 열외된 병사의 수가 됨
        System.out.println(n - dp[dp.length - 1]);
    }
}