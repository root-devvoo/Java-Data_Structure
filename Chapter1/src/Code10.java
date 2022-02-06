// 1~100000 사이의 모든 소수들을 찾아서 출력하는 프로그램이다.
// (소수는 1과 그 수 자신 이외의 자연수로는 나눌 수 없는, 1보다 큰 자연수이다.)
public class Code10 {
	public static void main(String[] args) {
		for (int n=2; n<=100000; n++) { // 1은 어차피 소수가 아니므로 굳이, 1부터 시작할 필요는 없음 
			boolean isPrime = true;
			// 2, 3, ..., 루트 n(sqrt(n))까지 돌면 된다.
			// 왜냐하면, 만약에 n의 약수 중에 루트 n보다 더 큰게 있다면, 반드시 루트 n보다 작은 약수도 존재하게 되기 때문
			for (int i=2; i*i<=n && isPrime; i++) { // i가 루트 n보다 작다는 것은, 결국 i의 제곱이 n보다 작다는 것이랑 같다
				if (n%i == 0) // 나누어 떨어진다면
					isPrime = false; // 약수가 아니기 때문에 그때는 이 for문을 빠져나오도록 함.
			}
			if (isPrime) // isPrime이 true일 경우에
				System.out.println(n); // 그 숫자 n 출력
		}
	}
}