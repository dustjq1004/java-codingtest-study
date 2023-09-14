/*
 * 백준 1149번: RGB거리
 * 알고리즘 분류: #dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] cost;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];	// 0 -> 빨강, 1-> 초록, 2-> 파랑
		dp = new int[N][3];
				
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<3; i++) {	// 처음 집이 빨강, 초록, 파랑일 때 각각의 최소값을 구해서 그중 가장 작은 값을 저장
			int temp = minCost(i, 0);
			if(temp < min) {
				min = temp;
			}
		}
		
        System.out.println(min);
	}
	
	public static int minCost(int color, int depth) {	
		int result = 0;
		if(depth >= N-1) {	// 마지막 집에 도착하면 그 집의 해당 컬러의 값을 return
			return cost[depth][color];
		}
		if(dp[depth][color] != 0) {
			result = dp[depth][color];
		}
		else if(color == 0) {	// 현재 집의 빨강색 비용 + 다음집이 초록색, 파랑색일 때 발생하는 총비용 중 최소값을 더함
			dp[depth][0] = cost[depth][0] + Math.min(minCost(1, depth+1), minCost(2, depth+1));
			result = dp[depth][0];
		}
		else if(color == 1) {	// 초록
			dp[depth][1] = cost[depth][1] + Math.min(minCost(0, depth+1), minCost(2, depth+1));
			result = dp[depth][1];
		}
		else if(color == 2) {	// 파랑
			dp[depth][2] = cost[depth][2] + Math.min(minCost(0, depth+1), minCost(1, depth+1));
			result = dp[depth][2];
		}
		return result;
	}
}