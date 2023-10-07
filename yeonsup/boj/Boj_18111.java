package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_18111 {

    public static TreeMap<Integer, Integer> getNumberCntMap(int [][] board) {
        TreeMap<Integer, Integer> result = new TreeMap<>();

        for (int[] row : board) {
            for (int col : row) {
                result.put(col, result.getOrDefault(col, 0) + 1);
            }
        }
        return result;
    }

    public static int[] getMinTimeBlockHeight(TreeMap<Integer, Integer> numbers, int b) {
        int block = 0;
        int minTime = Integer.MAX_VALUE;

        int[] array = numbers.keySet().stream().mapToInt(Integer::valueOf).toArray();

        for (int i = array[0]; i <= array[array.length - 1]; i++) {
            int blockCnt = b;
            int target = i;
            int time = 0;
            for (int j = array.length - 1; j >= 0; j--) {
                int num = array[j];
                if(target == num) continue;

                int value = target - num;
                if(value < 0) { // 음수면 블럭 제거
                    time += Math.abs(value) * numbers.get(num) * 2;
                    blockCnt += Math.abs(value) * numbers.get(num);
                } else { // 양수면 추가
                    time += Math.abs(value) * numbers.get(num) * 1;
                    blockCnt -= Math.abs(value) * numbers.get(num);
                }

                if (blockCnt < 0) break;

            }

            if (blockCnt < 0) continue;

            if(time < minTime) {
                minTime = time;
                block = target;
            } else if (time == minTime) {
                if (block < target) block = target;
            }
        }

        return new int[] {minTime, block};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }

        TreeMap<Integer, Integer> numbers = getNumberCntMap(board);

//        System.out.println(numbers.toString());

        int[] result = getMinTimeBlockHeight(numbers, b);


        System.out.println(result[0] + " " + result[1]);
    }
}

/**
 2 2 2
 5 1
 2 5
 */