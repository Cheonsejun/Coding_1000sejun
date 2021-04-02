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
		// ���� �뷮���� �߰��Ǵ� ���� ������ �� ������
		if(size >= capacity) {
		// ������ �� ������ arr �迭�� ũ�⸦ �÷��� �Ѵ�.
			capacity += capacity/2;
			Object[] tmp = new Object[capacity];
		// ���� ������ tmp�� ����
		for(int i = 0; i < size; i++) {
			tmp[i] = arr[i];
		}
		// arr�� �뷮�� �þ �迭�� ����Ű���� �Ѵ�.
			arr = tmp;	
		}
}
	
	public void add(T string) {
		if(size >= capacity)
			increaseCapacity();
		
		arr[size++] = string;
	}
	
	
	public void add(int idx, T value) {
		// �뷮�� �̹� ���������� �뷮�� 50% �ø���
		// �Ʒ� �ڵ带 �����Ѵ�.
		if(size == capacity) {
			increaseCapacity();
		// �� �ڿ� �ִ� ���Һ��� ���������� ��ĭ�� �ڷ� �δ�.
		for(int i = size-1; i >= idx; i--) {
			arr[i+1] = arr[i];
		}
		}
		// idx �ڸ��� value�� �ִ´�.
		arr[idx] = value;
		size++;
	}
	
//	public void remove(int idx) {
//		if (size > 0); size--;
//	}
	
	public void remove(int idx) {
		// �����ϴ� ������ �ݺ����� ������ ���� �����ϰ� ���ʹ迭 ���� ��迭�� �ű��.
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
		ArrayList<Integer> list = new ArrayList<>(); // �� �κ� <>������ ��������
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
		
//		list.add(3, 100); // �迭 3��°ĭ�� ���� 100�ֱ�
		
//		System.out.println(list);
		list.remove(3);
//		list.remove(Integer.valueOf(100)); // �迭 3��°ĭ ���� 100����
		System.out.println(list);
		
//		MyArrayList2<String> list2 = new MyArrayList2<>();
//		
//		list2.add("ȫ�浿");
//		list2.add("�ƽ���");
//		list2.add(1,"���̾��");
//		
//		System.out.println(list2);
//		
//		MyArrayList2<Student> list3 = new MyArrayList2<>();
//		
//		list3.add(new Student("ȫ�浿", 123));
//		
//		list3.add(new Student("���̾��", 123));
//		
//		System.out.println(list3);
	}

	
}
