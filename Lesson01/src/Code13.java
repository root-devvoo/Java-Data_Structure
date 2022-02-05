import java.util.Scanner;

/* n개의 음이 아닌 한 자리 정수를 입력받아 배열에 저장한다.
 * 이들 중에서 1개 이상의 연속된 정수들을 합하여( ex) 배열에 7, 1, 3이 있으면 713으로 해석하라는 의미)
 * 얻을 수 있는 소수들 중에서 최대값을 구하여 출력하는 프로그램을 작성하라.
 * (소수는 1과 그 수 자신 이외의 자연수로는 나눌 수 없는, 1보다 큰 자연수이다.) 
 */
public class Code13 {
	public static void main(String[] args) {
		// 지금까지와 동일하게 n개의 정수를 입력받는다.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n];
		for (int i=0; i<n; i++)
			data[i] = sc.nextInt();
		sc.close();
		////////////////////////////////////////////////
		int max = 0; // 최대값
		for (int i=0; i<n; i++) { // i는 구간의 출발점(시작점)을 표현
			for (int j=i; j<n; j++) { // j는 구간의 끝점인데, 구간의 끝점이 시작보다 더 왼쪽으로 갈 필요는 없기 때문에 j는 i에서부터 시작
				// data[i]...data[j]를 하나의 정수로 환산을 하고 (convert data[i]....data[j] into an integer)(예를 들어, 1, 9, 4 이렇게 되어있으면 194라는 정수로 환산)
				int val = 0; // 1, 9, 4라면 val가 최종적으로는 194가 되어야되는 우리가 환산하는 정수이다. 이 val을 처음에 0으로 해놓고,
				for (int k=i; k<=j; k++) // 하나씩 읽는다.
					val = val * 10 + data[k]; // (val = val x 10 + 1 = 1) 맨 처음 1을 읽으면 val은 지금 현재 val에다가 10을 곱하고, 금방 내가 읽은 정수 1을 더해준다. 그러면, 현재 val가 0이니까 1이 된다. 
											  // (val = val x 10 + 9 = 19) 그 다음에 9을 읽으면 다시 val은 지금 현재 val에다가 10을 곱해주고, 거기에다가 9를 더한다. 
											  //                           그러면, 현재 val가 1이니까 1x10하면 10이 되고 이것은 19가 된다.
											  // (val = 19 x 10 + 4 = 194) 그 다음에 4를 읽으면 다시 지금 현재 value인 19에다가 10을 먼저 곱해주고 거기에 4를 더해준다. 
											  // 						   그럼 194가 된다. 
											  // 이런식으로 숫자를 구성하는 digit들을 왼쪽에서 오른쪽 순으로 읽으면서 그것을 정수값으로 환산하는 알고리즘은
											  // val을 0이라고 한 후 새로운 digit들을 읽을 때마다 현재의 value에 10을 곱하고, 그냥 그 새로운 digit들을 더해주면 된다.
				
				// 그 다음에 그게 소수인지를 검사 (test if it is a prime)
				boolean isPrime = true;
				for (int p=2; p*p <= val && isPrime; p++) {
					if (val % p == 0)
						isPrime = false; // 소수가 아니면 for문을 빠져나오도록 함
				}
				// 만약에 그게 소수라면 현재까지 내가 알고 있는 최대값과 비교 (if yes, compare to the max)
				if (isPrime && val > 1 && val > max) // 만약에 val가 소수(isPrime)이면서, val이 1보다 크고(소수는 1보다 커야하니까), val가 현재까지 내가 알고 있는 최대값 max보다 크다면, 
					max = val; // 그 값이 최대가 되게 함.
			}
		}
		// 소수가 하나도 없어서 max가 0인 경우도 있다. 그런 경우를 위해서...
		if (max > 0) // 만약, max가 0보다 크다면 적어도 하나의 소수를 찾은거니까 그 소수를 출력
			System.out.println("The max prime number is " + max);
		else // 그렇지 않다면, 탐색결과 소수가 하나도 없었다고 출력
			System.out.println("No prime number exists.");
	}
}