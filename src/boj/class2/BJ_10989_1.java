package boj.class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BJ_10989_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * Arrays.sort : Dual-Pivot Quicksort
		 * Collections.sort : 오브젝트정렬
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		
		Arrays.sort(arr);
		
		for(int i : arr)
			bw.write(i + "\n");
		bw.flush();
		bw.close();
	}
}
