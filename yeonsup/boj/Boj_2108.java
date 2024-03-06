package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Boj_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);
        StringBuffer sb = new StringBuffer();
        sb.append(average(numbers) + "\n");
        sb.append(center(numbers) + "\n");
        sb.append(getManyValues(numbers) + "\n");
        sb.append(range(numbers) + "\n");

        System.out.println(sb.toString());
    }

    // 산술평균
    // 합계 후 평균 계산
    private static int average(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        return (int) Math.round(sum / (double) numbers.length);
    }

    // 중앙 값
    // length / 2
    private static int center(int[] numbers) {
        return numbers[(int) Math.ceil(numbers.length / 2)];
    }

    // 최빈 값
    // 1. 맵에 빈도수를 담는다.
    // 2. 빈도수 max인 숫자를 filter 한다.
    //  - 여러 개라면 2 번째 값을 가져온댜.
    private static int getManyValues(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int max = 0;
        for (Integer key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }

        Set<Integer> keys = map.keySet();
        int finalMax = max;
        int[] temps = keys.stream().filter((key) -> map.get(key) == finalMax).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(temps);

        if (temps.length == 1) {
            return temps[0];
        } else {
            return temps[1];
        }
    }

    // 범위
    private static int range(int[] numbers) {
        return Arrays.stream(numbers).max().getAsInt() - Arrays.stream(numbers).min().getAsInt();
    }
}
