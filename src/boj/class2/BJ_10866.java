package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> deque = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int value = 0;
			
			switch(command) {
				case "push_front":
					value = Integer.parseInt(st.nextToken());
					deque.addFirst(value);
					
					break;
				case "push_back":
					value = Integer.parseInt(st.nextToken());
					deque.addLast(value);
					
					break;
				case "pop_front":
					if(deque.isEmpty())
						System.out.println("-1");
					else
						System.out.println(deque.pollFirst());
					
					break;
				case "pop_back":
					if(deque.isEmpty())
						System.out.println("-1");
					else
						System.out.println(deque.pollLast());
					
					break;
				case "size":
					System.out.println(deque.size());
					
					break;
				case "empty":
					if(deque.isEmpty())
						System.out.println("1");
					else
						System.out.println("0");
					
					break;
				case "front":
					if(deque.isEmpty())
						System.out.println("-1");
					else
						System.out.println(deque.peekFirst());
					
					break;
				case "back":
					if(deque.isEmpty())
						System.out.println("-1");
					else
						System.out.println(deque.peekLast());
					
					break;
			}
		}

	}

}
