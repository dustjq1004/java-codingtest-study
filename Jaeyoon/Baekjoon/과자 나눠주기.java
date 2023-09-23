/*
    백준 16401번: 과자 나눠주기
    알고리즘 분류: #이분 탐색 #매개변수 탐색
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

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[N - 1];

        // 막대 과자의 최대 길이를 탐색
        while(left <= right) {
            int mid = (left + right) / 2;

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += arr[i] / mid;
            }

            if(cnt >= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left - 1);
    }
}