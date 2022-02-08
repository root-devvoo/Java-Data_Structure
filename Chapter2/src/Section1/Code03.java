package Section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* 이름과 번호를 입력받고 사전순으로 정렬하여 출력한다. (버블정렬)
 */
public class Code03 {
	
	static Person1[] members = new Person1[100];
	static int n = 0;
	
	public static void main(String[] args) {
//		members = new Person1[100]; // 배열 생성
		try {
			Scanner sc = new Scanner(new File("input.txt"));
			while (sc.hasNext()) { // 파일의 끝에 도달할 때까지
				String nm = sc.next();
				String nb = sc.next();
				
				members[n] = new Person1(); // 객체 생성
				
				members[n].name = nm;
				members[n].number = nb;
				n++;
			}
		
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("No data file");
		}
		
		bubbleSort();
		for (int i=0; i<n; i++) {
			System.out.println(members[i].name + " " + members[i].number);
		}
	}

	static void bubbleSort() {
		for (int i = n-1; i>0; i--) {
			for (int j=0; j<i; i++) {
				if (members[j].name.compareTo(members[j+1].name) > 0) { // compare names of j-th and (j+1)-th person
					// swap two person 이름과 전화번호가 하나의 Person1 객체 안에 포함되어있기 때문에, 우리는 Person객체 2개를 그냥 통째로 자리를 바꿔준다.
					Person1 tmp = members[j];
					members[j] = members[j+1];
					members[j+1] = tmp;
				}
			}
		}
	}
}