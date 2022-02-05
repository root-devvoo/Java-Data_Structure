import java.util.Scanner;

// 사용자로부터 n개의 정수를 입력받은 후 합과 최대값을 구하여 출력하는 코드
public class Code08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n];
		
		for (int i=0; i<n; i++) // n번 도니까 for문을 한번 돌 때마다 입력받음
			data[i] = sc.nextInt();
		
		sc.close();
		
		int sum = 0;
		int max = data[0]; // 음수값도 최대값으로 잘 잡게 하기 위해서 실제로 있는 데이터로 초기화해놓음
		for (int i=0; i<n; i++) {
			sum += data[i]; // sum에다가 그 각각의 정수들을 더해준다면 전체 합을 구할 수 있을 것이다
			// sum = sum + data[i];
			if (data[i] > max) // 최대값 구하는 조건문
				max = data[i];
		}

		System.out.println("The sum is " + sum);
		System.out.println("The max is " + max);
	}
}