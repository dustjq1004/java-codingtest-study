/*
    백준 1946번: 신입 사원
    알고리즘 분류: #그리디 #정렬
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st;
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];

            for(int k = 0; k < n; k++) {
                st = new StringTokenizer(br.readLine());
                arr[k][0] = Integer.parseInt(st.nextToken());
                arr[k][1] = Integer.parseInt(st.nextToken());
            }
            // 서류심사 성적 기준으로 배열 오름차순 정렬
            Arrays.sort(arr, (start, end) -> start[0] == end[0] ? start[1] - end[1] : start[0] - end[0]);
            // 정렬 후 첫 번째 면접시험 성적을 min으로 지정
            int min = arr[0][1];
            int cnt = 0;

            for(int k = 1; k < n; k++) {
                // 배열을 순회하며 현재 면접시험 성적이 min보다 작다면 min을 최신화함
                if(arr[k][1] < min) {
                    min = arr[k][1];
                }
                // 그렇지 않다면 선발되지 못하는 인원을 카운트하는 cnt 변수의 값을 증가
                else {
                    cnt++;
                }
            }
            // 총 인원(n) - 선발되지 못하는 인원(cnt)
            System.out.println(n - cnt);
        }
    }
}