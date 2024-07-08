package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_7568 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> rankArr = new ArrayList<String>();
		int N = Integer.parseInt(br.readLine());
		int[][] bulk = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			bulk[i][0] = x; //몸무게
			bulk[i][1] = y; //키
		}
		
		for(int i=0; i<N; i++) {
			int bigger = 0;
			int x = bulk[i][0]; //몸무게
			int y = bulk[i][1]; //키
			
			for(int j=0; j<N; j++) {
				if(bulk[j][0] > x && bulk[j][1] > y) {
					bigger++;
				}
			}
			
			rankArr.add(String.valueOf(bigger+1));
		}
		System.out.println(String.join(" ", rankArr));
	}
}
