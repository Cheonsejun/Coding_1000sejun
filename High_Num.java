package Pro_Level1;

import java.util.Arrays;

public class High_Num {
	// ���α׷��ӽ� Level_1 �ּҰ���� �ִ����� ���ϱ�
	public int[] high(int n, int m) {
		int[] ans = new int[2];
		ans[0] = gdc(n, m);
		ans[1] = n * m / ans[0];
		
		return ans;
	}
	
	public int gdc(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	
	
	public static void main(String[] args) {
		High_Num hn = new High_Num();
		int n1 = 3; int m1 = 12;
		System.out.println(Arrays.toString(hn.high(n1, m1)));
	}

}
