package Programmers;

import java.util.Arrays;

public class X_N {

	public long[] x_n(int x, int n) {
        long[] answer = new long[n];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] += (i+1) * Long.valueOf(x);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		X_N xn = new X_N();
		int x = 2; int n = 5;
		int x1 = 4; int n1 = 3;
		int x2 = -4; int n2 = 2;
		System.out.println(Arrays.toString(xn.x_n(x, n)));
		System.out.println(Arrays.toString(xn.x_n(x1, n1)));
		System.out.println(Arrays.toString(xn.x_n(x2, n2)));
	}

}
