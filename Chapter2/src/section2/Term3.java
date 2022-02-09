package section2;
// Term2 와 차이는 생성자 유무
public class Term3 {
	public int coef;
	public int expo;
	
	public Term3(int c, int e) {
		coef = c;
		expo = e;
	}

	public int calcTerm(int x) {
		return (int) (coef * Math.pow(x, expo)); // 계수 * x의 지수승 (자바에서 지수함수를 계산하는 방법은 Math.pow())
		// pow는 double형으로 반환하는데 여기서 int로 반환하도록 설정했으니까 int형으로 캐스팅(형변환)
	}
	
	public void printTerm() { // 하나의 항을 출력하는 함수
		System.out.print(coef + "x^" + expo); // 계수를 먼저 출력하고, x^ 기호 출력, 그 다음 차수 출력
		// (완벽하진 않음, -x^2 ==> +-1x^2 이런식으로 출력되기 때문...)
	}
}
