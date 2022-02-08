package Section1;

import java.util.Scanner;
// 이 코드의 완성도를 높이는 것은 스스로 수정...(ㅠㅠ;;;)
public class Code06 {
	
	static Polynomial[] polys = new Polynomial[100]; // 다항식 배열
	static int n = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("$ ");
			String command = sc.next();
			if (command.equals("create")) {
				char name = sc.next().charAt(0);
				polys[n] = new Polynomial(); // Polynomial 객체 생성
				polys[n].name = name;
				polys[n].terms = new Term[100];
				polys[n].nTerms = 0;
				n++;
			}
			else if (command.equals("add")) { // add f 2 3
				char name = sc.next().charAt(0);
				int index = find(name); // find 함수가 해당 인덱스를 찾아주도록 해서 index 변수에 넣는다.
				if (index == -1) {
					System.out.println("No such polynomial exists.");
				}
				else {
					int c = sc.nextInt();
					int e = sc.nextInt();
					addTerm(polys[index], c, e); // 그 다항식 객체에 대한 참조 자체를 넘겨주고, 계수와 차수를 넘겨주고
					// 이 다항식에 cx에 e승을 추가해라 이렇게...
				}
			}
			else if (command.equals("calc")) {
				char name = sc.next().charAt(0); // 계산할 다항 함수의 이름을 입력받고
				int index = find(name); // find 함수가 해당 인덱스를 찾아주도록
				if (index == -1) { // 존재하지 않으면 안되니까...
					System.out.println("No such polynomial exists.");
				} else {
					int x = sc.nextInt();
					int result = calcPolynomial(polys[index], x); // polys[index]번째 다항식에서 변수 x의 값을 주고 리턴하도록
					System.out.println(result); // 리턴 받은 result 출력
				}
			}
			else if (command.equals("print")) {
				char name = sc.next().charAt(0);
				int index = find(name); // find 함수가 해당 인덱스를 찾아주도록
				if (index == -1) {
					System.out.println("No such polynomial exists.");
				}
				else {
					printPolynomal(polys[index]);
				}
			}
			else if (command.equals("exit"))
				break;
				
		}
		sc.close();
	}

	private static int calcPolynomial(Polynomial p, int x) {
		// 어떤 다항식 p와 변수 x의 값을 받아서 그 다항식의 값을 계산해서 리턴해주기
		int result = 0;
		for (int i=0; i<p.nTerms; i++) { // 모든 항들에 대해서
			result += calcTerm(p.terms[i], x); // 어떤 다항식의 값이라는 것은 각 항의 값을 계산해서 더해주면 된다
					 // 그래서, 항의 값을 계산해주는 calcTerm이라는 함수를 따로 만듦
		}
		return result;
	}

	private static int calcTerm(Term term, int x) {
		return (int) (term.coef * Math.pow(x, term.expo)); // 계수 * x의 지수승 (자바에서 지수함수를 계산하는 방법은 Math.pow())
		// pow는 double형으로 반환하는데 여기서 int로 반환하도록 설정했으니까 int형으로 캐스팅(형변환)
	}

	private static void printPolynomal(Polynomial p) { // 다항식을 출력하는 함수
		for (int i=0; i<p.nTerms; i++) {
			printTerm(p.terms[i]);
			System.out.print("+"); // (이 부분 스스로 수정하기)
		}
		System.out.println(); // 줄바꿈을 위해
	}

	private static void printTerm(Term term) { // 하나의 항을 출력하는 함수
		System.out.print(term.coef + "x^" + term.expo); // term.계수를 먼저 출력하고, x^ 기호 출력, 그 다음 term.차수 출력
		// (완벽하진 않음, -x^2 ==> +-1x^2 이런식으로 출력되기 때문...)
	}

	private static void addTerm(Polynomial p, int c, int e) {
		int index = findTerm(p, e); // findTerm이라는 함수로 다항식 p에 2차 항이 있는지 없는지를 물어보도록 한다.
		if (index != -1) {
			p.terms[index].coef += c; // 인덱스가 -1이 아니라는 얘기는 이 다항식의 인덱스 번째 항의 차수가 e라는 얘기다. 그렇다면 우리가 할 일은 p.terms[index]번째 항의 계수를 c만큼 증가시켜준다.
			// -5x^3 + 5x^3 이렇게 되면 0이 되니까 그렇게 되면 이 항 자체를 이 다항식에서 제거하는 일을 해줘야 한다...(스스로 수정해서 적용하기)
		}
		else {
			int i = p.nTerms-1; // 맨 마지막 항
			while (i >= 0 && p.terms[i].expo < e) { // 삽입정렬 적용: 내림차순으로 정렬하려는 거니까, 내가 지금 추가하려는 항의 차수 e보다 더 작다면
				// 이 항은 1칸 뒤로 물러나야한다.
				p.terms[i+1] = p.terms[i];
				i--;
			}
			p.terms[i+1] = new Term();
			p.terms[i+1].coef = c; // 새로 만들어지는 term의 coef는 c가 되고
			p.terms[i+1].expo = e; // // 새로 만들어지는 term의 expo는 e가 되고
			p.nTerms++; // 새로운 항이 하나 추가되었으니까 다항식 p의 항의 개수 1 증가
		}
	}

	private static int findTerm(Polynomial p, int e) {
		for (int i=0; i<p.nTerms && p.terms[i].expo >= e; i++) // 이 다항식 p의 항의 개수는 p.nTerms..
			// p.terms[i].expo가 e보다 크거나 같은 동안에만 돌도록... 어떤 항의 차수가 e보다 이미 작아졌다면 차수에 관한 내림차순으로 정렬이 되어있으니까 그 뒤에 있는 것들은 더 볼 필요도 없이 e보다 작음
			
			if (p.terms[i].expo == e) // 찾은 경우
				return i;
		return -1; //못찾았다면				
				
	}

	private static int find(char name) {
		for (int i=0; i<n; i++)
			if (polys[i].name == name) // polys[i].name이 찾고 있는 이름과 같다면
				return i; // 그 배열상에서 그 다항식의 인덱스를 리턴
		return -1; // 여기까지 온건 그런 이름의 다항식이 없다는 것이니까 -1 리턴
	}
}