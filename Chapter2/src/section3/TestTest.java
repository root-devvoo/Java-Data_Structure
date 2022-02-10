package section3;

public class TestTest {

	public static void main(String[] args) {
		Test test1 = new Test();
		
		test1.t = 10; // 문제 없음
		Test.s = 100; // s는 클래스 멤버이므로 test1 객체에 속해있지 않다.
//		Test.print1(); // 그러므로, 클래스 멤버는 해당 클래스를 불러온다. 클래스이름.print1();, 클래스이름.s = 100; 이런식으로
		test1.print2(); // 문제 없음
		
		Test test2 = new Test(); // 별개의 객체 test2
		Test.print1();
		test2.print2(); // 별개의 객체기 때문에 초기값으로 설정한 0 출력
	}
}