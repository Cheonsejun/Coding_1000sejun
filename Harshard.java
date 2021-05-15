package Programmers;

import java.util.Arrays;

public class Harshard {
	// 프로그래머스 level_1 하샤드 수
	public boolean harshard(int x) {
		int m = x;
        int sum = 0;
        while(x > 0) {
        	sum += x % 10;
        	x /= 10;
        }
        return m%sum == 0 ? true : false;
    }
	
	public static void main(String[] args) {
		Harshard ha = new Harshard();
		int[] n = {333, 12, 11, 13};
		
		for(int i = 0; i < n.length; i++) {
			System.out.println(ha.harshard(n[i]));
		}
	}

}
