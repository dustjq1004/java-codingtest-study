/*
    백준 15686번: 치킨 배달
    알고리즘 분류: #구현 #백트래킹 #완전탐색
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int result = Integer.MAX_VALUE;  // 도시의 치킨 거리 최솟값을 저장
    static int[][] map;
    static boolean[] visited;
    static int[][] choiceChicken;
    static List<int[]> houseLocation;
    static List<int[]> chickenLocation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[13];
        choiceChicken = new int[M][2];
        houseLocation = new LinkedList<>();
        chickenLocation = new LinkedList<>();

        // 도시의 정보를 입력받음. 집(1)과 치킨집(2)의 좌표를 List에 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if(num == 1) {
                    int[] temp = {i, j};
                    houseLocation.add(temp);
                } else if(num == 2) {
                    int[] temp = {i, j};
                    chickenLocation.add(temp);
                }
            }
        }
        // dfs 함수 호출
        dfs(0, 0);

        System.out.println(result);
    }

    // 도시의 치킨 거리의 최솟값을 구해서 반환
    public static void dfs(int k, int depth) {
        // M개의 치킨집이 선택되면, 그때의 치킨 거리를 구함
        if(depth == M) {
            // 도시의 치킨 거리를 계산해, 기존의 치킨 거리와 비교해 더 작은값을 저장
            result = Math.min(findDistance(), result);
            return;
        }
        // 도시에 있는 치킨집 중에서 M개를 중복없이 선택
        for (int i = k; i < chickenLocation.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                choiceChicken[depth][0] = chickenLocation.get(i)[0];
                choiceChicken[depth][1] = chickenLocation.get(i)[1];
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }

    }

    // M개의 치킨집이 선택됐을 때 도시의 치킨 거리를 계산해서 반환
    public static int findDistance() {
        int chickenDistance = 0;

        // 집의 좌표를 순회
        for (int[] item : houseLocation) {
            int r = item[0];
            int c = item[1];
            int minDistance = Integer.MAX_VALUE;
            // 치킨집의 좌표를 순회
            for (int j = 0; j < M; j++) {
                // 집과 치킨집 사이의 거리를 계산
                int distance = Math.abs(r - choiceChicken[j][0]) + Math.abs(c - choiceChicken[j][1]);
                // 최소 거리보다 짧다면 최소 거리를 갱신
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
            // 모든 집들의 치킨 거리를 누적해서 더함
            chickenDistance += minDistance;
        }

        return chickenDistance;
    }
}