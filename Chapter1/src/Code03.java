import java.util.Scanner;

public class Code03 {

	public static void main(String[] args) {
		String str = "Hello";
		String input = null; // String :: 문자열 값을 저장할 변수 타입 지정
		// (null은 없어도 상관없음, 여기선 명시적으로 지정해준 것일뿐)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please type a string: ");
		input = sc.next(); // next()는 문자열 입력받는 기능
		
		if(str.equals(input)) { // == 연산자는 프리미티브 타입의 경우만 사용할 수 있다. 
		   // String은 프리미티브 타입이 아니므로 equals 함수 사용. input.equals(str)로 해도됨
			System.out.println("Strings match! :-)");
		} else {
			System.out.println("Strings do not match! :-(");
		}
		
		sc.close();
	}
}