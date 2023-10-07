/*
    백준 12847번: 꿀 아르바이트
    알고리즘 분류: #누적 합 #슬라이딩 윈도우
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long max = 0;
        long cost = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            // 처음 m개의 수의 합을 저장
            if(i < m) {
                cost += arr[i];
            }
        }

        max = cost;

        // 연속되는 m개의 수들의 합을 비교하며 max값을 탐색
        for (int i = 0; i < n - m; i++) {
            cost = cost - arr[i] + arr[i + m];

            if(cost > max) {
                max = cost;
            }
        }

        System.out.println(max);
    }
}