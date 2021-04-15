package ch14_2;
import java.util.*;
public class PriorityQueueTest {
	
	public static void main(String[] args) {
//		test1();
		MyQueue queue = new MyQueue();
		queue.offer(new Task("�۾�1", 3));
		queue.offer(new Task("�۾�2", 2));
		queue.offer(new Task("�۾�3", 5));
		queue.offer(new Task("�۾�4", 1));
		queue.offer(new Task("�۾�5", 4));
		
		for(int i = 0; i < 5; i++) System.out.println(queue.poll());
	}
	
	private static void test1() {
			/*	
			 	�켱���� ť ��ü�� �����ϰ�
			 	Task �ν��Ͻ��� ����, ���� �غ���
			*/
			// �켱������ ť: �⺻������ ������������ �����Ѵ�
//			Queue<Task> queue = new PriorityQueue<>();
			Queue<Task> queue = new PriorityQueue<>(new TaskComparator());
			queue.offer(new Task("�۾�1", 3));
			queue.offer(new Task("�۾�2", 2));
			queue.offer(new Task("�۾�3", 5));
			queue.offer(new Task("�۾�4", 1));
			queue.offer(new Task("�۾�5", 4));
			// �۾�4, �۾�2, �۾�1, �۾�5, �۾�3
			
			while(queue.isEmpty() == false) {
				Task task = queue.poll();
				
				System.out.println(task);
			}
	}
}

class Task implements Comparable<Task>{ 
	// Task �ν��Ͻ��� �񱳰����� ��ü�� �����ϱ� ���� camparable �������̽��� ����
	String desc; //����
	int priority = 5; // �� �۾��� �켱����
	
	
	// object Ŭ������ ���ǵ� toString �޼ҵ带  �������ϴ� ��\
	@Override
	public String toString() {
		return "[desc:" + desc + ", priority" + priority + "]";
	}
	public Task(String desc, int priority) {
		this.desc = desc;
		this.priority = priority;
	}

	@Override
	public int compareTo(Task q) {
		// TODO Auto-generated method stub
		// �� ��ü�� ���� ũ�� ��� ,������  0, ������ ������ ��ȯ
		return this.priority - q.priority;
		
		//return (-1) * (this.priority - q.priority);
		// ������������ �ϴ¹��[
	}
}

class MyQueue {
	Task[] tasks = new Task[10];
	int idx = 0;
	int pidx = 0;
	
	public void offer(Task value) {
			tasks[idx++] = value;
			// ���ο� ��ü�� ���� �� ���� �������ķ� sorting�Ѵ�.
			for(int i = idx - 1; i >= 0; i--){
				int max = i; // ���� ������ ���Ұ� �ִ밪�� ����
				for (int j = 0; j < i; j++) {
					if(tasks[j].compareTo(tasks[max]) > 0) {
						max = j;
					}
					// max, i�� swap
					Task tmp = tasks[max];
					tasks[max] = tasks[i];
					tasks[i] = tmp;
				}
			}
	}
	
	public Task poll() {
		return tasks[pidx++];
	}
}

class TaskComparator implements Comparator<Task>{

	@Override
	public int compare(Task o1, Task o2) {
		// TODO Auto-generated method stub
		return o1.priority - o2.priority;
//		return (-1) * o1.priority - o2.priority;
	}
		
}








