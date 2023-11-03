package pgs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Pgs_118667 {

    public int solution(int[] queue1, int[] queue2) {
        LinkedList<Integer> queueOne = new LinkedList();
        LinkedList<Integer> queueTwo = new LinkedList();
        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            queueOne.add(queue1[i]);
            sum1 += queue1[i];
            queueTwo.add(queue2[i]);
            sum2 += queue2[i];
        }

        int result = 0;
        long tot = sum1 + sum2;
        while (sum1 != sum2) {

            if (result > (queue1.length + queue2.length) * 2) return -1;

            int offeredValue = 0;
            if (sum1 > sum2) {
                offeredValue = queueOne.poll();
                queueTwo.offerLast(offeredValue);
                sum1 -= offeredValue;
                sum2 += offeredValue;
            } else if (sum2 > sum1) {
                offeredValue = queueTwo.poll();
                queueOne.offerLast(offeredValue);
                sum2 -= offeredValue;
                sum1 += offeredValue;
            } else {
                return result;
            }

            result++;
        }
        return result;
    }

    public static void main(String[] args) {
//        new Pgs_118667().solution(new int[]{1, 4}, new int[]{4, 8});
        new Pgs_118667().solution(new int[]{101, 100}, new int[]{102, 103});
    }
}
