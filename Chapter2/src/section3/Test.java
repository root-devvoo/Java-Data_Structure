package section3;

public class Test {
	static int s = 0;
	int t = 0;
	
	public static void print1() {
		System.out.println("s = " + s);
//		Test test = new Test();
//		System.out.println("t = " + t); // t는 엑세스 불가
	}
	
	public void print2() {
//		System.out.println("s = " + s);
		System.out.println("t = " + t); // Test 객체 안에 이 함수가 존재하는 것이므로 당연히 t도 존재
	} // (Test 객체를 생성해야만 이 함수가 존재한다)
	
	public static void main(String[] args) {
		s = 100;
//		t = 100;
		print1();
//		print2();
		// 실제로 사용하려면 아래와 같이 객체를 생성해주고 불러와야한다.
		Test test1 = new Test();
		test1.t = 100;
		test1.print2();
	}
}