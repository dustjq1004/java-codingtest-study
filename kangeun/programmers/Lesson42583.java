import java.util.LinkedList;
import java.util.Queue;

class Lesson42583 {
    private Queue<Integer> queue;
    
    private int time;
    private int sum;
    private int end;
    
    Lesson43583(){
        this.queue = new LinkedList<>();
        this.time = 1;
        this.sum = 0;
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int size = truck_weights.length;
        int sidx = 0;
        int eidx = 0;
        while(sidx<size){
            if(queue.size()==0){
                insert(truck_weights[sidx++], bridge_length);
            }
            int maxt= queue.poll();
            while(sidx<size &&time<maxt){
                if(sum+truck_weights[sidx]<=weight&&time<maxt){
                    insert(truck_weights[sidx++], bridge_length);
                }else{
                    time++;
                }                
            }
            time=maxt;
            delete(truck_weights[eidx++], maxt);            
        }
        
        while(queue.size()>0){
            time = queue.poll();
            delete(truck_weights[eidx++], time);            

        }
        return time;
    }
    
    void insert(int i, int length){
        //System.out.println("offer: time:"+time+"   truck:"+ i);
        queue.offer(time+length);
        sum+=i;
        time++;
    }
    
    void delete(int i, int t){
        //System.out.println("delete: time:"+t + "   truck:"+i);
        sum-=i;
    }
}