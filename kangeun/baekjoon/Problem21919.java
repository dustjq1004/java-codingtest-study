import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Problem21919 {

	public static void main(String[] args) throws IOException{
		BigInteger result = new BigInteger("1");
		BigInteger one = new BigInteger("1");
		BigInteger zero = new BigInteger("0");

		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		br.close();
		

		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(str[i]);
			boolean check = true;
			for(int j=2; j<=Math.sqrt(num); j++) {
				if(num%j==0) {
					check=false;
					break;
				}
			}
			
			if(check &&(
					result.compareTo(one)==0 ||
					result.remainder(new BigInteger(str[i])).compareTo(zero)!=0)) {
				result = result.multiply(new BigInteger(str[i]));
			}
			
		}
		
		if(result.compareTo(new BigInteger("1"))==0) {
			result = new BigInteger("-1");
		}
		//output
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(result.toString());
		bw.flush();
		bw.close();
		

	}

}
