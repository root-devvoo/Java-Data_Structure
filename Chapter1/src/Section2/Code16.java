package Section2;

import java.util.Scanner;

// 입력으로 두 정수 a와 b를 받아 a의 b승을 계산한다.
public class Code16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter two integers and press Enter.");
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		// 4. 메서드 power가 return문으로 넘겨준 값을 받아서 변수 result에 저장한다.
		int result = power(a, b); // 1. 메서드 power를 호출하면서 매개변수로 정수 a와 b의 값을 건낸다
		System.out.println("The result is " + result);
		sc.close();
	}
	
	public static int power(int n, int m) { // 2. 메서드 power는 매개변수로 두 개의 정수를 건내 받으며 각각을 m과 n이라고 이름 짓는다.
		int prod = 1;
		for (int i=0; i<m; i++) // i가 m보다 작은 동안 i를 증가시키면 이 for문은 정확히 m번 동작한다.
			prod *= n; // 맨 처음에 prod를 1이라고 하고, 거기에 n을 곱하는 일을 m번 반복하니까 prod는 n의 m승이 된다.
		return prod; // 3. 메서드 power는 계산 결과, 즉 변수 prod의 값을 return문을 이용해 자신을 호출한 이에게 넘겨준다.
	}
}