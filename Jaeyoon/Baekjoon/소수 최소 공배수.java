/*
    백준 21919번: 소수 최소 공배수
    알고리즘 분류: #수학 #정수론 #소수 판정 #에라토스테네스의 체
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 수열의 원소들을 저장할 배열
        int[] arr = new int[N];
        // 수열에서 소수에 해당하는 수들만 저장할 ArrayList
        ArrayList<Integer> primeNum = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 배열 정렬
        Arrays.sort(arr);

        boolean[] primeCheck = new boolean[arr[N - 1] + 1];
        // 에라토스테네스의 체 알고리즘을 사용해 배열의 최대값(arr[N - 1])에 해당하는 범위 내에서 소수들을 판별
        for (int i = 2; i <= arr[N - 1]; i++) {
            if (!primeCheck[i]) {
                for (int j = 2; i * j <= arr[N - 1]; j++) {
                    primeCheck[i * j] = true;
                }
            }
        }
        // 입력받은 배열을 순회
        for (int n : arr) {
            // 해당 수가 소수이면서 이미 ArrayList에 포함된 수가 아니라면(중복체크) ArrayList에 추가
            if (!primeCheck[n] && !primeNum.contains(n)) {
                primeNum.add(n);
            }
        }
        // ArrayList가 비어있다면 소수가 없으므로 -1을 출력 후 종료
        if(primeNum.isEmpty()){
            System.out.println(-1);
            return;
        }

        long result = 1;
        // 소수들을 모두 곱해 최소공배수를 구함
        for(int n : primeNum){
            result *= n;
        }
        System.out.println(result);
    }
}