package pgs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Pgs_42577 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> map = new HashSet<>();

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Pgs_42577().solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(new Pgs_42577().solution(new String[]{"123","456","789"}));
        System.out.println(new Pgs_42577().solution(new String[]{"12","123","1235","567","88"}));
    }

}
