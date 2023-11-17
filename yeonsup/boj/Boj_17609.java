package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer stringBuffer = new StringBuffer();
        Palindrome palindrome = new Palindrome();
        int length = Integer.parseInt(bf.readLine());

        for (int i = 0; i < length; i++) {
            String word = bf.readLine();
            stringBuffer.append(palindrome.isPalindrome(word, 0, word.length() - 1, 0) + "\n");
        }
        System.out.println(stringBuffer);
        bf.close();
    }
}

class Palindrome {

    public int isPalindrome(String word, int front, int end, int cnt) {
        while (front < end && cnt < 2) {
            if (word.charAt(front) == word.charAt(end)) {
                front++;
                end--;
                continue;
            }
            cnt = Math.min(isPalindrome(word, front + 1, end, cnt + 1), isPalindrome(word, front, end - 1, cnt + 1));
            break;
        }
        return cnt;
    }
}