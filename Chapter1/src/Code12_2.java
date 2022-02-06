import java.util.Scanner;

/* n개의 정수를 입력받아 배열에 저장한다.
 * 이들 중에서 0개 이상의 연속된 정수들을 더하여 얻을 수 있는
 * 최대값을 구하여 출력하는 프로그램을 작성하라.
 * 
 * (Code12_1 코드보다 간결하고 효율적인 코드)
 */
public class Code12_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// n이라는 숫자 지정
		int n = sc.nextInt();
		
		int[] data = new int[n];
		// n개의 정수를 입력받아 배열에 저장
		for (int i=0; i<n; i++)
			data[i] = sc.nextInt();
		sc.close();
		// Code12_1 코드보다 간결하고 효율적인 코드
		int max = 0;
		for (int i=0; i<n; i++) {
			int sum = 0; // sum의 값은 i가 바뀔 때...즉, 구간의 출발점이 변경될 때 sum은 0으로 리셋하고,
			for (int j=i; j<n; j++) {  // j가 바뀌는 동안에는 새로 sum을 구하지 않고, 
									   // 그 이전 루프에서 구해놨던 sum에 현재의 data[j]를 더해주기만 하면, 항상 i에서 j까지의 합이 구해진다.
				sum += data[j]; // (그냥 sum에다가 data[j]를 추가해주는 것만으로 i에서 j까지의 합을 구할 수 있다.)
				if (sum > max)
					max = sum;
			}
		}
		System.out.println(max);
	}
}