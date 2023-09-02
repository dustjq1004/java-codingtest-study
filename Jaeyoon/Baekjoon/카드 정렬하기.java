/*
    백준 1715번: 카드 정렬하기
    알고리즘 분류: #그리디 #자료구조 #우선순위 큐
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int n = Integer.parseInt(br.readLine());
        // 우선순위 큐 사용 (낮은 수가 우선순위를 가짐)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        // 큐에 남은 원소의 개수가 1개 이하가 될 경우 종료
        while(pq.size() > 1) {
            // 가장 낮은 수 2개를 꺼내서 둘을 더하고, 그 값을 다시 큐에 삽입함
            int temp = pq.poll() + pq.poll();
            pq.offer(temp);
            // temp를 누적해서 더해, 최종 결과값(sum)을 계산
            sum += temp;
        }

        System.out.println(sum);
    }
}