package section3;

public class Term3 {
	private int coef;
	private int expo;
	
	public Term3(int c, int e) {
		coef = c;
		expo = e;
	}
	// private으로 제한을 두고 getExpo()(getter)메소드를 통해서 받아올 수 있게만 한다면, 읽을 수는 있지만 쓸 수는 없게할 수 있다.
	public int getExpo() { // getter
		return expo;
	}

	public int calcTerm(int x) {
		return (int) (coef * Math.pow(x, expo)); // 계수 * x의 지수승 (자바에서 지수함수를 계산하는 방법은 Math.pow())
		// pow는 double형으로 반환하는데 여기서 int로 반환하도록 설정했으니까 int형으로 캐스팅(형변환)
	}
	
	public void printTerm() { // 하나의 항을 출력하는 함수
		System.out.print(coef + "x^" + expo); // 계수를 먼저 출력하고, x^ 기호 출력, 그 다음 차수 출력
		// (완벽하진 않음, -x^2 ==> +-1x^2 이런식으로 출력되기 때문...)
	}
	// coef 변수의 데이터를 읽고, 쓸 수 있도록 
	public int getCoef() { // getter, accessor
		return coef;
	}
	public void setCoef(int coef) { // setter, mutator
		this.coef = coef;
	}
}