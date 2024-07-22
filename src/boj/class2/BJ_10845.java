package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
			case "push":
				int value = Integer.parseInt(st.nextToken());
				queue.add(value);
				
				break;
			case "pop":
				if(queue.isEmpty())
					System.out.println("-1");
				else
					System.out.println(queue.pop());
				
				break;
			case "size":
				System.out.println(queue.size());
				
				break;
			case "empty":
				if(queue.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
				
				break;
			case "front":
				if(queue.isEmpty())
					System.out.println("-1");
				else
					System.out.println(queue.peek());
				
				break;
			case "back":
				if(queue.isEmpty())
					System.out.println("-1");
				else
					System.out.println(queue.peekLast());
				
				break;
			}
		}
		

	}

}
