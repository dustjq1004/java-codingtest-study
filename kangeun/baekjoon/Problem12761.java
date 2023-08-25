import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

//23:15
public class Problem12761 {

	public static void main(String[] args) throws IOException{
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]s = br.readLine().split(" ");
		br.close();
		
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		int dong = Integer.parseInt(s[2]);
		int joo = Integer.parseInt(s[3]);
		int answer = 0;
		Queue<Integer> que = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();
		int[] dir = {a, b, 1, -1, a*-1, b*-1};
		
		que.offer(dong);
		map.put(dong, 0);

		//solution
		while(!que.isEmpty()) {
			int idx = que.poll();
			int cnt = map.get(idx)+1;
			int nx = 0;
			for(int i=0; i<2; i++) {
				nx = idx*dir[i];
				if(nx>100000) {
					continue;
				}
				
				if(map.get(nx)==null) {
					que.offer(nx);
					map.put(nx, cnt);					
				}
			}
			
			for(int i:dir) {
				nx = idx+i;
				if(nx>100000||nx<0) {
					continue;
				}
				if(map.get(nx)==null) {
					que.offer(nx);
					map.put(nx, cnt);					
				}
			}
			
			if(map.get(joo)!=null) {
				answer = map.get(joo);
				break;
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(answer+"");
		bw.flush();
		bw.close();
		
		
	}

}
