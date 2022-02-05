import java.util.Scanner;

/* n개의 정수를 입력받아 배열에 저장한다.
 * 이들 중에서 0개 이상의 연속된 정수들을 더하여 얻을 수 있는
 * 최대값을 구하여 출력하는 프로그램을 작성하라.
 * 
 * (합이 최대가 되는 구간을 구하는 문제...(완전탐색)
 *  모든 구간을 일일히 다 검사해본다.
 *  모든 가능한 구간을 다 하나씩 순서대로 검사하면서, 그 각 구간의 합을 구한다.
 *  그러면, 그 합들 중에 최대값을 우리가 찾으면 됨)
 */
public class Code12_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// n이라는 숫자 지정
		int n = sc.nextInt();
		
		int[] data = new int[n];
		// n개의 정수를 입력받아 배열에 저장
		for (int i=0; i<n; i++)
			data[i] = sc.nextInt();
		sc.close();

		int max = 0;
		for (int i=0; i<n; i++) { // i를 각 구간의 시작점이라고 한다면, i는 물론 0에서 n까지 n가지 경우가 있을 것이다. i가 각 구간의 시작점이다.
			for (int j=i; j<n; j++) { // 그러면, 그 각각의 시작점에 대해서 우리가 j를 각 구간의 끝점이라고 한다면, j가 0에서 시작할 필요는 없다. 
									  // 왜냐하면, 각 구간의 끝점이 시작점보다 더 왼쪽에 있을 필요는 없으니까.. 끝점은 i에서 다시 n까지 증가하는 것으로 충분
									  // j가 i가 된다는 것은 시작점과 끝점이 같다는 것이고, 그것은 길이가 1인 구간이 되는 것이다.
				// 그럼 우리가 여기에서 할 일은, data[i]에서 data[j]까지의 합을 구한 다음에 (add data[1]...data[j])
				int sum = 0;
				for (int k=i; k<=j; k++)
					sum += data[k];
				// 만약에, 그 sum이 현재까지 내가 알고 있는 최대sum보다 크다면 (if the sum > max)
				if (sum > max)
					max = sum; // 그러면 걔가 새로운 최대값이 되도록... (max = the sum;)
			}
		}
		System.out.println(max);
	}
}