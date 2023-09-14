/*
    백준 2294번: 동전 2
    알고리즘 분류: #DP
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 현재 동전의 가치(k)와 동전의 사용 횟수(cnt)를 저장할 클래스
class Point {
    int k;
    int cnt;
    Point(int k, int cnt) {
        this.k = k;
        this.cnt = cnt;
    }
}

public class Main {
    static int n;
    static int k;
    static int[] coins;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new int[n];
        visited = new boolean[100001];

        // 각 동전의 가치를 배열에 저장
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // bfs 메소드 호출 (k -> 0원에서 시작, cnt -> 초기 사용 횟수 0)
        int result = bfs(new Point(0, 0));

        // 주어진 동전들로 k원을 만들 수 없다면 -1 출력. 그렇지 않다면 사용한 최소 동전 개수를 출력
        if(result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    // 너비 우선 탐색(bfs)을 이용해 0에서 k까지 도달하는 경우 중
    // 가장 빠른 경우를 찾아 동전의 최소 사용 횟수를 리턴
    public static int bfs (Point p) {
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visited[p.k] = true;

        while (!q.isEmpty()) {
            Point temp = q.poll();
            // 큐에 들어있던 가치(temp.k)와 최종 가치(k)가 일치하면 사용 횟수(cnt)를 리턴
            if (temp.k == k) {
                return temp.cnt;
            }
            // coins 배열을 순회해 각 동전의 가치와 기존 가치를 더한 값을 큐에 추가
            for (int num : coins) {
                // 가치의 최대치를 넘지 않고, 방문하지 않은 곳일 경우 큐에 추가
                if(temp.k + num <= 100000 && !visited[temp.k + num]) {
                    q.offer(new Point(temp.k + num, temp.cnt + 1));
                    visited[temp.k + num] = true;
                }
            }
        }
        // 최종 가치(k)에 도달하지 못한 경우 0을 리턴
        return 0;
    }
}