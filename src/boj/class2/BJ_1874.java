package boj.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BJ_1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] sequence = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<String> outputList = new ArrayList<String>();
		
		for(int i=0; i<sequence.length; i++) {
			sequence[i] = Integer.parseInt(br.readLine());
		}
		int[] tempArr = Arrays.copyOf(sequence, sequence.length);
		
		Arrays.sort(tempArr);
		int i=0, j=0;
		
		while(true) {
			if(!stack.isEmpty() && stack.peek() == sequence[j]) {
				stack.pop();
				outputList.add("-");
				j++;
			} else {
				if(stack.size() == n) {
					outputList.clear();
					outputList.add("NO");
					break;
				}
					
				stack.push(tempArr[i]);
				outputList.add("+");
				
				if(i < tempArr.length-1)
					i++;
			}
			
			if(j > sequence.length-1)
				break;
		}
		
		for(String output : outputList)
			System.out.println(output);

	}

}
