package pgs;

import java.util.HashSet;

public class Pgs_150369 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliveryCnt = 0;
        int pickupCnt = 0;
        long[] dp = new long[n + 1];
        int cnt = 0;

        for (int i = n - 1; i >= 0; i--) {
            int delivery = deliveries[i];
            int pickup = pickups[i];
            deliveryCnt += delivery;
            pickupCnt += pickup;

            int a = (deliveryCnt / cap) + (deliveryCnt % cap == 0 ? 0 : 1);
            int b = (pickupCnt / cap) + (pickupCnt % cap == 0 ? 0 : 1);

            dp[i] = (i + 1) * 2 * (Math.max(a, b) - cnt) + dp[i + 1];

            cnt = Math.max(a, b);
        }
        answer = dp[0];
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        new Pgs_150369().solution(4, 5,
                    new int[] {1, 0, 3, 1, 2},
                    new int[] {0, 3, 0, 4, 0}
                );
        new Pgs_150369().solution(2, 7,
                    new int[] {1, 0, 2, 0, 1, 0, 2},
                    new int[] {0, 2, 0, 1, 0, 2, 0}
                );
        new Pgs_150369().solution(4, 2,
                    new int[] {3, 5},
                    new int[] {1, 2}
                );
        new Pgs_150369().solution(4, 5,
                    new int[] {1,1,1,1,1},
                    new int[] {1,1,1,1,1}
                );
    }
}


// 물류 창고 길이를 이동할 길이를 줄인다?
// 끝에 있는 것 부터 해결한다.
// 중간에 있는 택배를 먼저 해결해도 어차피 이동해야할 거리는 줄어들지 않음.
// cap = 4, 택배상자 + 빈상자
// 해결할 수 있는 택배상자 = 들고 온 택배상자 -> 어차피 끝 까지 이동하면 cap은 비어있음.
//
// 이동거리, 택배 배달/수거
// 수거 총 개수, 배달 총 개수
// -> 배달, <- 수거
//
// 1/0 0/3 3/4 1/4 2/4
/*
    1/0 0/3 2/4 0/4 0/0
                1.1 1.1

    1/0 0/3 0/4 0/0 0/0
    0/0 0/3 0/0 0/0 0/0
    0/0 0/0 0/0 0/0 0/0

    1/0	0/3	3/0	1/4	2/0
    배달 = 7, 수거 = 7 14 / 4 = 왕복 2번
    왕복 횟수 마다의 최소 거리



    1/0	0/3	3/0	1/4	2/4
                1/2 1/1

*/