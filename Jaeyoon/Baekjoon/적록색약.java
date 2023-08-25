/*
    백준 10026번: 적록색약
    알고리즘 분류: #그래프 탐색 #dfs #bfs
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static char color;
    static int cnt = 0;
    static char[][] arr;
    static char[][] arrRG;
    static boolean[][] visited;
    // 상하좌우 이동 시 행과 열의 이동 범위를 저장
    static int[][] movePoint = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        arrRG = new char[n][n];
        visited = new boolean[n][n];
        // RGB 값을 배열에 입력받음. arrRG 배열의 경우 R -> G 로 변환해서 R, B 두 가지 값으로 저장
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
                arrRG[i][j] = arr[i][j];
                if(arrRG[i][j] == 'R') {
                    arrRG[i][j] = 'G';
                }
            }
        }
        // arr 배열로 dfs 호출
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    // color를 현재 배열에 저장된 RGB값으로 설정
                    color = arr[i][j];
                    dfs(i, j, arr);
                    cnt++;
                }
            }
        }
        // 구역의 수(count) 출력 후 초기화
        System.out.print(cnt + " ");
        cnt = 0;
        // visited 배열 초기화
        visited = new boolean[n][n];
        // arrRG 배열로 dfs 호출(적록색약인 경우)
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    color = arrRG[i][j];
                    dfs(i, j, arrRG);
                    cnt++;
                }
            }
        }
        // 적록색약일 때 구역의 수 출력
        System.out.print(cnt + " ");
    }

    public static void dfs(int row, int col, char[][] arr) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int dr = row + movePoint[i][0];
            int dc = col + movePoint[i][1];
            // row, column의 이동값이 배열의 범위를 벗어나지 않으면서
            if ((0 <= dr && dr < n) && (0 <= dc && dc < n)) {
                // 방문하지 않는 노드이고, color의 RGB값과 일치하는 경우 재귀호출
                if (!visited[dr][dc] && arr[dr][dc] == color) {
                    dfs(dr, dc, arr);
                }
            }
        }
    }
}