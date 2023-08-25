import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
public class Problem5547  {
	static int[][]map;
	static boolean[][]check;
	static int row;
	static int col;
	
	//i가 짝수일 경우 인접한 위치 {(i-1, j), (i, j-1), (i, j+1), (i+1, j-1), (i+1, j), (i+1, j+1)}
	//i가 홀수일 경우 인접한 위치 {(i+1, j), (i, j-1), (i, j+1), (i-1, j-1), (i-1, j), (i-1, j+1)}
			
	static int[][] dir = {{-1,-1},{-1, 0},{0,-1},{0,1},{1,-1},{1,0}};
	
	static class Index{
		int x;
		int y;
		Index(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp= br.readLine().split(" ");
		row = Integer.parseInt(tmp[1]);
		col = Integer.parseInt(tmp[0]);
		map = new int[row][col];
		check = new boolean[row][col];
		for(int i=0; i<row; i++) {
			tmp = br.readLine().split(" ");
			for(int j=0; j<col; j++) {
				map[i][j] = tmp[j].compareTo("0");
			}
		}
		
		
		br.close();
				
		//solution
		int answer=dfs();

		// output 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(""+answer);
		bw.flush();
		bw.close();
		
		
	}
	static int dfs() {
		int answer =0;
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(check[i][j]) { //이미 지나간 자리는 skip
					continue; 
				}

				LinkedList<Index> ls = new LinkedList<>();				
				int idx = 0;
				boolean checkEdge = false;

				ls.offer(new Index(i, j));					
				check[i][j]=true;
				
				while(idx<ls.size()) {
					Index si = ls.get(idx++);			
					int dct = (si.x%2==0)?-1:1;
					
					for(int[]d: dir) {
						int x= si.x+d[0];
						int y= si.y+(d[1]*dct);
					
						if((x<0||x==row||y<0||y==col)&&map[si.x][si.y]==0) {
							checkEdge = true;
							continue;
						}
						if(x<0||x==row||y<0||y==col) {
							continue;
						}

						//인접한 벽이 같은 색이면 count에서 제외
						if(map[x][y]==map[si.x][si.y]&&!check[x][y]) {
							check[x][y] = true;
							ls.add(new Index(x, y));
						}
					}
					
				}
				
				//1의 집합일 경우 Wall 구하
				if(map[i][j]==1) {
					answer +=getLength(ls);
					System.out.println("one:"+getLength(ls));
				}else if(!checkEdge){ //0일 경우 1 안에 있는 경
					answer -=getLength(ls);
					System.out.println("zero:"+getLength(ls));
				}

			}
		}
		
		return answer;		
	}
	
	static int getLength(LinkedList<Index>ls) {
		int answer = 0;
		int idx = 0;
		while(idx<ls.size()) {
			Index si = ls.get(idx++);
			int dct = (si.x%2==0)?-1:1;
			
			//총 벽면 수 add
			answer += 6;
			
			for(int[]d: dir) {
				int x= si.x+d[0];
				int y= si.y+d[1]*dct;
				
				if(x<0||x==row||y<0||y==col) {
					continue;
				}

				//인접한 벽이 같은 색이면 count에서 제외
				if(map[x][y]==map[si.x][si.y]) {
					answer-=1;
				}
			}
		}
		return answer;
	}

}
