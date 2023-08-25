/*
    백준 12761번: 돌다리
    알고리즘 분류: #그래프 탐색 #bfs
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// x 좌표와 이동 횟수(cnt)를 저장할 Point 클래스
class Point {
    int x;
    int cnt;
    public Point(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }
}

public class Main {
    static final int maxX = 100000;
    static int A;
    static int B;
    static int N;
    static int M;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[maxX + 1];

        bfs();
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(N, 0));
        while(!q.isEmpty()){
            Point temp = q.poll();
            if(temp.x == M){
                System.out.println(temp.cnt);
                return;
            }
            // 8가지 이동 방법에 대한 x의 좌표값을 큐에 추가
            addQueue(q, temp);
        }
    }
    // 각 이동 범위가 0과 100,000 사이이고, 방문하지 않은 노드라면 큐에 추가해주는 함수
    public static void addQueue(Queue<Point> q, Point temp) {
        if (temp.x * A <= maxX && !visited[temp.x * A]) {
            q.add(new Point(temp.x * A, temp.cnt + 1));
            visited[temp.x * A] = true;
        }
        if (temp.x * B <= maxX && !visited[temp.x * B]) {
            q.add(new Point(temp.x * B, temp.cnt + 1));
            visited[temp.x * B] = true;
        }
        if (temp.x + A <= maxX && !visited[temp.x + A]) {
            q.add(new Point(temp.x + A, temp.cnt + 1));
            visited[temp.x + A] = true;
        }
        if (temp.x - A >= 0 && !visited[temp.x - A]) {
            q.add(new Point(temp.x - A, temp.cnt + 1));
            visited[temp.x - A] = true;
        }
        if (temp.x + B <= maxX && !visited[temp.x + B]) {
            q.add(new Point(temp.x + B, temp.cnt + 1));
            visited[temp.x + B] = true;
        }
        if (temp.x - B >= 0 && !visited[temp.x - B]) {
            q.add(new Point(temp.x - B, temp.cnt + 1));
            visited[temp.x - B] = true;
        }
        if (temp.x + 1 <= maxX && !visited[temp.x + 1]) {
            q.add(new Point(temp.x + 1, temp.cnt + 1));
            visited[temp.x + 1] = true;
        }
        if (temp.x - 1 >= 0 && !visited[temp.x - 1]) {
            q.add(new Point(temp.x - 1, temp.cnt + 1));
            visited[temp.x - 1] = true;
        }
    }
}