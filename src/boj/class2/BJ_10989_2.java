package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj_10989_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * Counting 정렬
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] counting = new int[10001];
		int[] result = new int[N];
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			counting[num]++;
		}
		
		//누적합
		for(int i=1; i<counting.length; i++) {
			counting[i] += counting[i-1];
		}
		
		for(int i=arr.length-1; i>=0; i--) {
			counting[arr[i]]--;
			result[counting[arr[i]]] = arr[i];
		}
		
		for(int i=0; i<result.length; i++)
			bw.append(result[i] + "\n");
		
		bw.flush();
		bw.close();
		

	}
}
