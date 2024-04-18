package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


// 구현 알고리즘 = 벪만-포드 알고리즘
public class 타임머신 {
    static final int INF = 1000000000;
    static List<Node> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            graph.add(new Node(a, b, c));
        }

        if (!bellmanford(n, m, 1)) {
            System.out.println(-1);
        }
    }

    private static boolean bellmanford(int n, int m, int start) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Node cur = graph.get(j);

                if (dist[cur.v] != INF && dist[cur.w] > dist[cur.v] + cur.cost) {
                    dist[cur.w] = dist[cur.v] + cur.cost;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            Node cur = graph.get(i);

            if (dist[cur.v] != INF && dist[cur.w] > dist[cur.v] + cur.cost) {
                return false;
            }
        }

        //출력
        for (int i = 2; i < dist.length; i++) {
            if (dist[i] == INF) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }

        return true;
    }

    static class Node implements Comparable<Node>{
        int v, w, cost;

        public Node(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
