package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Snake {
    private List<Node> pos;
    private int length;
    private Node head;
    private Node tail;

    private int direction;

    public Snake() {
        Node node = new Node(1, 1);
        pos = new ArrayList<>();
        pos.add(node);
        head = node;
        tail = node;
        length = 1;
        direction = 0;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(String dir) {
        if(dir.equals("D")) {
            direction++;
        } else {
            direction--;
        }

        if (direction < 0) {
            direction = 3;
        }

        if (direction > 3) {
            direction = 0;
        }
    }

    public Node getMove(int[] direction) {
        return addHead(head.x, head.y, direction);
    }

    public boolean isSnake(int x, int y) {
        // 뱀이면 false
        for (int i = 0; i < length - 1; i++) {
            Node node = pos.get(i);
            if (node.x == x && node.y == y) {
                return false;
            }
        }

        return true;
    }

    public Node isGrow(int apple) {
        if (apple == 0) {
            return removeTail();
        }
        length++;
        return null;
    }

    private Node addHead(int x, int y, int[] direction) {
        Node newHead = new Node(x + direction[0], y + direction[1]);
        pos.add(newHead);
        head = newHead;
        return head;
    }

    private Node removeTail() {
        return pos.remove(0);
   }

}
class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Boj_3190 {

    public static Snake snake;
    public static int[][] board;
    public static int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static boolean isEnd(int x, int y, int n) {
        // 벽이면 false
        if (x < 1 || x > n || y < 1 || y > n) {
            return false;
        }

        if (!snake.isSnake(x, y)) return false;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int time = 0;

        Map<Integer, String> moveMap = new HashMap<>();
        board = new int[n + 1][n + 1];
        snake = new Snake();

        // board 에 사과 위치 표시
        int apples = Integer.parseInt(bf.readLine());
        for (int i = 0; i < apples; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1;
        }

        // 이동 정보
        int moves = Integer.parseInt(bf.readLine());
        for (int i = 0; i < moves; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            moveMap.put(t, d);
        }


        board[1][1] = 2; // 뱀 첫번째 위치
        while (true) {
            time++;
            // 머리 이동
            Node newHead = snake.getMove(directions[snake.getDirection()]);
            if (!isEnd(newHead.x, newHead.y, n)) {
                break;
            }

            // 꼬리 제거
            Node oldTail = snake.isGrow(board[newHead.x][newHead.y]);
            if (oldTail != null) {
                board[oldTail.x][oldTail.y] = 0;
            }

            board[newHead.x][newHead.y] = 2;

            if (moveMap.containsKey(time)) snake.setDirection(moveMap.get(time));
        }

        System.out.println(time);

        bf.close();
    }
}


/*
10
4
1 2
1 3
1 4
1 5
4
8 D
10 D
11 D
13 L
* */
