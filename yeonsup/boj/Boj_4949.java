package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class Boj_4949 {
    private static Deque<String> stack = new LinkedList<>();
    private static String closeBrackets = ")]";
    private static String openBrackets = "([";
    private static Pattern REGEX = Pattern.compile("[^()\\[\\].]");

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean isEnd = true;
        while (isEnd) {
            String input = bf.readLine();

            if (input.equals(".")) {
                isEnd = false;
                continue;
            }

            String[] inputWords = REGEX.matcher(input).replaceAll("").split("");

            if (isBlackAndWhite(inputWords)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            
            stack.clear();
        }

        bf.close();
    }

    private static boolean isBlackAndWhite(String[] inputWords) {
        for (String word : inputWords) {
            if (word.equals(".")) continue;
            if (openBrackets.contains(word)) {
                stack.push(word);
            } else if (!stack.isEmpty() &&
                    closeBrackets.indexOf(word) == openBrackets.indexOf(stack.peek())) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
