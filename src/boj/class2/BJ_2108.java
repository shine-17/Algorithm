package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class bj_2108 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double sum = 0;
		int arr[] = new int[n];
		int modeAmArr[] = new int[4001];
		int modeNeArr[] = new int[4001];
		
		for(int i=0; i<n; i++) {
			int m = Integer.parseInt(br.readLine());
			arr[i] = m;
			sum += m;
		}
		
		long arithmeticMean = (Math.round(sum/ n)); //산술평균
		Arrays.sort(arr);
		int median = arr[arr.length/2]; //중앙값
		
		int mode=0; //최빈값
		int range=0; //범위
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] >= 0) {
				modeAmArr[arr[i]]++;
			} else {
				modeNeArr[Math.abs(arr[i])]++;
			}
		}
		
		int countMax = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//양수배열
		for(int i=0; i<modeAmArr.length; i++) {
			if(modeAmArr[i] > countMax) {
				countMax = modeAmArr[i];
			}
			if(modeAmArr[i] > 0 && i > max)
				max = i;
			if(modeAmArr[i] > 0 && i < min)
				min = i;
		}
		
		//음수배열
		for(int i=0; i<modeNeArr.length; i++) {
			if(modeNeArr[i] > countMax) {
				countMax = modeNeArr[i];
				max = -i;
			}
			if(modeNeArr[i] > 0 && -i > max)
				max = -i;
			if(modeNeArr[i] > 0 && -i < min)
				min = -i;
		}
		
		for(int i=0; i<modeAmArr.length; i++) {
			if(modeAmArr[i] == countMax)
				list.add(i);
		}
		for(int i=0; i<modeNeArr.length; i++) {
			if(modeNeArr[i] == countMax)
				list.add(-i);
		}
		
		Collections.sort(list);
		
		if(list.size() > 1) {
			mode = list.get(1);
		} else {
			mode = list.get(0);
		}
		
		range = max - min;
		
		System.out.println(arithmeticMean);
		System.out.println(median);
		System.out.println(mode);
		System.out.println(range);

	}

}
