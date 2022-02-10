package section3;

public class Polynomial3 {
	private char name; // 다항식의 이름
	private Term3[] terms; // 다항식을 구성하는 항들을 저장할 배열
	private int nTerms = 0; // 다항식을 구성하는 항의 개수
	
	// 생성자
	public Polynomial3() {
		nTerms = 0;
		terms = new Term3[100];
	}
	
	// 생성자 2 (매개변수를 받는 생성자)
	public Polynomial3(char name) {
		this.name = name; // this.name은 이 객체의 name 필드를 뜻함
		nTerms = 0;
		terms = new Term3[100];
	}
	
	public char getName() { // getter
		return name;
	}
	
	public int calcPolynomial(int x) {
		// 어떤 다항식 p와 변수 x의 값을 받아서 그 다항식의 값을 계산해서 리턴해주기
		int result = 0;
		for (int i=0; i<nTerms; i++) { 
			result += terms[i].calcTerm(x); // 이제는 각각의 calcTerm이라는 함수가 다른데 따로 있는게 아니라 그냥 각각의 항이 calcTerm이라는 멤버 메소드를 갖고 있기 때문에 이렇게...
		}
		return result;
	}

	public void printPolynomial() { // 다항식을 출력하는 함수
		for (int i=0; i<nTerms; i++) {
			terms[i].printTerm();
			System.out.print("+"); // (이 부분 스스로 수정하기)
		}
		System.out.println(); // 줄바꿈을 위해
	}
	
	public void addTerm(int c, int e) {
		int index = findTerm(e); // findTerm이라는 함수로 다항식에 2차 항이 있는지 없는지를 물어보도록 한다.
		if (index != -1) {
			terms[index].setCoef(terms[index].getCoef() + c);  // 인덱스가 -1이 아니라는 얘기는 이 다항식의 인덱스 번째 항의 차수가 e라는 얘기다. 그렇다면 우리가 할 일은 terms[index]번째 항의 계수를 c만큼 증가시켜준다.
			// -5x^3 + 5x^3 이렇게 되면 0이 되니까 그렇게 되면 이 항 자체를 이 다항식에서 제거하는 일을 해줘야 한다...(스스로 수정해서 적용하기)
		}
		else {
			int i = nTerms-1; // 맨 마지막 항
			while (i >= 0 && terms[i].getExpo() < e) { // 삽입정렬 적용: 내림차순으로 정렬하려는 거니까, 내가 지금 추가하려는 항의 차수 e보다 더 작다면 [추가 :: (Term3 클래스에서 변수 접근 제한을 private으로 설정했고, getExpo()를 통해서 받도록 바꿨으니까 getExpo())]
				// 이 항은 1칸 뒤로 물러나야한다.
				terms[i+1] = terms[i];
				i--;
			}
			terms[i+1] = new Term3(c, e); // 아래 두 라인이 하던 일을 클래스 안의 생성자가 해주기 때문에 이렇게 하면 아래 두 줄 필요없어짐
//			terms[i+1].coef = c; // 새로 만들어지는 term의 coef는 c가 되고
//			terms[i+1].expo = e; // // 새로 만들어지는 term의 expo는 e가 되고
			nTerms++; // 새로운 항이 하나 추가되었으니까 다항식 p의 항의 개수 1 증가
		}
	}
	
	public int findTerm(int e) {
		for (int i=0; i<nTerms && terms[i].getExpo() >= e; i++) // 이 다항식 p의 항의 개수는 nTerms
			// terms[i].expo가 e보다 크거나 같은 동안에만 돌도록... 어떤 항의 차수가 e보다 이미 작아졌다면 차수에 관한 내림차순으로 정렬이 되어있으니까 그 뒤에 있는 것들은 더 볼 필요도 없이 e보다 작음
			if (terms[i].getExpo() == e) // 찾은 경우.. (Term3 클래스에서 변수 접근 제한을 private으로 설정했고, getExpo()를 통해서 받도록 바꿨으니까 getExpo())
				return i;
		return -1; //못찾았다면		
	}
}
