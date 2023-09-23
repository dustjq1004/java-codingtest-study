/*
    백준 1253번: 좋다
    알고리즘 분류: #자료 구조 #정렬 #이분탐색 #투 포인터
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n개의 수와 해당 수의 개수를 저장할 해시맵
        HashMap<Integer, Integer> hm = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int goodNumCnt = 0;    // 좋은 수의 개수를 count
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            // 해시맵에 해당 수가 존재한다면 count를 1만큼 증가, 존재하지 않는다면 해당 수를 해시맵에 저장
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        // 배열 오름차순 정렬
        Arrays.sort(arr);

        Loop1:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0;

                /*
                    arr[i] = arr[j] + (arr[i] - arr[j])
                    arr[j]와 num의 합이 arr[i]와 일치한다면 arr[i]는 문제의 조건에 만족하는 수가 됨 (좋은 수)
                 */
                num = arr[i] - arr[j];

                // i != j 이고, 해시맵에 num이 존재하는 경우
                if(i != j && hm.get(num) != null) {
                    // arr[i], arr[j]가 모두 0인 경우, num도 0이 되므로 0이 최소 3개 이상 존재해야함
                    if(arr[i] == 0 && arr[j] == 0) {
                        if(hm.get(0) >= 3) {
                            goodNumCnt++;
                            continue Loop1;
                        }
                    } else if(arr[j] == num || arr[i] == num) {
                        // arr[i] 혹은 arr[j]가 num과 일치할 경우, num이 최소 2개 이상 필요함
                        if(hm.get(num) >= 2){
                            goodNumCnt++;
                            continue Loop1;
                        }
                    } else {
                        goodNumCnt++;
                        continue Loop1;
                    }
                }
            }
        }

        System.out.println(goodNumCnt);
    }
}