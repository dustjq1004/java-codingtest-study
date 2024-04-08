package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로찾기 {
    static int[][] board;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(token.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited = new int[n];
                sb.append(dfs(i, j, n, 0));
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    // i -> j 로 갈 수 있는지 판단
    // 1. i, j 를 탐색할 때 j에 도달하는지 확인하면 됨
    // 2. dfs로 구현
    private static int dfs(int i, int j, int n, int cnt) {

        if (i == j && cnt != 0) return 1;

        for (int x = 0; x < n; x++) {
            if (board[i][x] == 1 && visited[x] == 0) {
                visited[x] = 1;
                int result = dfs(x, j, n, cnt + 1);
                if (result == 1) {
                    return result;
                }
            }
        }
        return 0;
    }
}
