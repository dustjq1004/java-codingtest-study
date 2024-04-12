package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 도시분할계획 {
    static int n, m;
    static List<Node> nodeList;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        parent = new int[n + 1];
        nodeList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());

            nodeList.add(new Node(from, to, cost));
        }

        Collections.sort(nodeList);

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int sum = 0;
        int cnt = 0;

        for (Node node : nodeList) {
            if (cnt == n - 2) break;
            if (union(node.from, node.to)) {
                sum += node.cost;
                cnt++;
            }
        }

        System.out.println(sum);
    }

    private static boolean union(int from, int to) {
        int fromNode = findSet(from);
        int toNode = findSet(to);

        if (fromNode == toNode) return false;
        else parent[toNode] = fromNode;
        return true;
    }

    private static int findSet(int vertex) {
        if (parent[vertex] == vertex) return vertex;
        else return parent[vertex] = findSet(parent[vertex]);
    }

    static class Node implements Comparable<Node> {
        int from, to, cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
