package pgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Pgs_64065 {
    public static void main(String[] args) {
        new Solution_64065().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        new Solution_64065().solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        new Solution_64065().solution("{{20,111},{111}}");
        new Solution_64065().solution("{{123}}");
        new Solution_64065().solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");

    }
}

class Solution_64065 {
    public int[] solution(String s) {
        int[][] matchElements = parseStringToArray(s);
        List<Integer> answer = new ArrayList<>();
        for (int[] elements : matchElements) {
            int i = Arrays.stream(elements).filter(e -> !answer.contains(e)).findFirst().orElseGet(() -> 0);
            if (i <= 0) {
                continue;
            }
            answer.add(i);
        }
        System.out.println(answer.toString());
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int[][] parseStringToArray(String s) {
        String parse = s.substring(2, s.length() - 2);
        String[] parseOneDim = parse.replaceAll("},\\{", "|").split("\\|");
        int[][] result = new int[parseOneDim.length][];
        Arrays.sort(parseOneDim, Comparator.comparingInt((o1) -> o1.length()));
        int i = 0;
        for (String parseTwoDim : parseOneDim) {
            String[] parseElements = parseTwoDim.split(",");
            int[] elements = new int[parseElements.length];
            int j = 0;
            for (String element : parseElements) {
                elements[j] = Integer.parseInt(element);
                j++;
            }
            result[i] = elements;
            i++;
        }
        return result;
    }
}

/**
 1. 정렬을 우선적으로 한다.
 - 정렬을 하게 되면 집합이 원소의 개수에 따라 정렬된다.
 - 원소가 하나인 집합은 튜플의 첫번째 글자가 된다.
 - 그 다음 2개를 가지고 있는 x집합을 비교한다.
 - 2개이니 튜플의 첫번째 원소와 다른 하나가 튜플의 두번째 원소가 된다.
 - 튜플의 원소는 1~100,000이하인 자연수다.
 */
