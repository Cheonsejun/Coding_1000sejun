package Programmers;

import java.util.Arrays;

public class P_Num {
	
	public String p_num (String phone_number) {
        String ans = "";
        for(int i = 0; i < phone_number.length(); i++) {
        	if(i < phone_number.length()-4) {
        		ans += "*";
        	}
        	else {
        		ans += phone_number.charAt(i);
        	}
        }
        return ans;
    }
	
	public static void main(String[] args) {
		P_Num p = new P_Num();
		String p_number = "01033334444";
		String p_number1 = "027778888";
		System.out.println((p.p_num(p_number)));
		System.out.println((p.p_num(p_number1)));
	}

}
