package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Bus implements Comparable<Bus>{
    int dest;
    int cost;

    Bus (int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public int compareTo(Bus o) {
        return cost - o.cost;
    }
}

public class Boj_11779 {

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Bus>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Bus(dest, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int sPoint = Integer.parseInt(st.nextToken());
        int dPoint = Integer.parseInt(st.nextToken());

        int[] root = new int[n + 1];
        int[] temp = new int[n + 1];
        Arrays.fill(temp, Integer.MAX_VALUE);

        PriorityQueue<Bus> q = new PriorityQueue<>();
        temp[sPoint] = 0;
        root[sPoint] = 0;
        q.offer(new Bus(sPoint, 0));

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Bus bus = q.poll();
            if (bus.dest == dPoint) {
                break;
            }


            for (int i = 0; i < list[bus.dest].size(); i++) {
                int dest = list[bus.dest].get(i).dest;
                int cost = list[bus.dest].get(i).cost;

                if (temp[dest] > temp[bus.dest] + cost) {
                    temp[dest] = temp[bus.dest] + cost;
                    q.offer(new Bus(dest, temp[dest]));
                    root[dest] = bus.dest;
                }

            }
        }

        sb.append(temp[dPoint] + "\n");

        ArrayList<Integer> route = new ArrayList<>();
        int find = dPoint;
        while (find != 0) {
            route.add(find);
            find = root[find];
        }

        sb.append(route.size() + "\n");

        for (int i = route.size() - 1; i >= 0; i--) {
            sb.append(route.get(i) + " ");
        }

        System.out.println(sb);
    }
}
