import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

//180분
public class Main {
	private static ArrayList<Integer> al;
	private static ArrayList<Integer> dp;

	public static void main(String[] args) throws IOException {
		int answer =0;
		
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		al = new ArrayList<>(n);
		dp = new ArrayList<>(n);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		
		
		
		//solution
		
		for(int i=0; i<n; i++) {
			al.add(Integer.parseInt(st.nextToken()));
		}
		
		
		
		for(int i=0; i<n; i++) {
			int cnt=0;
			for(int j=0; j<i; j++) {
				if(al.get(j)<=al.get(i)) {
					cnt++;
				}
			}
			for(int j=i+1; j<n; j++) {
				if(al.get(i)<=al.get(j)){
					cnt++;
				}
			}
			
			dp.add(cnt);			
		}
		
		boolean check = true;
		int size = al.size();
		
		do{
			size = al.size();
			for(int i=0; i<al.size()-1; i++) {
				if(al.get(i)<=al.get(i+1)) {
					if(dp.get(i)>=dp.get(i+1)) {
						remove(i);
					}else {
						remove(i+1);
					}
					break;
				}
			}
		}while(size>al.size()) ;
		
		//Output
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.append(""+(n-al.size()));
		bw.flush();
		bw.close();
		
	}
	static void remove(int i) {
		for(int a=0; a<i; a++) {
			if(al.get(a)<=al.get(i)) {
				dp.set(a, dp.get(a)-1);
			}
		}
		
		for(int a=i+1; a<al.size(); a++) {
			if(al.get(a)>=al.get(i)) {
				dp.set(a, dp.get(a)-1);
			}
		}
		al.remove(i);
		dp.remove(i);
	}
	
	static void print() {
		for(int i=0; i<al.size(); i++) {
			System.out.print(al.get(i) + "   ");
		}
		for(int i=0; i<al.size(); i++) {
			System.out.print(dp.get(i) + "   ");
		}
		System.out.println();
		
	}

}