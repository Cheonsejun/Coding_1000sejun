package ch14;

public class MyResource  implements AutoCloseable{

	public MyResource() {
		System.out.println("MyResource 생성");
	}
	
	public int getValue() throws Exception{
		int random = (int) (Math.random()*2);
		if(random == 0) {
			throw new OutOfResourceException("자원고갈 오류...");
		}
		return (int) (Math.random()*100);
	}
	
	public void close() {
		System.out.println("close... 자원반납");
	}


}
