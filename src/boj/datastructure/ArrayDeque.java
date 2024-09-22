package boj.datastructure;

import java.util.Queue;

public class ArrayDeque /* implements Queue<E> */{

	private static final int DEFAULT_CAPACITY = 64; // 최소(기본) 용적 크기
	
	private Object[] array; // 요소를 담을 배열
	private int size; // 요소 개수
	
	private int front; // 시작 인덱스를 가리키는 변수(빈 공간임을 유의)
	private int rear; // 마지막 요소의 인덱스를 가리키는 변수
	
	// 생성자1 (초기 용적 할당을 안할 때)
	public ArrayDeque() {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}
	
	// 생성자2 (초기 용적 할당을 할 때)
	public ArrayDeque(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}
	
	private void resize(int newCapacity) {
		int arrayCapacity = array.length; // 현재 용적 크기
		
		Object[] newArray = new Object[newCapacity]; // 용적을 변경한 배열
		
		/*
		 * i = new array index
		 * j = original array
		 * index 요소 개수(size)만큼 새 배열에 값 복사
		 */
		
		for(int i=1, j=front+1; i<=size; i++, j++) {
			
		}
	}
	
	
	
}
