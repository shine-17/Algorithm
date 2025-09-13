package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10250 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트 케이스
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); //호텔의 층수
			int W = Integer.parseInt(st.nextToken()); //각 층의 방 수
			int N = Integer.parseInt(st.nextToken()); //몇번째 손님인지
			
			String roomNum = null;
			int count = 0;
			
			for(int j=0; j<W; j++) {
				for(int k=0; k<H; k++) {
					count++;
					
					if(count == N) {
						roomNum = String.valueOf(k+1) + (j+1 < 10 ? "0" + String.valueOf(j+1) : String.valueOf(j+1));
						break;
					}
				}
				
				if(count == N)
					break;
			}
			
			System.out.println(roomNum);
		}
	}

}
