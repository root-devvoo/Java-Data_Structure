import java.util.Scanner;

public class Code02 {
	public static void main(String[] args) {
		
		int number = 123;
		Scanner sc = new Scanner(System.in); // sc라는 이름의 스캐너를 만들었다.
		
		System.out.print("Please enter an integer: "); // 줄을 바꾸지 않을 때 ln을 뺀 System.out.print
		
		int input = sc.nextInt(); // Int(Integer)
		
		if(input == number) {
			System.out.println("Numbers match! :-)");
		} else {
			System.out.println("Numbers do not match! :-(");
		}
		
		sc.close();
	}
}