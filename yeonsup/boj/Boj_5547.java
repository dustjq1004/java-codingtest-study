package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_5547 {
    
    static Queue<Hex> queue = new LinkedList<>();
    static int[][] illumination;
    static int[][] visited;
    static int[][] result;
    static int[][] odd = new int[][] { {0, -1}, { -1,  0}, {0, 1}, {1, 1}, {1,  0}, {-1, 1}};
    static int[][] even = new int[][] { {0, -1}, { -1, -1}, {0, 1}, {1, 0}, {1, -1}, {-1, 0}};

    static void bfs(int w, int h) {
        int cnt = 0;
        int[][] search;
        while (!queue.isEmpty()) {
            Hex hex = queue.poll();
            cnt = 0;
            search = hex.y % 2 == 1 ? odd : even;
            for (int i = 0; i < search.length; i++) {
                int newX = hex.x + search[i][1];
                int newY = hex.y + search[i][0];

                if(newY < 0 || newY >= h || newX < 0 || newX >= w) continue;

                cnt += illumination[newY][newX] == 1 ? 1 : 0;

                if(visited[newY][newX] == 0 && illumination[newY][newX] == 0) {
                    visited[newY][newX] = 1;
                    queue.offer(new Hex(newX, newY));
                }

            }
            result[hex.y][hex.x] = cnt;
//            System.out.println("result = " + result + " hex : " + hex.x + ", " + hex.y);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] line1 = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int w = line1[0] + 2;
        int h = line1[1] + 2;
        int sum = 0;
        illumination = new int[h][w];
        visited = new int[h][w];
        result = new int[h][w];

        for (int i = 1; i <= h - 2; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= w - 2; j++) {
                illumination[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.offer(new Hex(0, 0));
        bfs(w, h);

        for (int[] ints : result) {
            sum += Arrays.stream(ints).sum();
        }

        System.out.println(sum);
        bf.close();
    }
}

class Hex {

    int x;
    int y;

    public Hex(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
/*
8 4
0 1 0 1 0 1 1 1
0 1 1 0 0 1 0 0
1 0 1 0 1 1 1 1
0 1 1 0 1 0 1 0


 */