package Pro_Level1;

public class Collatz {
	public int collatz(int num) {
	// 프로그래머스 Level_1 콜라츠 추측
		int cnt = 0;
		
		while(num != 1) {
			if(num % 2 == 1) {
				num = (num*3) + 1;
				cnt++;
			}else{
				num = num / 2;
				cnt++;
			}
			
			if(cnt >= 500) return -1;
		}
		return cnt;
	}
	public static void main(String[] args) {
		Collatz co = new Collatz();
		int[] n = {6, 16, 626331};
		for(int i = 0; i < n.length; i++) {
			System.out.println(co.collatz(n[i]));
		}
	}
}
