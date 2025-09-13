package boj.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1931_회의실배정 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			int[][] meeting = new int[n][2];
			
			StringTokenizer st;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				meeting[i][0] = Integer.parseInt(st.nextToken());
				meeting[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(meeting, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] == o2[1]) {
						return o1[0] - o2[0];
					}
					
					return o1[1] - o2[1];
				}
			});
			
			int count = 0;
			int endTime = 0;
			
			for(int i=0; i<meeting.length; i++) {
				if(meeting[i][0] < endTime) continue;
				
				count++;
				endTime = meeting[i][1];
			}
			
			System.out.println(count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
