package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1920 {

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
			int min = 0;
			int max = A_arr.length-1;
			int num = M_arr[i];
			boolean numCheck = false;
			
			while(min <= max) {
				int mid = (max + min) / 2;
				
				if(num < A_arr[mid]) {
					max = mid - 1;
				} else if(num > A_arr[mid]) {
					min = mid + 1;
				} else {
					numCheck = true;
					break;
				}
			}
			
			if(numCheck)
				System.out.println("1");
			else
				System.out.println("0");
			
		}
		
		
	}

}
