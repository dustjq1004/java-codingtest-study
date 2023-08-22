package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_12761 {

    int[] stone = new int[100001];
    int[] ways = new int[] {0, 1, 2, 3, 4, 5, 6, 7};
    int move(int cur, int path, int skyA, int skyB) {
        int result = cur;
        switch (path) {
            case 0:
                result += 1;
                break;
            case 1:
                result -= 1;
                break;
            case 2:
                result += skyA;
                break;
            case 3:
                result -= skyA;
                break;
            case 4:
                result += skyB;
                break;
            case 5:
                result -= skyB;
                break;
            case 6:
                result *= skyA;
                break;
            case 7:
                result *= skyB;
                break;

        }
        return result;
    }
    int bfs (int skyA, int skyB, int dong, int joo) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(dong);
        stone[dong] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == joo) {
                cnt = stone[cur] - 1;
                break;
            }
            for (int path : ways) {
                int next = move(cur, path, skyA, skyB);
                if(next > -1 && next < 100001 && stone[next] < 1) {
                    queue.offer(next);
                    stone[next] = stone[cur] + 1;
                }
            }
        }

        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(new Boj_12761().bfs(line[0], line[1], line[2], line[3]));

        bf.close();
    }
}
