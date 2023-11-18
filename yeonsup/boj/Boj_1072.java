package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_1072 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double gameCount = array[0];
        double winCount = array[1];
        int min = Integer.MAX_VALUE;
        long winRate = getWinRate(winCount, gameCount);

        if (winRate >= 99) {
            System.out.println("-1");
            return;
        }

        long result = binarySearch(gameCount, winCount, 0, Integer.MAX_VALUE, winRate, min);
        System.out.println(result);
    }

    private static long getWinRate(double winCount, double gameCount) {
        long winRate = (long) (winCount * 100 / gameCount);
        return winRate;
    }

    public static long binarySearch(double gameCount, double winCount, long start, long end, long winRate, long min) {
        long half = (start + end) / 2;

        if (start > end) {
            return min;
        }

        long comparedRate = getWinRate((winCount + half), (gameCount + half));

        if (comparedRate > winRate) {
            min = half;
            return binarySearch(gameCount, winCount, start, half - 1, winRate, min);
        } else {
            return binarySearch(gameCount, winCount, half + 1,  end, winRate, min);
        }
    }
}
