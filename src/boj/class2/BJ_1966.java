package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;


public class bj_1966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 수
		int testCase = Integer.parseInt(br.readLine());
		Queue queue = new Queue();
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		for(int i=0; i<testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//문서개수
			int n = Integer.parseInt(st.nextToken());
			//몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서의 위치
			int m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			//중요도 큐
			
			queue.clear();
			
			while(st.hasMoreTokens()) {
				queue.enqueue(Integer.parseInt(st.nextToken()));
			}
			
			int orderNumber = 1;
			
			while(true) {
				int count = 0;
				int max = queue.get(0);
				
				for(int k=1; k<queue.size(); k++) {
					if(queue.get(k) > max) {
						int pop = queue.dequeue();
						queue.enqueue(pop);
						count++;
						
						if(m == 0)
							m = queue.size()-1;
						else
							m--;
						
						
						break;
					}
				}
				
				if(count == 0) {
					
					if(m  == 0) {
						output.add(orderNumber);
						break;
					}
						
					queue.dequeue();
					orderNumber++;
					m--;
				}
			}
		}
		
		for(Integer i : output)
			System.out.println(i);
	}
}

class Queue {
	private ArrayList<Integer> arrayQueue = new ArrayList<Integer>();
	
	public void enqueue(Integer addValue) {
		arrayQueue.add(addValue);
	}
	
	public Integer dequeue() {
		if(arrayQueue.size() < 1) {
			return null;
		}
		return arrayQueue.remove(0);
	}
	
	public Integer get(Integer index) {
		return arrayQueue.get(index);
	}
	
	public Integer size() {
		return arrayQueue.size();
	}
	
	public void clear() {
		arrayQueue.clear();
	}
}
