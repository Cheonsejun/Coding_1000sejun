package ch14;

import java.util.*;

public class MyArrayList2<T> {
	private Object[] arr;
	private int capacity = 10;
	private int size = 0;
	
	public MyArrayList2() {
		arr = new Object [capacity];
	}
	
private void increaseCapacity() {
		// 현재 용량으로 추가되는 값을 수용할 수 있으면
		if(size >= capacity) {
		// 수용할 수 없으면 arr 배열의 크기를 늘려야 한다.
			capacity += capacity/2;
			Object[] tmp = new Object[capacity];
		// 원래 값들을 tmp로 복사
		for(int i = 0; i < size; i++) {
			tmp[i] = arr[i];
		}
		// arr의 용량이 늘어난 배열을 가르키도록 한다.
			arr = tmp;	
		}
}
	
	public void add(T string) {
		if(size >= capacity)
			increaseCapacity();
		
		arr[size++] = string;
	}
	
	
	public void add(int idx, T value) {
		// 용량이 이미 꽉차있으면 용량을 50% 늘리고
		// 아래 코드를 실행한다.
		if(size == capacity) {
			increaseCapacity();
		// 맨 뒤에 있는 원소부터 오른쪽으로 한칸씩 뒤로 민다.
		for(int i = size-1; i >= idx; i--) {
			arr[i+1] = arr[i];
		}
		}
		// idx 자리에 value를 넣는다.
		arr[idx] = value;
		size++;
	}
	
//	public void remove(int idx) {
//		if (size > 0); size--;
//	}
	
	public void remove(int idx) {
		// 제거하는 값부터 반복문을 돌려서 값을 제거하고 뒷쪽배열 값을 빈배열로 옮긴다.
		if(size > 0) {
			for(int i = idx; i < size; i++) {
				arr[i] = arr[i+1];
 			}
		}
	}
	
	public T get(int idx) {
		return (T)arr[idx];
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		if(size == 0) return "[]";
		String result = "[";
		for(int i = 0; i < size-1; i++) {	
			result +=  arr[i] + ", ";
			if((i+1) % 10 == 0)
				result += "\n";
		}
		result += arr[size-1];
		result += "]";
		return result;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(); // 뒷 부분 <>안쪽은 생략가능
//		MyArrayList2 list = new MyArrayList2();
//		
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
//		System.out.println(list.toString());
//		
//		list.add(3, 100);
//		System.out.println(list);
//		list.remove(3);
		
//		list.add(3, 100); // 배열 3번째칸에 숫자 100넣기
		
//		System.out.println(list);
		list.remove(3);
//		list.remove(Integer.valueOf(100)); // 배열 3번째칸 숫자 100제거
		System.out.println(list);
		
//		MyArrayList2<String> list2 = new MyArrayList2<>();
//		
//		list2.add("홍길동");
//		list2.add("아쉽네");
//		list2.add(1,"아이언맨");
//		
//		System.out.println(list2);
//		
//		MyArrayList2<Student> list3 = new MyArrayList2<>();
//		
//		list3.add(new Student("홍길동", 123));
//		
//		list3.add(new Student("아이언맨", 123));
//		
//		System.out.println(list3);
	}

	
}
