package Programmers;

import java.util.*;


class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i;
        for(i = 0; i < participant.length; i++) {
        	if(!participant[i].equals(completion[i])) {
        		return participant[i];
        	}
        }
        
        return participant[i];
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	String[] participant = {"adin", "kkk", "zzz"};
    	String[] completion = {"zzz", "kkk"};
    	for(String a : participant) { System.out.print(a + " "); }
    	System.out.println("������ ������: " + completion);
    	System.out.println("���ָ��Ѽ���: " + s.solution(participant, completion));
    }
}




