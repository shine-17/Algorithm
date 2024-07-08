package class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class bj_5430 {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			
			// 테스트 케이스 실행
			for(int i=0; i<T; i++) {
				// 수행할 함수
				String p = br.readLine();
				// 배열 길이
				int n = Integer.parseInt(br.readLine());
				boolean isReverse = false;
				boolean isError = false;
				
				try {
					Deque<Integer> deque = new LinkedList<Integer>();
					
					String[] inputArr = br.readLine().replaceAll("[\\[|\\]]", "").split(",");
					for(String str : inputArr) {
						try {
							deque.add(Integer.parseInt(str));
						} catch (Exception e) {}
					}
					
					for(int j=0; j<p.length(); j++) {
						char func = p.charAt(j);
						
						if(deque == null) {
							isError = true;
							break;
						}
						
						if(func == 'R') {
							isReverse = !isReverse;
						} else if(func == 'D') {
							if(deque.size() < 1) {
								isError = true;
								break;
							}
							
							if(isReverse) {
								deque.pollLast();
							} else {
								deque.pollFirst();
							}
							
							n--;
						}
					}
					
					
					StringBuilder result = new StringBuilder();
					
					if(isError) {
						result.append("error");
					} else {
						result.append("[");
						
						for(int k=0; k<n; k++) {
							result.append(isReverse ? deque.pollLast() : deque.pollFirst()).append((k < n-1) ? "," : "");
						}
						
						result.append("]");
					}
					
					
					System.out.println(result.toString());
					
				} catch (Exception e) {
					System.out.println("error");
				}
			}
			
		} catch (Exception e) {
			System.out.println("error");
		}
	}
	
	public static <E> Deque<E> reverseDeque(Deque<E> deque) {
		Deque<E> newDeque = new LinkedList<E>();
		int size = deque.size();
		
		for(int i=0; i<size; i++){
			newDeque.add(deque.pollLast());
		}
		
		return newDeque;
	}
}
