zpackage boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_1260 {

    private static int[][] graph;
    private static boolean[] visited;
    private static Deque<Integer> queue =  new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            graph[vertex][target] = 1;
            graph[target][vertex] = 1;
        }

        StringBuilder sb = new StringBuilder();

        dfs(sb, start);
        sb.append("\n");

        visited = new boolean[n + 1];
        bfs(sb, start);

        System.out.println(sb.toString());
    }

    private static void dfs(StringBuilder sb, int start) {
        sb.append(start);
        sb.append(" ");
        visited[start] = true;
        for (int i = 0; i < graph[start].length; i++) {
            int trunk = graph[start][i];
            if (trunk == 1 && !visited[i]) {
                dfs(sb, i);
            }
        }
    }

    private static void bfs(StringBuilder sb, int start) {
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            sb.append(vertex);
            sb.append(" ");
            for (int i = 1; i < graph[vertex].length; i++) {
                if (graph[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
