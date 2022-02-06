package Section2;
// 1~100000 사이의 소수를 찾아 출력한다.
public class Code17 {
	public static void main(String[] args) {
		for (int n=1; n<=100000; n++) {
			if (isPrime(n))
				System.out.println(n);
		}
	}
	
	public static boolean isPrime(int k) { // isPrime함수는 n이 소수인지 아닌지를 검사해서 그 결과를 true, false로 리턴을 하니까 boolean형
		if(k < 2) // 소수는 1보다 클 때만 적용되기 때문에 이렇게 조건문으로 정의 (소수 찾는 함수의 완전 무결성을 위해)
			return false;
		for(int i=2; i*i<=k; i++) { // i는 2부터 시작해서 i*i가 k보다(루트 k보다) 작은 동안 i를 증가시키면서
			if(k % i == 0) // 만약에 k를 i로 나누었을 때 나머지가 0이면
				return false; // (소수가 아니라는 증거가 발견되면) 그 즉시 false를 리턴하고 끝냄
		}
		return true; // for문이 끝나고 이 자리에 왔다는 것은 for문 안에서 return되지 않았다는 거니까 결국 한번도 나누어 떨어지지 않았다는 뜻이다.
		// 여기에 또다른 어떤 조건을 붙일 필요도 없이 이 자체로 약수가 없다. 즉, 소수이다라는 게 확인이 된 셈이기 때문에 여기서 즉시 return true; 하면된다.
	}
}