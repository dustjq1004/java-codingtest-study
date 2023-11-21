package pgs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Pgs_86052 {

    public static void main(String[] args) {
        new Solution_86052().solution(new String[]{"SL", "LR"});
        new Solution_86052().solution(new String[]{"S"});
        new Solution_86052().solution(new String[]{"R", "R"});
    }
}

class Solution_86052 {

    private static boolean[][][] visited;
    private static int[][] direction = new int[][] {
            {0, 2, 3},
            {1, 3, 2},
            {2, 1, 0},
            {3, 0, 1}
    };

    private static String[][] node;
    private static String s = "SLR";

    public int[] solution(String[] grid) {
        List<Integer> result = new ArrayList<>();
        node = new String[grid.length][grid[0].length()];
        visited = new boolean[grid.length][grid[0].length()][4];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                node[i][j] = String.valueOf(grid[i].charAt(j));
            }
        }

        for (int i = 0; i < node.length; i++) {
            for (int j = 0; j < node[i].length; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!visited[i][j][k]) {
                        result.add(dfs(k, i, j));
                    }
                }
            }
        }
        System.out.println(result);
        Collections.sort(result);
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int dfs(int enter, int row, int col) {
        int count = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(row, col, enter));
        while (!queue.isEmpty()) {
            Node newNode = queue.poll();
            int newRow = newNode.getRow();
            int newCol = newNode.getCol();
            if(visited[newRow][newCol][newNode.getEnter()]) return count;
            visited[newRow][newCol][newNode.getEnter()] = true;

            int newEnter = direction[newNode.getEnter()][s.indexOf(node[newRow][newCol])];
            if (newEnter == 0) {
                newRow++;
            }
            if (newEnter == 1) {
                newRow--;
            }
            if (newEnter == 2) {
                newCol++;
            }
            if (newEnter == 3) {
                newCol--;
            }

            if (newRow < 0) {
                newRow = node.length - 1;
            } else if (newRow >= node.length) {
                newRow = 0;
            }

            if (newCol < 0) {
                newCol = node[newRow].length - 1;
            } else if (newCol >= node[newRow].length) {
                newCol = 0;
            }
            queue.offer(new Node(newRow, newCol, newEnter));
            count++;
        }


        return count;
    }
}

class Node {
    private int row;
    private int col;
    private int enter;

    public Node(int row, int col, int enter) {
        this.row = row;
        this.col = col;
        this.enter = enter;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getEnter() {
        return enter;
    }
}
