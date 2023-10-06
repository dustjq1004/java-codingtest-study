package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class Boj_12847 {

    public static long getMaxPay(long[] prefixSum, int n, int m) {
        long result = 0;

        for (int i = m; i < n + 1; i++) {
            result = Math.max(result, prefixSum[i] - prefixSum[i - m]);
        }

        return result;
    }
    public static long[] prefixSum(int [] arr) {
        long[] prefixSum = new long[arr.length + 1];
        long sum = 0;
        for (int i = 1; i < prefixSum.length; i++) {;
            prefixSum[i] = arr[i - 1] + prefixSum[i - 1];
        }

        return prefixSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        long[] prefixSum = prefixSum(array);

        long result = getMaxPay(prefixSum, n, m);

        System.out.println(result);
        br.close();
    }
}
