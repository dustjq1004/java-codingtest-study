package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Boj_1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Queue<Long> queue = new PriorityQueue<>();

        int number = Integer.parseInt(bf.readLine());
        long sum = 0;
        long total = 0;

        for (int i = 0; i < number; i++) {
            long s = Long.parseLong(bf.readLine());
            queue.offer(s);
        }

        while (queue.size() > 1) {
            long a = queue.poll();
            long b = queue.poll();

            sum = a + b;
            total += sum;
            queue.offer(sum);
        }

        System.out.println(total);

        bf.close();
    }
}
