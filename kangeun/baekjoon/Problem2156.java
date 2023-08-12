import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	private static final int CASE = 4;
	
	public static void main(String[] args) throws IOException {
		
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[]arr = new int [n];
		int[][]dp = new int [n][CASE];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
		}
		br.close();
		
		//Solution
		// 0응 자기 자신 안포함 dp[i-1][2] or dp[i-1][3]
		// 1은 자기 자신 안포함 연속 수 0. dp[i-1][0]
		// 2은 i-1이 0이고 연속수 (dp[i-1][0] or dp[i-1][1]) + value
		// 3는 i-1ㅣ 1이고 연속수 dp[i-1][2] + value;

		dp[0][2] = arr[0]; 
		
		
		for(int i=1; i<n; i++) {
			for(int c=0; c<CASE; c++) {
				switch(c) {
				case 0:
					dp[i][c] = Math.max(dp[i-1][2], dp[i-1][3]);
					break;
				case 1:
					dp[i][c] = dp[i-1][0];
					break;
				case 2: 
					dp[i][c] = Math.max(dp[i-1][0], dp[i-1][1])+arr[i];
					break;
				case 3: 
					dp[i][c] = dp[i-1][2] + arr[i];
					break;
				}
			}
		}
		int answer = 0;
		
		for(int i:dp[n-1]) {
			answer = Math.max(answer, i);
		}
		//Output
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(""+answer);
		bw.flush();
		bw.close();
	}

}