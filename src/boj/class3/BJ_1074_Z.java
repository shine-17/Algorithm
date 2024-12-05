package boj.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074_Z {
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken()); //행
		int c = Integer.parseInt(st.nextToken()); //열
		int size = (int) (Math.pow(2, N)); //한 변의 사이즈
		
		z_Search(size, r, c);
		System.out.println(count);
		
//		Runtime.getRuntime().gc();
//		long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//		System.out.print(usedMemory + " bytes");
	}

	private static void z_Search(int size, int r, int c) {
		if(size == 1)
			return;
		
		if(r < size/2 && c < size/2) { //1사분면
			z_Search(size/2, r, c);
		} else if(r < size/2 && c >= size/2) { //2사분면
			count += (int) (Math.pow(size, 2) / 4);
			z_Search(size/2, r, c - size/2);
		} else if(r >= size/2 && c < size/2) { //3사분면
			count += (int) (Math.pow(size, 2) / 4) * 2;
			z_Search(size/2, r - size/2, c);
		} else { //4사분면
			count += (int) (Math.pow(size, 2) / 4) * 3;
			z_Search(size/2, r - size/2, c - size/2);
		}
	}
	
}
