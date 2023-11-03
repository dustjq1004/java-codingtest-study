package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Graph {

    private static final int VISITED_TRUE = 1;
    private Map<Integer, Queue<Integer>> trunksBoard;
    private int[] visited;

    public Graph(Map<Integer, Queue<Integer>> trunksBoard, int vertexCount) {
        this.trunksBoard = trunksBoard;
        visited = new int[vertexCount + 1];
    }

    public void visitVortex(int vertex) {
        visited[vertex] = VISITED_TRUE;
    }

    public boolean isTrunk(int vertex) {
        return trunksBoard.get(vertex) != null && !trunksBoard.get(vertex).isEmpty();
    }

    public boolean isVisited(int vertex) {
        return visited[vertex] == VISITED_TRUE;
    }

    public Integer getTrunk(int vertex) {
        return trunksBoard.get(vertex).poll();
    }
}

public class Boj_11724 {
    public static int bfs(Graph graph, int startVertex) {
        Deque<Integer> queue = new ArrayDeque();
        queue.add(startVertex);
        
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            graph.visitVortex(vertex);

            while (graph.isTrunk(vertex)) {
                queue.add(graph.getTrunk(vertex));
            }
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");

        int vertexCount = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        Map<Integer, Queue<Integer>> trunksBoard = new HashMap<>(vertexCount);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int vertexNum = Integer.parseInt(st.nextToken()) - 1;
            int trunkNum = Integer.parseInt(st.nextToken()) - 1;

            addVertex(trunksBoard, vertexNum, trunkNum);
            addVertex(trunksBoard, trunkNum, vertexNum);
        }

        Graph graph = new Graph(trunksBoard, vertexCount);
        int linkCount = 0;

        for (int startVertex = 0; startVertex < vertexCount; startVertex++) {
            if (!graph.isVisited(startVertex))
                linkCount += bfs(graph, startVertex);
        }

        System.out.println(linkCount);
        bf.close();
    }

    private static void addVertex(Map<Integer, Queue<Integer>> trunksBoard, int vertexNum, int trunkNum) {
        Queue<Integer> trunks = trunksBoard.getOrDefault(vertexNum, new LinkedList<>());
        trunks.offer(trunkNum);
        trunksBoard.put(vertexNum, trunks);
    }
}
