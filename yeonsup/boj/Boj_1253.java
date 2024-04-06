package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_1253 {

    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && binarySearch(0, n - 1, numbers, i, j)) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean binarySearch(int start, int end, int[] numbers, int i, int j) {
        int mid = (start + end) / 2;

        if (start > end) {
            return false;
        }

        int target = numbers[i] - numbers[j];

        if (target < numbers[mid]) {
            return binarySearch(start, mid - 1, numbers, i, j);
        } else if (i != mid && j != mid && target == numbers[mid]) {
            return true;
        } else {
            return binarySearch(mid + 1, end, numbers, i, j);
        }
    }
}
