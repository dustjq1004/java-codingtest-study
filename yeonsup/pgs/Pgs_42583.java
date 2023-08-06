package pgs;

import java.util.*;
import java.util.List;

class Truck {
    int m;
    int w;

    public Truck(int w) {
        this.m = 0;
        this.w = w;
    }
}

public class Pgs_42583 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int limit = 0;

        Deque<Integer> waiting = new LinkedList<>();
        Deque<Truck> bridge = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            waiting.offer(truck_weights[i]);
        }

        while (!waiting.isEmpty() || !bridge.isEmpty()) {

            for (Truck truck : bridge) {
                truck.m++;
            }

            if(!bridge.isEmpty() && bridge.getFirst().m >= bridge_length) {
                limit -= bridge.getFirst().w;
                bridge.poll();
            }

            if(!waiting.isEmpty()) {
                if (limit + waiting.getFirst() <= weight) {
                    limit += waiting.getFirst();
                    bridge.add(new Truck(waiting.poll()));
                }
            }
            time++;
        }


        return time;
    }
    public static void main(String[] args) {
        Pgs_42583 problem = new Pgs_42583();
        System.out.println(problem.solution(2, 10, new int[] {7,4,5,6}));
        System.out.println(problem.solution(100, 100, new int[] {10}));
        System.out.println(problem.solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10}));
    }
}
