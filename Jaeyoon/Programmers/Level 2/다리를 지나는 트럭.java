/*
    프로그래머스 Lv2
    Title: 다리를 지나는 트럭
 */
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        // 배열을 스택으로 활용하기 위해 스택 포인터로 사용될 변수
        int sp = 0;
        // 현재 다리 위의 트럭들의 무게 합을 저장할 변수
        int c_weight = 0;
        Queue<Integer> queue = new LinkedList<>();
        // 첫 트럭을 큐에 삽입하고 시작
        c_weight += truck_weights[sp];
        queue.offer(truck_weights[sp++]);
        time++;
        // 스택에 값이 남아있는 동안 반복
        while(sp < truck_weights.length){
            // 큐의 사이즈와 다리의 길이가 같다면 큐에서 처음 값을 삭제하고 다리 위의 무게 합에서도 빼줌
            if(queue.size() == bridge_length){
                c_weight -= queue.poll();
            }
            // 다음 트럭을 추가했을 때 최대 무게를 초과하게 되면
            else if(truck_weights[sp] + c_weight > weight){
                // 스택에 0을 추가하고, time 증가
                queue.offer(0);
                time++;
            }
            // 다음 트럭을 추가했을 때 최대 무게 이내라면
            else{
                // 트럭을 큐에 추가하고, 다리 위의 무게 합에 트럭에 무게를 더해주고, time 증가
                c_weight += truck_weights[sp];
                queue.offer(truck_weights[sp++]);
                time++;
            }
        }
        // 마지막 트럭이 다리에 올라간 시점에 반복문이 종료되므로,
        // 마지막 트럭이 다리를 통과하는 시간(다리의 길이)만큼 더해주고 리턴
        return time + bridge_length;
    }
}