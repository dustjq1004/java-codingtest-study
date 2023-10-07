/*
    프로그래머스 Lv2
    Title: 택배 배달과 수거하기
 */

import java.util.Stack;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> delivery = new Stack<>();
        Stack<Integer> pickup = new Stack<>();

        // deliveries와 pickups 배열에 담긴 정보를 각각 스택에 저장
        for (int i = 0; i < n; i++) {
            delivery.push(deliveries[i]);
            pickup.push(pickups[i]);
        }

        // 두 스택이 모두 비었으면 종료
        while (!delivery.isEmpty() || !pickup.isEmpty()) {
            // 스택 상단에 있는 0을 모두 제거
            removeZero(delivery, pickup);
            // 두 스택 중 길이가 더 긴 스택의 길이만큼 왕복해서 이동함
            answer += Math.max(delivery.size(), pickup.size()) * 2L;
            // 각 스택에서 택배 상자의 최대 개수(cap)를 뺌
            clear(cap, delivery);
            clear(cap, pickup);
        }

        return answer;
    }

    public static void clear(int cap, Stack<Integer> stack) {
        // 입력받은 스택의 상단에서부터 택배 상자의 최대 개수(cap)가 0이 될 때까지 뺌
        while (!stack.isEmpty() && cap != 0) {
            if(cap - stack.peek() < 0) {
                stack.push(stack.pop() - cap);
                cap = 0;
            } else {
                cap -= stack.pop();
            }
        }
    }

    // 트럭이 이동할 거리를 정확히 계산하기 위해 스택 상단의 0을 모두 제거함
    public static void removeZero(Stack<Integer> del, Stack<Integer> pic) {
        while (!del.isEmpty() && del.peek() == 0) {
            del.pop();
        }

        while (!pic.isEmpty() && pic.peek() == 0) {
            pic.pop();
        }
    }
}