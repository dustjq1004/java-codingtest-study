package pgs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PGS_132265 {
    public static void main(String[] args) {
        new Solution_132265().solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});
    }
}

class Solution_132265 {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> cheolsu = new HashSet<>();
        Map<Integer, Integer> brother = new HashMap<>();
        for (int number : topping) {
            if (brother.computeIfPresent(number, (key, value) -> value + 1) == null) {
                brother.put(number, 1);
            }
        }

        for (int number : topping) {
            Integer v = brother.computeIfPresent(number, (key, value) -> value - 1);
            cheolsu.add(number);
            if (v == 0) {
                brother.remove(number);
            }

            if (cheolsu.size() == brother.size()) {
                answer++;
            }
        }


        System.out.println(answer);
        return answer;
    }
}
