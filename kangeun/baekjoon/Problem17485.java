import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Problem1004 {
	
	public static void main(String[] args) throws IOException {

		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int c = Integer.parseInt(br.readLine());
		for(int i=0; i<c; i++) {
			String[] arr = br.readLine().split(" ");
			int sx = Integer.parseInt(arr[0]);
			int sy = Integer.parseInt(arr[1]);
			int ex = Integer.parseInt(arr[2]);
			int ey = Integer.parseInt(arr[3]);
			
			int circleCnt = Integer.parseInt(br.readLine());			
			int result = 0;
			
			for(int j=0; j<circleCnt; j++) {
				arr = br.readLine().split(" ");
				int x = Integer.parseInt(arr[0]);
				int y = Integer.parseInt(arr[1]);
				int radius = Integer.parseInt(arr[2]);
				if((isIn(x, y, radius, sx, sy)&&!isIn(x, y, radius, ex, ey))
						||(!isIn(x, y, radius, sx, sy)&&isIn(x, y, radius, ex, ey))) {
					result++;
				}
			}
			bw.append(""+result);
			bw.newLine();
		}
		br.close();
		bw.close();
	}
	
	static boolean isIn(int x, int y, int radius, int a, int b) {
		double distance = Math.sqrt(Math.pow(x-a, 2) + Math.pow(y-b, 2));
		if(distance-radius<0.01) {
			return true;
		}else {
			return false;
		}
	}

}
