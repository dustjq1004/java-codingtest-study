package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티 {
    static int n, m, x;
    static int[] dist1;
    static int[] dist2;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        x = Integer.parseInt(token.nextToken());

        List<Node>[] graph = new ArrayList[n + 1];
        List<Node>[] reverse = new ArrayList[n  + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int time = Integer.parseInt(token.nextToken());

            graph[start].add(new Node(end, time));
            reverse[end].add(new Node(start, time));
        }

        dist1 = dijstra(graph);
        dist2 = dijstra(reverse);

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dist1[i] + dist2[i]);
        }

        System.out.println(result);
    }
    static int[] dijstra(List<Node>[] graph) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(x, 0));

        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            visited[cur.v] = true;
            if (dist[cur.v] < cur.t) {
                continue;
            }

            for (Node next : graph[cur.v]) {
                if (visited[next.v]) continue;
                if (dist[next.v] > cur.t + next.t) {
                    dist[next.v] = cur.t + next.t;
                    queue.add(new Node(next.v, cur.t + next.t));
                }
            }
        }
        return dist;
    }

    static class Node implements Comparable<Node>{
        int v, t;

        public Node(int v, int t) {
            this.v = v;
            this.t = t;
        }

        @Override
        public int compareTo(Node o) {
            return this.t - o.t;
        }
    }
}
