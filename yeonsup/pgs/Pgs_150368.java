package pgs;

import java.util.Arrays;
import java.util.Map;

public class Pgs_150368 {


    private int[] discounts = new int[]{40, 30, 20, 10};
    private int[] discounted; // 적용된 할인 율
    private int maxUserCount = 0;
    private double maxTotPrice = 0;

    public void backtracking(int cnt, int[][] users, int[] emotions) {
        // 모든 할인율 적용 시 가입자 수와 총 가격 합계 구하는 로직
        if (cnt == emotions.length) {
            int userCount = 0;
            double totPrice = 0;

            // 할인율 값 구하는 로직
            double[] discountedEmotions = new double[emotions.length];
            for (int i = 0; i < emotions.length; i++) {
                int emoticonPrice = emotions[i];
                int discountRate = discounted[i];
                discountedEmotions[i] = (emoticonPrice * ((100 - discountRate) / 100.0));
            }
            System.out.println(Arrays.toString(discounted) + " : " + Arrays.toString(discountedEmotions));

            for (int[] user : users) {
                int userDiscountSt = user[0];
                double userPriceSt = user[1];

                int userPrice = 0;
                for (int i = 0; i < discounted.length; i++) {
                    if (discounted[i] >= userDiscountSt) {
                        userPrice += discountedEmotions[i];
                    }
                }

                if (userPrice >= userPriceSt) {
                    userCount++;
                } else {
                    totPrice += userPrice;
                }
            }

            if (maxUserCount < userCount) {
                maxUserCount = userCount;
                maxTotPrice = totPrice;
            } else if (maxUserCount == userCount) {
                maxTotPrice = Math.max(maxTotPrice, totPrice);
            }
            return;
        }

        // 할인율을 탐색할 for문
        for (int discount : discounts) {
            discounted[cnt] = discount;
            backtracking(cnt + 1, users, emotions);
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        discounted = new int[emoticons.length];

        backtracking(0, users, emoticons);
        return new int[]{maxUserCount, (int) maxTotPrice};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Pgs_150368().solution(
                new int[][] {{40, 10000}, {25, 10000}},
                new int[] {7000, 9000} )));
        System.out.println(Arrays.toString(new Pgs_150368().solution(
                new int[][] {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}},
                new int[] {1300, 1500, 1600, 4900} )));
    }
}
