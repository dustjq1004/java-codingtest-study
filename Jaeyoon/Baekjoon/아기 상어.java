/*
    백준 16236번: 아기 상어
    알고리즘 분류: #자료구조 #스택
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point {
    int row;
    int col;
    int cnt;

    public Point(int row, int col, int cnt) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}

public class Main {
    static int N;
    static int sharkSize = 2;
    static int sharkEat;
    static int moveDistance;
    static int[][] map;
    static boolean[][] visited;
    // 상하좌우 이동 시 행과 열의 이동 범위를 저장
    static int[][] movePoint = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        Point start = null;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    start = new Point(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        bfs(start);
        System.out.println(moveDistance);
    }

    public static void bfs(Point start) {
        // 거리가 가장 가까운 물고기를 찾기 위한 우선순위 큐
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) ->
                p1.cnt != p2.cnt ? Integer.compare(p1.cnt, p2.cnt) :
                        p1.row != p2.row ? Integer.compare(p1.row, p2.row) :
                                Integer.compare(p1.col, p2.col)
        );
        pq.offer(start);
        visited[start.row][start.col] = true;

        while (!pq.isEmpty()) {
            Point temp = pq.poll();

            // 물고기를 먹을 수 있는 경우
            if (map[temp.row][temp.col] != 0 && map[temp.row][temp.col] < sharkSize) {
                // 이동 거리 갱신
                moveDistance += temp.cnt;
                // 먹은 물고기 수를 증가
                sharkEat++;
                // 물고기를 먹은 위치의 값을 0으로 초기화
                map[temp.row][temp.col] = 0;
                // 상어의 크기만큼 물고기를 먹었다면 사이즈 업그레이드
                if (sharkEat == sharkSize) {
                    sharkSize++;
                    sharkEat = 0;
                }
                // 해당 위치에서 다시 탐색을 시작하기 위해 초기화
                visited = new boolean[N][N];
                pq.clear();
                pq.offer(new Point(temp.row, temp.col, 0));
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int row = temp.row + movePoint[i][0];
                int col = temp.col + movePoint[i][1];

                // 맵을 벗어나지 않고
                if (0 <= row && row < N && 0 <= col && col < N) {
                    // 상어의 크기보다 작거나 같으면서, 방문하지 않은 곳이라면 큐에 추가
                    if (!visited[row][col] && map[row][col] <= sharkSize) {
                        pq.offer(new Point(row, col, temp.cnt + 1));
                        visited[row][col] = true;
                    }
                }
            }
        }
    }
}