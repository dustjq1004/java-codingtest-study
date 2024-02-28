package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13300 {

    // board
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] students = new int[7][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            students[y][s]++;
        }

        int roomCnt = 0;
        for (int i = 1; i < students.length; i++) {
            for (int j = 0; j < 2; j++) {
                roomCnt += students[i][j] / k;
                roomCnt += students[i][j] % k != 0 ? 1 : 0;
            }
        }

        System.out.println(roomCnt);
    }
}
