package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] A_arr = new int[n];
		for(int i=0; i<A_arr.length; i++) {
			A_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] M_arr = new int[m];
		for(int i=0; i<M_arr.length; i++) {
			M_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A_arr);
		
		for(int i=0; i<M_arr.length; i++) {
			if(Arrays.binarySearch(A_arr, M_arr[i]) >= 0) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
	}

}
