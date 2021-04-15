package ch14_2;
import java.util.*;
public class PriorityQueueTest {
	
	public static void main(String[] args) {
//		test1();
		MyQueue queue = new MyQueue();
		queue.offer(new Task("작업1", 3));
		queue.offer(new Task("작업2", 2));
		queue.offer(new Task("작업3", 5));
		queue.offer(new Task("작업4", 1));
		queue.offer(new Task("작업5", 4));
		
		for(int i = 0; i < 5; i++) System.out.println(queue.poll());
	}
	
	private static void test1() {
			/*	
			 	우선순위 큐 객체를 생성하고
			 	Task 인스턴스를 삽입, 인출 해보자
			*/
			// 우선순위의 큐: 기본적으로 오름차순으로 연출한다
//			Queue<Task> queue = new PriorityQueue<>();
			Queue<Task> queue = new PriorityQueue<>(new TaskComparator());
			queue.offer(new Task("작업1", 3));
			queue.offer(new Task("작업2", 2));
			queue.offer(new Task("작업3", 5));
			queue.offer(new Task("작업4", 1));
			queue.offer(new Task("작업5", 4));
			// 작업4, 작업2, 작업1, 작업5, 작업3
			
			while(queue.isEmpty() == false) {
				Task task = queue.poll();
				
				System.out.println(task);
			}
	}
}

class Task implements Comparable<Task>{ 
	// Task 인스턴스를 비교가능한 객체로 생성하기 위해 camparable 인터페이스를 구현
	String desc; //설명
	int priority = 5; // 이 작업의 우선순위
	
	
	// object 클래스에 정의된 toString 메소드를  재정의하는 예\
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
		// 이 객체의 값이 크면 양수 ,같으면  0, 작으면 음수를 변환
		return this.priority - q.priority;
		
		//return (-1) * (this.priority - q.priority);
		// 내림차순으로 하는방법[
	}
}

class MyQueue {
	Task[] tasks = new Task[10];
	int idx = 0;
	int pidx = 0;
	
	public void offer(Task value) {
			tasks[idx++] = value;
			// 새로운 객체가 들어올 때 마다 선택정렬로 sorting한다.
			for(int i = idx - 1; i >= 0; i--){
				int max = i; // 제일 마지막 원소가 최대값이 가정
				for (int j = 0; j < i; j++) {
					if(tasks[j].compareTo(tasks[max]) > 0) {
						max = j;
					}
					// max, i를 swap
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








