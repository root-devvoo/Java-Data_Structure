import java.util.Scanner;

/* 사용자로부터 먼저 정수의 개수 n을 입력 받는다.
 * 이어서 n개의 정수를 입력받아 순서대로 배열에 저장한다.
 * 그런 다음 중복된 정수 쌍의 개수를 카운트하여 출력하라.
 * 예를 들어, n = 6이고 입력된 정수들이 2, 4, 2, 4, 5, 2이면
 * 중복된 정수쌍은 (2,2), (2,2), (2,2), (4,4)로 모두 4쌍이다.
 */
public class Code11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 사용자로부터 먼저 정수의 개수 n을 입력 받는다.
		int n = sc.nextInt();
		
		int[] data = new int[n];
		// n개의 정수를 입력받아 순서대로 배열에 저장한다.
		for (int i=0; i<n; i++)
			data[i] = sc.nextInt();
		sc.close();

		int count = 0;
		// 중복된 정수 쌍의 개수를 카운트하여 출력
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) { // i < j
				// 이중 for문으로 data[i]와 data[j]라는 한 쌍을 검색...완전탐색
				if (data[i] == data[j])
					count++;
			}
		}
		System.out.println(count);
	}
}