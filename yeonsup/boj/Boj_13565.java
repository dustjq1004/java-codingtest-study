package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13565 {

    static char[][] board;
    static boolean[][] visited;
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        m = Integer.parseInt(token.nextToken());
        n = Integer.parseInt(token.nextToken());

        board = new char[m][n];

        for (int i = 0; i < m; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                board[i][j] = input[j];
            }
        }

        visited = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            if (board[0][i] == '0') {
                visited[0][i] = true;
                dfs(0,i);
            }
        }
        System.out.println("NO");
    }

    public static void dfs(int y, int x) {
        if (y == m - 1) {
            System.out.println("YES");
            System.exit(0);
        }

        for (int i = 0; i < delta.length; i++) {
            int newY = delta[i][0] + y;
            int newX = delta[i][1] + x;
            if (newY >= 0 && newY < m && newX >= 0 && newX < n && !visited[newY][newX]
                    && board[newY][newX] == '0') {
                visited[newY][newX] = true;

                dfs(newY, newX);
            }
        }
    }
}
