/*
    백준 17485번: 진우의 달 여행 (Large)
    알고리즘 분류: #dp
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        // 3가지 방향에 대한 최소값을 저장할 배열
        int[][][] dp = new int[N][M][3];
        // 각 칸의 연료를 2차원 배열에 입력받음
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // dp 배열의 첫 행 초기화
        for(int i = 0; i < M; i++){
            for(int j = 0; j < 3; j++) {
                dp[0][i][j] = arr[0][i];
            }
        }
        // 반복문으로 각 위치에 올 수 있는 최소 연료를 계산
        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int k = 0; k < 3; k++) {
                    // 우주선이 왼쪽에서 접근한 경우
                    if(k == 0){
                        // 1열에서는 우주선이 왼쪽에서 올 수 없으므로 max값으로 초기화
                        if(j == 0){
                            dp[i][j][k] = Integer.MAX_VALUE;
                        }
                        else {
                            // 왼쪽을 제외한 2방향 중 최소값을 저장 (
                            dp[i][j][k] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
                        }
                    }
                    // 우주선이 가운데 방향에서 접근한 경우
                    else if(k == 1){
                        // 왼쪽과 오른쪽 중 최소값을 저장
                        dp[i][j][k] = Math.min(dp[i-1][j][0], dp[i-1][j][2])+ arr[i][j];
                    }
                    // 우주선이 오른쪽에서 접근한 경우
                    else if(k == 2){
                        // 맨 오른쪽 열인 경우 우주선이 오른쪽에서 올 수 없으므로 max값으로 초기화
                        if(j == M-1){
                            dp[i][j][k] = Integer.MAX_VALUE;
                        }
                        else{
                            // 오른쪽을 제외한 2방향 중 최소값을 저장
                            dp[i][j][k] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1])+ arr[i][j];
                        }
                    }
                }
            }
        }
        // 최소 연료값을 찾아서 result 변수에 저장
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                result = Math.min(result, dp[N - 1][i][j]);
            }
        }
        System.out.println(result);
    }
}