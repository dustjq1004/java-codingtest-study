package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 리모컨 {
    static int current = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[10];
        int channel = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());

        if (m > 0) {
            for (String input : br.readLine().split(" ")) {
                numbers[Integer.parseInt(input)] = 1;
            }
        }

        if (channel == current) {
            System.out.println(0);
            return;
        }

        int count = changeChannelByNumbers(numbers, channel);

        System.out.println(count);
    }

    // 번호 버튼을 통해 채널을 변경하고 변경 횟수를 반환한다.
    private static int changeChannelByNumbers(int[] numbers, int channel) {
        int result = Math.abs(channel - current);

        for (int i = 0; i <= 999_999; i++) {
            String current = String.valueOf(i);
            int length = current.length();
            boolean isBroke = false;
            for (char digit : current.toCharArray()) {
                int number = digit - '0';
                if (numbers[number] == 1) {
                    isBroke = true;
                    break;
                }
            }

            if (!isBroke) {
                int min = Math.abs(channel - i) + length;
                result = Math.min(result, min);
            }
        }

        return result;
    }
}
