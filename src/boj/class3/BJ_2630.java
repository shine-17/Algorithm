package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630 {
	
	private static int[][] confetti;
	
	private static int white_count, blue_count;

	public static void main(String[] args) {
		
	
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			
			confetti = new int[n][n];
			StringTokenizer st = null;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int j = 0;
				while(st.hasMoreTokens()) {
					confetti[i][j++] = Integer.parseInt(st.nextToken());
				}
			}
			
			cutConfetti(0, 0, n);
			
			System.out.println(white_count);
			System.out.println(blue_count);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void cutConfetti(int x, int y, int length) {
		
		if(isMatchColor(x, y, length)) {
			if(confetti[x][y] == 1) blue_count++;
			else white_count++;
		} else {
			if(length == 2) {
				
				for(int i=x; i<x + length; i++) {
					for(int j=y; j<y + length; j++) {
						if(confetti[i][j] == 1) blue_count++;
						else white_count++;
					}
				}
					
			} else {
				
				length = length / 2;
				
				// 왼쪽상단
				cutConfetti(x, y, length);
				
				// 왼쪽하단
				cutConfetti(x, y + length, length);
				
				// 오른쪽상단
				cutConfetti(x + length, y, length);
				
				// 오른쪽 하단
				cutConfetti(x + length, y + length, length);
			}
		}
	}
	
	
	public static boolean isMatchColor(int x, int y, int length) {
		int n = confetti[x][y];
		
		for(int i=x; i<x + length; i++) {
			for(int j=y; j<y + length; j++) {
				if(n != confetti[i][j]) return false;
			}
		}
		
		return true;
	}

}
