package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Boj_1935 {
    /*
    5
    ABC*+DE/-
    1
    2
    3
    4
    5
    * */
    private static Pattern regex = Pattern.compile("[-+/*]");
    private static Deque<Double> stack = new ArrayDeque<>();
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split("");

        for (int i = 0; i < p; i++) {
            map.put(String.valueOf((char) ('A' + i)), Integer.parseInt(br.readLine()));
        }

        System.out.println(String.format("%.2f", postfix(input)));

        br.close();
    }

    private static double postfix(String[] input) {
        for (int i = 0; i < input.length; i++) {
            String a = input[i];
            if (!regex.matcher(a).matches()) {
                stack.push((double) map.get(a));
            } else {
                double y = stack.pop();
                double x = stack.pop();
                double result = calculate(a, x, y);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private static double calculate(String input, double a, double b) {
        double result = 0;
        switch (input) {
            case "+" :
                result = a + b;
                break;
            case "-" :
                result = a - b;
                break;
            case "*" :
                result = a * b;
                break;
            case "/" :
                result = a / b;
                break;
        }
        return result;
    }
}
