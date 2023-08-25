/*
    백준 5547번: 일루미네이션
    알고리즘 분류: #그래프 탐색 #dfs #bfs
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 행과 열 번호를 저장할 Point 클래스
class Point {
    int row;
    int col;
    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {
    static int W;
    static int H;
    static int[][] map;
    static boolean[][] visited;
    // 육각형의 6방향에 대한 행과 열의 이동 범위를 저장
    static int[][] evenMovePoint = {{-1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, -1}, {0, -1}};  // 짝수
    static int[][] oddMovePoint = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {0, -1}};   // 홀수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        // 배열에 빈 공간으로 테두리를 형성
        map = new int[H + 2][W + 2];
        visited = new boolean[H + 2][W + 2];

        for(int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // (1, 0)부터 시작해서 외부에 해당되는 칸을 찾음 (bfs 함수 호출)
        Point start = new Point(1, 0);
        bfs(start);
        // 조명을 장식할 벽면의 수를 계산해서 이를 출력 (countLine 함수 호출)
        System.out.println(countLine());

    }
    // 배열을 순회하면서 외부에 해당되는 칸의 값을 2로 설정
    public static void bfs(Point p) {
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visited[p.row][p.col] = true;
        boolean isEven = false;

        while(!q.isEmpty()){
            Point temp = q.poll();
            // 큐에 들어있던 노드에 해당하는 위치의 값을 2로 변경
            map[temp.row][temp.col] = 2;
            // 육각형과 인접한 6면으로 이동
            for (int i = 0; i < 6; i++) {
                // 행 번호가 짝수일 경우와 홀수일 경우 이동값이 바뀌기 때문에 이를 판별함
                isEven = temp.row % 2 == 0;
                // 짝수일 경우와 홀수일 경우를 구분해 행과 열의 이동범위를 계산
                int dr = temp.row + (isEven ? evenMovePoint[i][0] : oddMovePoint[i][0]);
                int dc = temp.col + (isEven ? evenMovePoint[i][1] : oddMovePoint[i][1]);
                // row, column의 이동값이 배열의 범위를 벗어나지 않으면서
                if ((0 <= dr && dr < H + 2) && (0 <= dc && dc < W + 2)) {
                    // 방문하지 않은 노드이고, 값이 1이 아닐 때(건물 내부로는 들어가지 않음)
                    if(!visited[dr][dc] && map[dr][dc] != 1) {
                        // 해당 노드를 큐에 추가 후, 방문 체크
                        q.offer(new Point(dr, dc));
                        visited[dr][dc] = true;
                    }
                }
            }
        }
    }
    // 조명을 장식할 벽면의 수를 카운트해주는 함수
    public static int countLine() {
        boolean isEven = false;
        int cnt = 0;

        for(int i = 1; i <= H; i++) {
            for(int j = 1; j <= W; j++) {
                // 해당 칸에 건물이 있는 경우
                if(map[i][j] == 1) {
                    // 육각형과 인접한 6면을 살펴봄
                    for (int k = 0; k < 6; k++) {
                        isEven = i % 2 == 0;

                        int dr = i + (isEven ? evenMovePoint[k][0] : oddMovePoint[k][0]);
                        int dc = j + (isEven ? evenMovePoint[k][1] : oddMovePoint[k][1]);
                        // 외부 공기와 맞닿아 있는 경우, count를 증가
                        if(map[dr][dc] == 2) {
                            cnt++;
                        }
                    }
                }
            }
        }

        return cnt;
    }
}