package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class bj_10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<k; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0 && stack.size() > 0)
				stack.pop();
			else
				stack.add(num);
		}
		
		int sum = 0;
		
		Iterator iter = stack.iterator();
		
		while(iter.hasNext())
			sum += stack.pop();

		System.out.println(sum);
	}
}
