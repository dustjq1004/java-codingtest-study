/*
    프로그래머스 Lv3
    Title: 등굣길
 */

class Solution {
    static int[][] dp;
    static int row, col;

    public int solution(int m, int n, int[][] puddles) {
        row = n;
        col = m;
        dp = new int[row][col];

        // 물에 잠긴 지역을 -1로 초기화
        for (int[] arr : puddles) {
            dp[arr[1] - 1][arr[0] - 1] = -1;
        }

        return findPath(row - 1, col - 1);
    }
    // row와 column에 해당하는 위치의 최단경로의 개수를 리턴하는 함수
    public static int findPath(int r, int c) {
        // 맵을 벗어나거나 물에 잠긴 지역일 경우 0을 리턴
        if(r < 0 || c < 0 || dp[r][c] == -1) {
            return 0;
        }
        // 출발 지점일 경우 1을 리턴
        else if(r == 0 && c == 0) {
            return 1;
        }
        // 해당 위치의 최단경로가 계산되지 않았을 경우 최단경로를 구함
        else if(dp[r][c] == 0) {
            // 해당 칸의 최단경로의 개수 = 윗칸의 최단경로 개수 + 왼쪽칸의 최단경로 개수
            dp[r][c] = findPath(r - 1, c) + findPath(r, c - 1);
        }
        // 해당 칸의 최단경로의 개수를 1,000,000,007 로 나눈 나머지를 리턴
        return dp[r][c] % 1000000007;
    }
}