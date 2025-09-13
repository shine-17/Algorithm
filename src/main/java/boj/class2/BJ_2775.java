package boj.class2;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class BJ_2775 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] apart = new int[k+1][n+1];
			
			for(int j=0; j<apart.length; j++) {
				for(int l=1; l<apart[j].length; l++) {
					if(j == 0) {
						apart[j][l] = l;
					} else {
						for(int m=1; m<l+1; m++) {
							apart[j][l] += apart[j-1][m];
						}
					}
				}
			}
			
			bw.append(String.valueOf(apart[k][n]) + "\n");
		}
		
		br.close();
		bw.close();
	}
}
