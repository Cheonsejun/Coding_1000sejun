package Programmers;
import java.util.*;
public class MathTest {
	public static int[] mathTest(int[] answers) {
        int[] answer = {};
        int[] std1 = {1, 2, 3, 4, 5};
        int[] std2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] std3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        
        for(int i = 0; i < answers.length; i++) {
        	// i�� �迭�� ���� �������ν� ���迭�� �ٸ����̸� �غ��Ҽ��ִ�
        	if(std1[i % std1.length] == answers[i]) cnt1++;
        	if(std2[i % std2.length] == answers[i]) cnt2++;
        	if(std3[i % std3.length] == answers[i]) cnt3++;
        }
        
        int max = Math.max(Math.max(cnt1, cnt2),cnt3); // �ΰ����� ���ϰ� �� ���Ѵ�
        ArrayList<Integer> list = new ArrayList<>();
        if(max == cnt1) list.add(1);
        if(max == cnt2) list.add(2);
        if(max == cnt3) list.add(3);
        
        answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i);
        }
        

        return answer;
    }
	
	public static void main (String[]args) {
		MathTest m = new MathTest();
		int[] answers = {1,2,3,4,5,};
		System.out.println(Arrays.toString(m.mathTest(answers)));
	}
}
