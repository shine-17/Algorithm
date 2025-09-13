package boj.class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_11651 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] coordinateArr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			coordinateArr[i][0] = Integer.parseInt(st.nextToken());
			coordinateArr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(coordinateArr, new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				else
					return o1[1] - o2[1];
			}
		});

		for(int i=0; i<coordinateArr.length; i++)
			bw.append(coordinateArr[i][0] + " " + coordinateArr[i][1]+"\n");

		bw.flush();
		bw.close();
	}

}
