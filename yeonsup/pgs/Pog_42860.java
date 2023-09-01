package pog;


public class Pog_42860 {

    private int getMinChangeCount(char a, char target) {
        int result = Math.min(target - a, (91 - 'A') - (target - a));
        return result;
    }

    private int getLastA(char[] alphabets, int index) {
        int move = index;
        while (move < alphabets.length && alphabets[move] == 'A') {
            move++;
        }
        return move;
    }
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        char[] alphabets = name.toCharArray();

        for (int i = 0; i < alphabets.length; i++) {
            answer += getMinChangeCount('A', alphabets[i]);
            if (i < alphabets.length - 1 && alphabets[i + 1] == 'A') {
                int end = getLastA(alphabets, i + 1);
                move = Math.min(move, i * 2 + (alphabets.length - end));
                move = Math.min(move, i + (alphabets.length - end) * 2);
            }
        }

        return answer + move;
    }

    public static void main(String[] args) {
        new Pog_42860().solution("JAN");
        new Pog_42860().solution("JEROEN");
        new Pog_42860().solution("AABBCCA");
        new Pog_42860().solution("FDBSBSFFSDDBSBDBSDAA");
        new Pog_42860().solution("AAAAAAAAAAAAAAAAAAAA");
        new Pog_42860().solution("ABAAAAAAAAAAAAAAAAAA");
        new Pog_42860().solution("BBAAAAAYYY");
    }
}
