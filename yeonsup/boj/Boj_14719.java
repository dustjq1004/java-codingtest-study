package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_14719 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String w = st.nextToken();
        String h = st.nextToken();
        int[] heights = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int total = 0;
        for (int i = 1; i < heights.length - 1; i++) {
            total += getRainWater(i, heights);
        }

        System.out.println(total);
        bf.close();
    }

    public static int getRainWater(int col, int[] heights) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < col; i++) {
            left = Math.max(left, heights[i]);
        }

        for (int i = col; i < heights.length; i++) {
            right = Math.max(right, heights[i]);
        }

        int result = Math.min(left, right) - heights[col];

        if (result < 1) {
            result = 0;
        }

        return result;
    }
}
