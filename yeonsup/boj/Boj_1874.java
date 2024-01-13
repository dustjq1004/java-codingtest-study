package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Boj_1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<String> output = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque();
        int n = Integer.parseInt(bf.readLine());
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Integer.parseInt(bf.readLine());
        }

        int currentNumber = 1;
        int answerIndex = 0;
        while (answerIndex < n) {
            if (!stack.isEmpty()) {
                Integer stackNumber = stack.getFirst();

                if (stackNumber == answer[answerIndex]) {
                    output.add("-");
                    stack.pop();
                    answerIndex++;
                    continue;
                }

                /* No 조건
                answer 숫자가 그 전 숫자에 연속된 작은 수가 아닌 경우
                - 그리고 나와야 되는 숫자가 아닌 경우
                 */
                if (answerIndex > 0 && answer[answerIndex] < answer[answerIndex - 1] && stackNumber != answer[answerIndex]) {
                    break;
                }
            }

            if (currentNumber <= n)
                stack.push(currentNumber++);

            output.add("+");
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            output.forEach(System.out::println);
        }
    }
}
