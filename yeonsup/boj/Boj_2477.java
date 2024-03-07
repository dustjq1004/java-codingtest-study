package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2477 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int melonCount = Integer.parseInt(br.readLine());
        int[] dirCount = new int[5];
        int[] lengths = new int[7];
        int[] directions = new int[7];

        for (int i = 0; i < 6; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int direction = input[0];

            dirCount[direction]++;
            directions[i] = direction;
            lengths[i] = input[1];
        }

        // 큰 변 넓이, 잘려나간 사각형 넓이
        int big = 1;
        int small = 1;
        for (int i = 0; i < 6; i++) {
            if (dirCount[directions[i]] == 1) {
                big *= lengths[i];
                small *= lengths[(i + 3) % 6];
            }
        }

        // (큰 변 넓이 - 작은 변 넓이) * n
        int result = (big - small) * melonCount;
        System.out.println(result);
    }
}
