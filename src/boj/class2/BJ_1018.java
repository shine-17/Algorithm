package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1018 {
	static boolean[][] boards;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//동전 종류의 개수
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		boards = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			
			for(int j=0; j<m; j++) {
				if(str.charAt(j) == 'W')
					boards[i][j] = true;
				else
					boards[i][j] = false;
			}
		}
		
		int x_case = n - 7;
		int y_case = m - 7;
		int min = 9999;
		
		for(int i=0; i<x_case; i++) {
			for(int j=0; j<y_case; j++) {
				int count = chessBoard(i, j);
				
				min = Math.min(count, min);
			}
		}
		
		System.out.println(min);
	}
	
	public static int chessBoard(int n, int m) {
		boolean first = boards[n][m]; 
		int count = 0;
		
		for(int i=n; i<n+8; i++) {
			for(int j=m; j<m+8; j++) {
				if(i != n || j != m) {
					if(boards[i][j] == first) {
						count++;
					}
					first = !first;
				}
			}
			first = !first;
		}
		return count;
	}
}
