package section2;

public class Polynomial2 {
	public char name; // 다항식의 이름
	public Term2[] terms; // 다항식을 구성하는 항들을 저장할 배열
	public int nTerms = 0; // 다항식을 구성하는 항의 개수
	
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
			terms[index].coef += c; // 인덱스가 -1이 아니라는 얘기는 이 다항식의 인덱스 번째 항의 차수가 e라는 얘기다. 그렇다면 우리가 할 일은 terms[index]번째 항의 계수를 c만큼 증가시켜준다.
			// -5x^3 + 5x^3 이렇게 되면 0이 되니까 그렇게 되면 이 항 자체를 이 다항식에서 제거하는 일을 해줘야 한다...(스스로 수정해서 적용하기)
		}
		else {
			int i = nTerms-1; // 맨 마지막 항
			while (i >= 0 && terms[i].expo < e) { // 삽입정렬 적용: 내림차순으로 정렬하려는 거니까, 내가 지금 추가하려는 항의 차수 e보다 더 작다면
				// 이 항은 1칸 뒤로 물러나야한다.
				terms[i+1] = terms[i];
				i--;
			}
			terms[i+1] = new Term2();
			terms[i+1].coef = c; // 새로 만들어지는 term의 coef는 c가 되고
			terms[i+1].expo = e; // // 새로 만들어지는 term의 expo는 e가 되고
			nTerms++; // 새로운 항이 하나 추가되었으니까 다항식 p의 항의 개수 1 증가
		}
	}
	
	public int findTerm(int e) {
		for (int i=0; i<nTerms && terms[i].expo >= e; i++) // 이 다항식 p의 항의 개수는 nTerms
			// terms[i].expo가 e보다 크거나 같은 동안에만 돌도록... 어떤 항의 차수가 e보다 이미 작아졌다면 차수에 관한 내림차순으로 정렬이 되어있으니까 그 뒤에 있는 것들은 더 볼 필요도 없이 e보다 작음
			if (terms[i].expo == e) // 찾은 경우
				return i;
		return -1; //못찾았다면		
	}
}
