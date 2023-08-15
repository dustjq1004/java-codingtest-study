
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
//01:26 ~
public class Problem10026 {
	static Idx[] dir = {new Idx(-1,0), new Idx(1,0), new Idx(0,-1), new Idx(0, 1)};
	static String[][]arr;
	static int n;
	static boolean[][] check;
	static boolean[][] check2;
	static class Idx{
		int x;
		int y;
		String v;
		Idx(int x, int y){
			this.x = x;
			this.y = y;
		}		
	}
	public static void main(String[] args) throws IOException {
		int answer = 0;
		int answer2 = 0;
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new String[n][n];
		for(int i=0; i<n; i++) {
			arr[i]= br.readLine().split("");
		}
		br.close();
		
		check = new boolean[n][n];
		check2 = new boolean[n][n];		
		
		//bfs		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!check[i][j]) {
					bfs(i, j);
					answer++;
				}		
				if(!check2[i][j]) {
					bfs2(i, j);
					answer2++;
				}
				
			}
		}
		
		
		//output
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(answer+" "+answer2);
		bw.flush();
		bw.close();
		
	}

	//dfs
	static void bfs(int i, int j){
		Queue<Idx> que = new LinkedList<Idx>();
		que.offer(new Idx(i, j));
		while(!que.isEmpty()) {
			Idx tmp = que.poll();
			for(Idx d:dir) {
				int nx = tmp.x+d.x;
				int ny = tmp.y+d.y;
				if(nx<0||nx==n||ny<0||ny==n) {
					continue;
				}
				if(!check[nx][ny] && arr[nx][ny].compareTo(arr[tmp.x][tmp.y])==0) {						
					que.offer(new Idx(nx, ny));
					check[nx][ny]=true;
				}
				
			}
		}
	}
	
	static void bfs2(int i, int j) {
		Queue<Idx> que = new LinkedList<Idx>();
		que.offer(new Idx(i, j));
		while(!que.isEmpty()) {
			Idx tmp = que.poll();
			for(Idx d:dir) {
				int nx = tmp.x+d.x;
				int ny = tmp.y+d.y;
				if(nx<0||nx==n||ny<0||ny==n) {
					continue;
				}
				if(!check2[nx][ny]&&arr[nx][ny].compareTo("B")==0&arr[tmp.x][tmp.y].compareTo("B")==0) {						
					que.offer(new Idx(nx, ny));
					check2[nx][ny]=true;
				}else if(!check2[nx][ny]&&arr[nx][ny].compareTo("B")!=0&arr[tmp.x][tmp.y].compareTo("B")!=0) {						
					que.offer(new Idx(nx, ny));
					check2[nx][ny]=true;
				}
				
			}
		}

	}
}
