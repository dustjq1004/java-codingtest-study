package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_3986 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bf.readLine());
        GoodWord goodWord = new GoodWord();

        int count = 0;
        for (int i = 0; i < length; i++) {
            String word = bf.readLine();
            if (goodWord.isGoodWord(word)) {
                count++;
            }
        }
        System.out.println(count);

        bf.close();
    }
}

class GoodWord {

    public boolean isGoodWord(String word) {
        if (word.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        stack.push(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            if (stack.size() > 0 && stack.peek() == word.charAt(i)) {
                stack.pop();
            } else {
                stack.push(word.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}


