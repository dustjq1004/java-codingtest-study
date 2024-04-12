package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 면접보는승범이네 {
    static int n, m, k;
    static long[] dist;
    static int[] place;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());

        graph = new ArrayList[n + 1];
        dist = new long[n + 1];
        place = new int[k];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            long weight = Integer.parseInt(token.nextToken());
            graph[end].add(new Node(start, weight));
        }

        token = new StringTokenizer(bf.readLine());
        for (int i = 0; i < k; i++) {
            place[i] = Integer.parseInt(token.nextToken());
        }

        dijstra();

        int maxNode = 0;
        long maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > maxDist) {
                maxNode = i;
                maxDist = dist[i];
            }
        }

        System.out.println(maxNode);
        System.out.println(maxDist);
    }

    static void dijstra() {
        Queue<Node> queue = new PriorityQueue<>();

        Arrays.fill(dist, -1);

        for (int i = 0; i < k; i++) {
            dist[place[i]] = 0L;
            queue.add(new Node(place[i], 0));
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (dist[cur.v] == -1 || dist[cur.v] < cur.w) continue;

            for (Node next : graph[cur.v]) {
                if (dist[next.v] == -1 || dist[next.v] > dist[cur.v] + next.w) {
                    dist[next.v] = dist[cur.v] + next.w;
                    queue.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int v;
        long w;

        public Node(int v, long w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.w, o.w);
        }
    }
}
