/*
    프로그래머스 Lv2
    Title: 땅따먹기
 */

class Solution {
    static int max;
    static int maxIdx;
    static int second;
    static int[][] dp;

    int solution(int[][] land) {
        dp = new int[land.length][4];
        // dp 배열 첫 행 초기화
        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }
        // 첫 행의 max값과 second값을 탐색
        secondLargest(0);
        // 2차원 배열을 순회하면서 각 칸이 가질 수 있는 최대값을 계산
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < 4; j++){
                // 현재 열이 이전 행의 maxIndex와 동일하면 같은 열에 속하므로
                // second값을 더해주고 그렇지 않다면 max값을 더해줌
                dp[i][j] = maxIdx == j ? land[i][j] + second : land[i][j] + max;
            }
            // 현재 행의 max와 second를 탐색
            secondLargest(i);
        }
        // 2차원 배열 순회가 종료되면 마지막 행의 최대값이 계산되어 있으므로 이를 return
        return max;
    }

    // 배열의 max값과 second값을 찾아주는 함수
    public static void secondLargest(int row) {
        max = -1;
        second = -1;
        for (int i = 0; i < 4; i++) {
            if (dp[row][i] > max) {
                second = max;
                max = dp[row][i];
                // 같은 행인지를 확인하기 위해 max값의 index를 저장
                maxIdx = i;
            } else if (dp[row][i] > second) {
                second = dp[row][i];
            }
        }
    }
}