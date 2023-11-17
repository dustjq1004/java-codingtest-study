package pgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pgs_49189 {

    public static void main(String[] args) {
        System.out.println(new Pgs_49189().solution(6, new int[][]{
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
        }));
    }

    public int solution(int n, int[][] edge) {
        List<Deque<Integer>> vertexs = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            vertexs.add(new LinkedList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            Deque<Integer> trunks = vertexs.get(edge[i][0]);
            trunks.add(edge[i][1]);
            vertexs.set(edge[i][0], trunks);

            Deque<Integer> trunks2 = vertexs.get(edge[i][1]);
            trunks2.add(edge[i][0]);
            vertexs.set(edge[i][1], trunks2);
        }
        return new Graph(vertexs).bfs();
    }
}

class Graph {

    private List<Deque<Integer>> vertexs;
    private boolean[] visited;
    
    public Graph(List<Deque<Integer>> vertexs) {
        this.vertexs = vertexs;
        visited = new boolean[vertexs.size()]; 
    }
    
    public int bfs() {
        int depth = 1;
        int[] vertexDepths = new int[vertexs.size()];
        Arrays.fill(vertexDepths, 1);
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        for (Integer vertex : vertexs.get(1)) {
            vertexDepths[vertex] = vertexDepths[vertex] + 1;
            queue.add(vertex);
            visited[vertex] = true;
        }
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            for (Integer target : vertexs.get(vertex)) {
                if (!visited[target]) {
                    queue.add(target);
                    vertexDepths[target] = vertexDepths[vertex] + 1;
                    depth = Math.max(depth, vertexDepths[target]);
                    visited[target] = true;
                }
            }
        }
        int finalDepth = depth;
        return (int) Arrays.stream(vertexDepths).filter(number -> finalDepth == number).count();
    }
}

