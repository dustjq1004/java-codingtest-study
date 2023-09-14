/*
 * ���� 1149��: RGB�Ÿ�
 * �˰��� �з�: #dp
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
		cost = new int[N][3];	// 0 -> ����, 1-> �ʷ�, 2-> �Ķ�
		dp = new int[N][3];
				
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<3; i++) {	// ó�� ���� ����, �ʷ�, �Ķ��� �� ������ �ּҰ��� ���ؼ� ���� ���� ���� ���� ����
			int temp = minCost(i, 0);
			if(temp < min) {
				min = temp;
			}
		}
		
        System.out.println(min);
	}
	
	public static int minCost(int color, int depth) {	
		int result = 0;
		if(depth >= N-1) {	// ������ ���� �����ϸ� �� ���� �ش� �÷��� ���� return
			return cost[depth][color];
		}
		if(dp[depth][color] != 0) {
			result = dp[depth][color];
		}
		else if(color == 0) {	// ���� ���� ������ ��� + �������� �ʷϻ�, �Ķ����� �� �߻��ϴ� �Ѻ�� �� �ּҰ��� ����
			dp[depth][0] = cost[depth][0] + Math.min(minCost(1, depth+1), minCost(2, depth+1));
			result = dp[depth][0];
		}
		else if(color == 1) {	// �ʷ�
			dp[depth][1] = cost[depth][1] + Math.min(minCost(0, depth+1), minCost(2, depth+1));
			result = dp[depth][1];
		}
		else if(color == 2) {	// �Ķ�
			dp[depth][2] = cost[depth][2] + Math.min(minCost(0, depth+1), minCost(1, depth+1));
			result = dp[depth][2];
		}
		return result;
	}
}