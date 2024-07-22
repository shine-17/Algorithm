package boj.class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_18111 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 세로 
		int M = Integer.parseInt(st.nextToken()); // 가로
		int B = Integer.parseInt(st.nextToken()); // 인벤토리의 블록개수
		int[][] blocks = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			String[] arr = br.readLine().split(" ");
			
			for(int j=0; j<arr.length; j++) {
				int value = Integer.parseInt(arr[j]);
				blocks[i][j] = value;
				
				min = Math.min(min, value);
				max = Math.max(max, value);
			}
		}
		
		int min_time = Integer.MAX_VALUE;
		int max_height = -1; //최소는 0층
		
		for(int i=min; i<=max; i++) { //최소층부터 최대층까지
			int time = 0;
			int inventory = B;
			
			for(int j=0; j<blocks.length; j++) {
				for(int k=0; k<blocks[j].length; k++) {
					int diff = blocks[j][k] - i;
					
					if(diff > 0 ) { //현재층이 더 높을때
						time += Math.abs(diff) * 2;
						inventory += Math.abs(diff);
					} else if(diff < 0) { //현재층이 더 낮을때
						time += Math.abs(diff);
						inventory -= Math.abs(diff);
					}
				}
			}
			
			if(inventory >= 0) {
				if(time <= min_time) {
					min_time = time;
					max_height = i;
				}
			}
		}
		
		bw.write(min_time + " " + max_height);
		bw.flush();
		bw.close();

	}

}
