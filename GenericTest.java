package ch14;

public class GenericTest {

	public static void main(String[] args) {
		GenericBox<String> box1 = new GenericBox<String>();
		
		box1.setContent("���ع���");
		// box2.setContent(100); // ����
		String s = box1.getContent();
		System.out.println(s);
		
		GenericBox<Integer> box2 = new GenericBox<Integer>();
		box2.setContent(100);
		// box2.setContent("���ع���"); // ����
		
		GenericBox<Student> box3 = new GenericBox<Student>();
		box3.setContent(new Student());
		Student std = box3.getContent();
		// box2.setContent(100); // ����
		// box2.setContent("���ع���"); // ����
	}

}
