package pog;

import java.util.Arrays;

class Solution {

    int solution(int[][] land) {
        int [][] temp = new int[land.length][4];
        int answer = 0;

        for (int i = 0; i < temp.length; i++) {
            temp[i] = land[i];
            temp[i] = land[i];
            temp[i] = land[i];
            temp[i] = land[i];
        }

        for (int i = 1; i < temp.length; i++) {
            temp[i][0] = temp[i][0] + Arrays.stream(new int[]{land[i - 1][1], land[i - 1][2], land[i - 1][3]}).max().getAsInt();
            temp[i][1] = temp[i][1] + Arrays.stream(new int[]{land[i - 1][0], land[i - 1][2], land[i - 1][3]}).max().getAsInt();
            temp[i][2] = temp[i][2] + Arrays.stream(new int[]{land[i - 1][0], land[i - 1][1], land[i - 1][3]}).max().getAsInt();
            temp[i][3] = temp[i][3] + Arrays.stream(new int[]{land[i - 1][0], land[i - 1][1], land[i - 1][2]}).max().getAsInt();
        }

        answer = Arrays.stream(temp[temp.length - 1]).max().getAsInt();

        return answer;
    }
}
public class Pog_12913 {
    public static void main(String[] args) {
        int[][] rand = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
//        int[][] rand = {{1,2,3,5},{5,6,7,8},{4,3,2,1},{6,3,4,99}};
        System.out.println(new Solution().solution(rand));
        //[[4, 3, 2, 1], [2, 2, 2, 1], [6, 6, 6, 4], [8, 7, 6, 5]]
        System.out.println(new Solution().solution(new int[][] {{1,1,1,1}, {2,2,2,3}, {3,3,3,6}, {4,4,4,7}}));
        System.out.println(new Solution().solution(new int[][] {{4,3,2,1}, {2,2,2,1}, {6,6,6,4}, {8,7,6,5}}));
    }
}
