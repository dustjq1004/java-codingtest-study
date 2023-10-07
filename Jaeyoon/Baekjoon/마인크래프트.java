/*
    백준 18111번: 마인크래프트
    알고리즘 분류: #그래프 이론 #그래프 탐색 #BFS
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] map = new int[N * M];
        int mintime = Integer.MAX_VALUE;
        int targetNum = -1;

        // 블록의 정보를 1차원 배열에 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i * M + j] = Integer.parseInt(st.nextToken());
            }
        }
        // 배열 오름차순 정렬
        Arrays.sort(map);

        // 배열의 최소값 ~ 최대값까지 반복. k -> 기준으로 잡을 땅의 높이
        for (int k = map[0]; k <= map[N * M - 1]; k++) {
            int time = 0;
            int block = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int dif = map[i * M + j] - k;

                    // 2번 작업 수행 (블록 제거)
                    if (dif > 0) {
                        time += Math.abs(dif) * 2;
                        block += Math.abs(dif);
                    }
                    // 1번 작업 수행 (블록 추가)
                    else if (dif < 0) {
                        time += Math.abs(dif);
                        block -= Math.abs(dif);
                    }

                }
            }
            // 블록이 0보다 작을 경우 다음으로 넘어감.
            if (block < 0) {
                continue;
            }
            // 최소 시간 갱신
            if (mintime >= time) {
                mintime = time;
                targetNum = k;
            }
        }
        // 최소 시간과 땅의 높이를 출력
        System.out.println(mintime + " " + targetNum);
    }
}