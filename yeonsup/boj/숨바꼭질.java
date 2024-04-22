package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class 숨바꼭질 {

    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n));
    }

    private static int bfs(int start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start, 0));
        int time = Integer.MAX_VALUE;
        boolean[] visited = new boolean[100_010];
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            visited[cur.n] = true;
            if (cur.n == k) {
                time = Math.min(time, cur.cnt);
            }

            for (Calculator calculator : Calculator.values()) {
                int next = calculator.calculate(cur.n);
                if (next >= 0 && next <= 100_000 && !visited[next]) {
                    queue.add(new Node(next, cur.cnt + 1));
                }
            }
        }

        return time;
    }


    enum Calculator {
        PLUS_ONE((x) -> x + 1),
        MINUS_ONE((x) -> x - 1),
        MULTIPLY_TWO(x -> x * 2);

        private Function<Integer, Integer> expression;

        Calculator(Function<Integer, Integer> expression) {
            this.expression = expression;
        }

        public int calculate(int value) {
            return expression.apply(value);
        }
    }


    private static class Node {
        int n, cnt;

        public Node(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }
}
