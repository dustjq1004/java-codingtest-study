package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_13413 {

    static char[] othello;
    static char[] targets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            othello = br.readLine().toCharArray();
            targets = br.readLine().toCharArray();
            int cnt = othelloCount(n);

            int fCount = 0;
            int eCount = 0;

            for (int i = 0; i < n; i++) {
                if (othello[i] != targets[i])
                    cnt++;
                fCount = othello[i] == 'W' ? fCount + 1 : fCount;
                eCount = targets[i] == 'W' ? eCount + 1 : eCount;
            }

            System.out.println(cnt);
        }
    }

    public static int othelloCount(int n) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (othello[i] == targets[i]) continue;

            // 1. 바꾸는 판단 (인접한 것이 아닌 임의의 두개)
            if (isChange(i, n)) {
                cnt++;
            } else {
                // 2. 뒤집는 파단
                othello[i] = othello[i] == 'B' ? 'W' : 'B';
                cnt++;
            }
        }
        return cnt;
    }

    public static boolean isChange(int i, int n) {
        for (int j = i + 1; j < n; j++) {
            if (othello[i] != othello[j] &&
                    othello[i] == targets[j] && othello[j] == targets[i]) {
                swap(i, j);
                return true;
            }
        }
        return false;
    }

    private static void swap(int n, int t) {
        int temp = othello[t];
        othello[t] = othello[n];
        othello[n] = othello[t];
    }
}
