/*
 * ���� 1931��: ȸ�ǽ� ����
 * �˰��� �з�: #���� #�׸��� �˰���
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// time[N][0] -> ���۽ð� / time[N][1] -> ����ð�
		int[][] time = new int[N][2];
				
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// ������ �ð� �������� �������� ����. ������ �ð��� �����ϸ� ���� �ð� �������� �������� ����
		Arrays.sort(time, (start, end) -> start[1] == end[1] ? start[0] - end[0] : start[1] - end[1]);
		int end = -1;
		int cnt = 0;

		for (int i = 0; i < time.length; i++) {
			// ȸ�� ���۽ð��� ������ ȸ�� ����ð�(end)���� ũ�ų� ������(ȸ�� ������ �����ϸ�)
			if (end <= time[i][0]) {
				// ������ ȸ�� ����ð�(end)�� ���� ȸ�� ����ð����� ����
				end = time[i][1];
				// ȸ�� Ƚ��(cnt) ����
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}