import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Problem6603 {
	static BufferedReader bf;
	static BufferedWriter bw;
	final static int NUM = 6;
	
	public static void main(String[] args) throws IOException{
		//Input
		bf = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean running = true;
		String[] arr = null;
		while(running) {
			arr = bf.readLine().split(" ");
			boolean[] check = new boolean[arr.length];
			if(arr.length==1) {
				bf.close();
				bw.close();
				break;
			} 
			combination(arr, check, 1, 0);				
			bw.newLine();
		};
		
	}
	public static void combination(String[] arr, boolean[] check, int index, int count) throws IOException{
		if(count==NUM) {
			for(int i=1; i<arr.length; i++) {
				if(check[i]) {
					bw.append(arr[i]+" ");
				}
			}
			bw.newLine();
		}else if(count + (arr.length-index)<NUM){
			return;
		}else {
			check[index]=true;
			combination(arr, check, index+1, count+1);
			check[index]=false;
			combination(arr, check, index+1, count);
		}
		
	}

}
