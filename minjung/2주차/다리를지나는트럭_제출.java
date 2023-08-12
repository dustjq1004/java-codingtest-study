package week2;

import java.util.ArrayList;

public class 다리를지나는트럭_제출 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;

        ArrayList<int[]> moving = new ArrayList<>();
        ArrayList<Integer> passed = new ArrayList<>();
        int total_weight = 0;
        int truck = 0;

        while(passed.size() < truck_weights.length){
            for(int i=0; i<moving.size(); i++){
                if(time - moving.get(i)[1] == bridge_length){
                    System.out.println("** 통과한 차:"+moving.get(i)[0]);
                    passed.add(moving.get(i)[0]);
                    total_weight = total_weight - moving.remove(i)[0];
                }
            }
            if(truck<truck_weights.length &&
                    moving.size()<bridge_length
                    && (total_weight+truck_weights[truck])<=weight){
                moving.add(new int[]{truck_weights[truck],time});
                total_weight+=truck_weights[truck];
                truck++;
            }
            time++;
        }
        return time;

    }

}

