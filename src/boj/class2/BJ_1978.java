package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1978 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			int checkNum = 0;
			
			if(num == 1)
				continue;
			
			for(int i=2; i<=Math.sqrt(num); i++) {
				if(num % i == 0) {
					checkNum++;
					break;
				}
			}
			
			if(checkNum == 0)
				count++;
		}
		System.out.println(count);
	}

}
