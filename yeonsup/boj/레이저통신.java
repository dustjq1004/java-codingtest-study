package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 레이저통신 {
    static int n, m;
    static int[][] board;
    static int[][] dist;
    static int[][] dir = {
            {0, 1, 2}, {1, 0, 1}, {-1, 0, 1}, {0, -1, 2}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        board = new int[m][n];
        dist = new int[m][n];

        int start = 0;

        List<Node> raiser = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            char[] split = bf.readLine().toCharArray();
            Arrays.fill(dist[i], 100000);
            for (int j = 0; j < n; j++) {
                char s = split[j];
                int boardValue = -1;

                if ('.' == s) {
                    boardValue = 0;
                } else if ('*' == s) {
                    boardValue = 1;
                } else {
                    boardValue = 2;
                    raiser.add(new Node(i, j , 0, 0));
                }

                board[i][j] = boardValue;
            }
        }

        dijkstra(raiser.get(1), raiser.get(0));
        System.out.println(dist[raiser.get(0).y][raiser.get(0).x]);
    }

    static void dijkstra(Node start, Node end) {
        Queue<Node> queue = new PriorityQueue<>();
//        queue.add(start);
        int[][][] visited = new int[m][n][4];
        dist[start.y][start.x] = 0;
        queue.add(new Node(start.y, start.x, 0, -1));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.y == end.y && cur.x == end.x) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newY = cur.y + dir[i][0];
                int newX = cur.x + dir[i][1];
                int newT = dir[i][2];

                if (!isInArea(newY, newX)) continue;
                if (visited[newY][newX][i] == 3) continue;
                if (board[newY][newX] == 1) continue;

                int cnt = cur.c;


                if (newT != cur.t) cnt += 1;
                if (cur.t == -1) cnt = 0;

                if (dist[newY][newX] >= cnt) {
                    dist[newY][newX] = cnt;
                    visited[newY][newX][i]++;
                    queue.offer(new Node(newY, newX, cnt, newT));
                }
            }
        }

    }

    private static boolean isInArea(int nextY, int nextX) {
        return nextY >= 0 && nextY < m && nextX >= 0 && nextX < n;
    }

    static class Node implements Comparable<Node>{
        int y, x, c;
        int t;

        public Node(int y, int x, int c, int t) {
            this.y = y;
            this.x = x;
            this.c = c;
            this.t = t;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }
}
