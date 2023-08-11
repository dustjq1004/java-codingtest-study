/*
    백준 2156번: 포도주 시식
    알고리즘 분류: #dp
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new Integer[n];
        // n개의 포도주를 배열에 입력받음
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 배열의 마지막 인덱스(n-1)로 dp 함수 호출 후 반환값 출력
        System.out.println(dp(n-1));
    }
    // 배열의 해당 인덱스가 가질 수 있는 최대값(포도주의 최대양)을 계산 후 리턴
    public static int dp(int n){
        if(n <= 0){
            // 인덱스가 0일경우(n == 0) 배열의 첫번째 요소를 리턴. 0보다 작은 경우 0을 리턴
            return n == 0 ? arr[0] : 0;
        }
        // dp 배열의 값이 존재하지 않으면 해당 인덱스의 최대값을 계산
        else if(dp[n] == null){
            // 해당 인덱스의 값을 포함한 2가지 경우의 수와 해당 인덱스를 제외한 1가지 총 3개의 경우의 수
            // 각각의 값을 비교 후 가장 큰 값(max)을 dp[n]에 저장
            dp[n] = Math.max(arr[n - 1] + dp(n - 3) + arr[n], Math.max(dp(n - 2) + arr[n], dp(n - 1)));
        }
        return dp[n];
    }
}