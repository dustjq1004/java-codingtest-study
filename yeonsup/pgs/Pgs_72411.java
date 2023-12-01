package pgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pgs_72411 {
    public static void main(String[] args) {
//        new Solution_72411().solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
//                new int[] {2, 3, 4});
        new Solution_72411().solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                new int[] {2, 3, 5});
    }
}

class Solution_72411 {

    private char[] alphabets;
    private Map<String, Integer> map;
    private Map<Integer, Integer> max;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        map = new HashMap<>();
        max = new HashMap<>();

        for (int i = 0; i < orders.length; i++) {
            alphabets = orders[i].toCharArray();
            Arrays.sort(alphabets);
            for (int number : course) {
                search(number, orders, "", 0);
            }
        }
        System.out.println(map);
        System.out.println("max = " + max);
        max.forEach((key, value) -> {
            if (value >= 2) {
                map.entrySet()
                        .stream()
                        .filter(entry -> entry.getKey().length() == key && entry.getValue() == value)
                        .forEach(entry -> answer.add(entry.getKey()));
            }
        });
        Collections.sort(answer);
        System.out.println(answer);
        return answer.stream().toArray(String[]::new);
    }

    private void search(int course, String[] orders, String s, int depth) {

        if (s.length() == course) {
            int value = map.getOrDefault(s, 0) + 1;
            map.put(s, value);
            max.put(course, Math.max(value, max.getOrDefault(course, 0)));
            return;
        }

        for (int i = depth; i < alphabets.length; i++) {
            search(course, orders, s + alphabets[i], i + 1);
        }
    }
}
