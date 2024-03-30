package pgs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ConvertWord {
    private static HashMap<String, List<String>> wordsmap;
    private static int result = Integer.MAX_VALUE;
    private static HashSet<String> isVisited;

    public int solution(String begin, String target, String[] words) {
        wordsmap = new HashMap<>();

        boolean haveTarget = false;
        for (String word : words) {
            if (word.equals(target)) {
                haveTarget = true;
                break;
            }
        }
        if (!haveTarget) return 0;

        wordsmap.put(begin, new ArrayList<>());
        for (int i = 0; i < words.length; i++) {
            if (isTrunk(words[i].toCharArray(), begin)) {
                List<String> list = wordsmap.get(begin);
                list.add(words[i]);
            }
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<String> orDefault = wordsmap.getOrDefault(word, new ArrayList<>());
            wordsmap.put(word, orDefault);
            for (int j = 0; j < words.length; j++) {
                String word2 = words[j];
                if (isTrunk(word2.toCharArray(), word)) {
                    // 노드에 간선을 추가한다.
                    orDefault.add(word2);
                }
            }
        }

        isVisited = new HashSet<>();

        dfs(begin, target, 0);

        return result;
    }

    private boolean isTrunk(char[] targets, String word) {
        int count = 0;
        for (int i = 0; i < targets.length; i++) {
            if (word.charAt(i) != targets[i] && ++count >= 2) {
                return false;
            }
        }
        return count == 1;
    }

    private void dfs(String begin, String target, int cnt) {
        List<String> list = wordsmap.get(begin);

        if (begin.equals(target)) {
            result = Math.min(result, cnt);
        }

        for (String word : list) {
            if (isVisited.contains(word)) continue;

            isVisited.add(word);
            dfs(word, target, cnt + 1);
            isVisited.remove(word);
        }
    }
}
