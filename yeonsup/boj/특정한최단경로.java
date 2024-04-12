package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정한최단경로 {
    static int n, m;
    static int[] dist;
    static List<Node>[] graph;
    static int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int time = Integer.parseInt(token.nextToken());

            graph[start].add(new Node(end, time));
            graph[end].add(new Node(start, time));
        }

        String[] input = bf.readLine().split(" ");
        int v1 = Integer.parseInt(input[0]);
        int v2 = Integer.parseInt(input[1]);

        int result1 = 0;
        result1 += dijstra(1, v1);
        result1 +=  dijstra(v1, v2);
        result1 += dijstra(v2, n);

        int result2 = 0;
        result2 += dijstra(1, v2);
        result2 += dijstra(v2, v1);
        result2 += dijstra(v1, n);

        int answer = 0;

        if (result1 >= INF  && result2 >= INF) {
            answer = -1;
        } else {
            answer = Math.min(result1, result2);
        }

        System.out.println(answer);
    }
    static int dijstra(int start, int end) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dist, INF);
        dist[start] = 0;

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
        return dist[end];
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
