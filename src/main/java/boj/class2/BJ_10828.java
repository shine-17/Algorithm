package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			
			switch (command) {
			case "push":
				int value = Integer.parseInt(st.nextToken());
				stack.push(value);
				
				break;

			case "pop":
				if(stack.isEmpty())
					System.out.println("-1");
				else
					System.out.println(stack.pop());
				
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if(stack.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
				
				break;
			case "top":
				if(stack.isEmpty())
					System.out.println("-1");
				else
					System.out.println(stack.peek());
				
				break;
			}
		}
		

		
	}

}
