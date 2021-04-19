package ch14_2;

import java.util.*;

public class StackTest {
	public static void main(String[] args) {
		/*
		 	  Stack : LIFO(Last In First Out)
		*/
		/* Generic : Ŭ���� ���ο��� ����� ������ Ÿ���� ������ ����
		 * �ƴϰ� �� Ŭ������ ��ü�� ������ �� ������ �� �ֵ��� ,
		 * ����� ������ Ÿ���� �Ķ���ͷ� �޾Ƽ� ��ü�� �����ϴ� ��.
		 * Ÿ�� �Ķ���� (Type Parameter)
		*/
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < 10; i++) {
			stack.push(i + 1);
		}
		System.out.println(stack);
		
		while(stack.isEmpty() == false) {
			Integer val = stack.pop();
			System.out.print(val + " ");
		}
	}
}
