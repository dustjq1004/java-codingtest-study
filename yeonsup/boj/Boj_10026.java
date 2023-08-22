package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10026 {

    static boolean[][] visited;
    static char[][] rgb;
    static int[] a = new int[] {-1, 0, 0, 1};
    static int[] b = new int[] {0, -1, 1, 0};
    static int n;

    static char getChar(char a, int isRG) {
        if(isRG == 1) {
            a = a == 'G' ? 'R' : a;
        }
        return a;
    }
    static void dfs(int x, int y, int isRG) {
        visited[x][y] = true;
        char cur = getChar(rgb[x][y], isRG);

        for (int i = 0; i < a.length; i++) {
            int searchX = x + a[i];
            int searchY = y + b[i];

            if(searchX <= -1 || searchX >= n || searchY <= -1 || searchY >= n) continue;

            if(!visited[searchX][searchY] && getChar(rgb[searchX][searchY], isRG) == cur) {
                dfs(searchX, searchY, isRG);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[2];

        n = Integer.parseInt(bf.readLine());
        rgb = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            rgb[i] = bf.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, 0);
                    result[0]++;
                }
            }
        }

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, 1);
                    result[1]++;
                }
            }
        }
        System.out.println(result[0] + " " + result[1]);
        bf.close();
    }
}

/*
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
 */