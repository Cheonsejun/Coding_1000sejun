package Programmers;

import java.util.Arrays;

public class Arr_Plus {
	// 프로그래머스 level_1 행렬의 덧셈
	public int[][] plus(int[][] arr1, int[][] arr2) {
        int[][] ans = new int[arr1.length][arr1[0].length];
        for(int i = 0; i < arr1.length; i++) {
        	for(int j = 0; j < arr1[0].length; j++) {
        		ans[i][j] = arr1[i][j] + arr2[i][j];
        	}
        }
        return ans;
    }
	
	public static void main(String[] args) {
		Arr_Plus ap = new Arr_Plus();
		int[][] arr1 = {{1,2}, 
						{2,3}};
		
		int[][] arr2 = {{3,4}, 
						{5,6}}; 
		
		int[][] arr3 = {{1}, 
						{2}}; 
		
		int[][] arr4 = {{3}, 
						{4}}; 
		
		System.out.println(Arrays.deepToString(ap.plus(arr1, arr2)));
		System.out.println(Arrays.deepToString(ap.plus(arr3, arr4)));
	}
}
