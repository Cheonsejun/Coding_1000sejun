package Programmers;

import java.util.Arrays;
import java.util.ArrayList;
public class Divisor {
	public int[] solution(int[] arr, int divisor) {
		ArrayList<Integer>list = new ArrayList<>();

		for(int i = 0; i < arr.length; i++) {
        	if(arr[i] % divisor == 0) {
        		list.add(arr[i]);
        	}
        }
		
		if(list.size() == 0) {
			list.add(-1);
		}
		
		int[] ans = new int[list.size()];
		
		for(int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		Arrays.sort(ans);
        return ans;
    }
	
	public static void main(String[] args) {
		Divisor dv = new Divisor();
		int[] arr = {5,9,7,10};
		int divisor = 5;
		int[] arr1 = {2,36,1,3};
		int divisor1 = 1;
		int[] arr2 = {3,2,6};
		int divisor2 = 10;
		System.out.println(Arrays.toString(dv.solution(arr, divisor)));
		System.out.println(Arrays.toString(dv.solution(arr1, divisor1)));
		System.out.println(Arrays.toString(dv.solution(arr2, divisor2)));
	}

}
