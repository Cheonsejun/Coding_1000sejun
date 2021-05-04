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
    	System.out.println("완주한 선수들: " + completion);
    	System.out.println("완주못한선수: " + s.solution(participant, completion));
    }
}




