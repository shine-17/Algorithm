package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_10816_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nArr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<nArr.length; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] mArr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<mArr.length; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nArr);
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<mArr.length; i++) {
			int num = mArr[i];
			
			sb.append(upperBound(nArr, num) - lowerBound(nArr, num) + " ");
		}
		
		String output = sb.substring(0, sb.length()-1);
		System.out.println(output);
 	}
	
	//이분탐색 하한
	public static int lowerBound(int[] arr, int key) {
		int low = 0;
		int high = arr.length;
		
		while(low < high) {
			int mid = (low + high) / 2;
			
			if(key <= arr[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		
		return low;
	}
	
	//이분탐색 상한
	public static int upperBound(int[] arr, int key) {
		int low = 0;
		int high = arr.length;
		
		while(low < high) {
			int mid = (low + high) / 2;
			
			if(key < arr[mid]) {
				high = mid;
			} else {
				low = mid+1;
			}
		}
		
		return low;
	}
}
