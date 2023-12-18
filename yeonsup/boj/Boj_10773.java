package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Boj_10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new LinkedList<>();
        int inputLength = Integer.parseInt(bf.readLine());

        for (int i = 0; i < inputLength; i++) {
            int number = Integer.parseInt(bf.readLine());
            if (number == 0) {
                stack.pop();
            } else {
                stack.push(number);
            }
        }

        System.out.println(stack.stream().mapToInt(Integer::valueOf).sum());

        bf.close();
    }
}
