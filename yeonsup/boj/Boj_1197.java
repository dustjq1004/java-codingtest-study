package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1197 {
    static int vertexCnt, edgeCnt;
    static int[] parents;
    static List<Node> nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        vertexCnt = Integer.parseInt(token.nextToken());
        edgeCnt = Integer.parseInt(token.nextToken());

        parents = new int[vertexCnt + 1];
        nodeList = new ArrayList<>();

        for(int i = 0; i < edgeCnt; i++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());

            // from -> to 에 대한 가중치 간선을 저장
            nodeList.add(new Node(from, to, cost));
        }

        // 가중치 기준으로 오름차순 정렬
        Collections.sort(nodeList);

        make();

        int sum = 0;
        int cnt = 0;

        for (Node node: nodeList) {
            if (union(node.from, node.to)) {
                sum += node.cost;
                cnt++;

                if (cnt == edgeCnt - 1) break;
            }
        }

        System.out.println(sum);
    }

    private static boolean union(int from, int to) {
        int fromRoot = findSet(from);
        int toRoot = findSet(to);

        if (fromRoot == toRoot) return false;
        else parents[toRoot] = fromRoot;
        return true;
    }

    private static int findSet(int vertex) {
        if (parents[vertex] == vertex) return vertex;
        else return parents[vertex] = findSet(parents[vertex]);
    }

    private static void make() {
        for (int i = 1; i <= vertexCnt; i++) {
            parents[i] = i;
        }
    }

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int cost;

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
