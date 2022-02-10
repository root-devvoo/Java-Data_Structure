package section3;

import java.util.Scanner;

public class Code11 {
	
	private Polynomial3[] polys = new Polynomial3[100]; // 다항식 배열
	private int n = 0;
	
	public void processCommand() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("$ ");
			String command = sc.next();
			if (command.equals("create")) {
				char name = sc.next().charAt(0);
				polys[n] = new Polynomial3(name); // Polynomial 객체 생성
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
					polys[index].addTerm(c, e); // 계수와 차수를 넘겨주고
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
					int result = (polys[index].calcPolynomial(x)); // 각각의 다항식이 자신의 값을 계산해주는 calcPolynomial 이라는 함수를 멤버로 가지고 있기 때문에 이렇게 호출하면 된다.
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
					polys[index].printPolynomial(); // polys[index]번째 Polynomial에게 자신을 화면에 프린트해라라고 요청하면 되니까 이렇게...
				}
			}
			else if (command.equals("exit"))
				break;
				
		}
		sc.close();
	}
	
	// find 함수는 다항식이 여러개 있는데 그 중에 특정한 이름을 가지는 다항식을 찾는거니까.. 어떤 하나의 다항식 안에 넣기에 적절한 기능이 아니므로 여기에!
	private int find(char name) {
		for (int i=0; i<n; i++)
			if (polys[i].getName() == name) // 받아오는 이름 데이터가 찾고 있는 이름과 같다면
				return i; // 그 배열상에서 그 다항식의 인덱스를 리턴
		return -1; // 여기까지 온건 그런 이름의 다항식이 없다는 것이니까 -1 리턴
	}
	
	public static void main(String[] args) {
		Code11 app = new Code11();
		app.processCommand();
	}
}