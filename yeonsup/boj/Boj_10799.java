package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10799 {
    /*
    다음 괄호가 여는 괄호면 막대기 추가 : N++; +1;
    다음 괄호가 닫는 괄호면 레이저 : N += N
    막대기가 끝나면 막대기 제거 : N--
    ()(((()())(())()))(())
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputBar = br.readLine().split("");
        int barCount = 0;

        int count = 0;
        for (int index = 0; index < inputBar.length; index++) {
            String cur = inputBar[index];

            if (cur.equals("(")) {
                if (inputBar[index + 1].equals(")")) {
                    count += barCount;
                    index++;
                } else {
                    barCount++;
                    count++;
                }
            } else {
                barCount--;
            }
        }

        System.out.println(count);
    }
}
