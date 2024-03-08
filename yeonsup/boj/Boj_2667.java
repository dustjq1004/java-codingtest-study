package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Boj_2667 {

    private static int[][] board;
    private static int[][] visited;
    private static int[][] direction = {
            {-1, 0, 1, 0},
            {0, 1, 0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new int[n][n];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                // 1. 단지 일때만 탐색
                if (board[y][x] == 1) {
                    int count = dfs(y, x, 1);
                    if (count > 0) {
                        list.add(count);
                    }
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        list.forEach(System.out::println);
    }

    private static int dfs(int y, int x, int count) {

        // 기저사례
        // 1. 방문했을 경우
        if (visited[y][x] == 1) {
            return count - 1;
        }

        visited[y][x] = 1;

        // 방향 탐색
        for (int i = 0; i < 4; i++) {
            int newY = direction[0][i] + y;
            int newX = direction[1][i] + x;

            // 기저사례
            // 2. board 범위를 벗어나는 경우, 1이 아닌 경우
            if (!isOut(newY, newX, board.length) && board[newY][newX] == 1) {
                count = Math.max(count, dfs(newY, newX, count + 1));
            }
        }

        return count;
    }
    private static boolean isOut(int y, int x, int n) {
        return y < 0 || y >= n || x < 0 || x >= n;
    }
}
