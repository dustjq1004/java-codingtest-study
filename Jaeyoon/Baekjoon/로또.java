/*
    백준 6603번: 로또
    알고리즘 분류: #수학 #조합론 #백트래킹 #재귀
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] arr;
    static boolean[] visited;
    // 6개의 로또 번호를 저장할 배열
    static int[] resultArr = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            // 0이 입력되면 루프 종료
            if(k == 0){
                return;
            }
            arr = new int[k];
            visited = new boolean[k];
            // k개의 수를 배열에 저장
            for(int i = 0; i < k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0);
            System.out.println();
        }
    }
    // dfs를 이용한 백트래킹
    // idx는 탐색을 시작할 인덱스, depth는 현재까지 선택된 로또 번호의 개수를 의미(max -> 6)
    public static void dfs(int idx, int depth){
        // 6개의 번호가 모두 선택된 경우 배열의 숫자를 출력
        if(depth == 6){
            for(int n : resultArr){
                System.out.print(n+" ");
            }
            System.out.println();
            return;
        }
        for(int i = idx; i < k; i++){
            // 방문하지 않은 인덱스일 경우
            if(!visited[i]){
                visited[i] = true;
                // 배열의 인덱스에 해당되는 숫자를 결과 배열에 저장
                resultArr[depth] = arr[i];
                // 현재 인덱스(i) +1, 선택된 로또 번호의 개수(depth) +1 재귀호출
                dfs(i+1,depth+1);
                visited[i] = false;
            }
        }

    }
}