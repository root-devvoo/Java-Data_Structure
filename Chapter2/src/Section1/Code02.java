package Section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* (제1-2장 Code20때 짰던 코드를 수정)
 * 데이터 파일로부터 사람들의 이름과 전화번호를 입력받아 배열 members에 저장한 후,
 * 입력된 순서대로 출력하려고 한다. 이 코드에서 잘못된 점들을 모두 찾아서 수정하라.
 */
public class Code02 {
	
	static Person1[] members = new Person1[100];
	static int n = 0;
	
	public static void main(String[] args) {
//		members = new Person1[100]; // 배열 생성
		try {
			Scanner sc = new Scanner(new File("input.txt"));
			while (sc.hasNext()) { // 파일의 끝에 도달할 때까지
				String nm = sc.next();
				String nb = sc.next();
				
				members[n] = new Person1(); // members[n]이라는 것은 참조 변수일 뿐이니까 실제로 데이터를 저장할 Person1 객체를 생성해서,
											// 먼저 그 객체를 참조하는 일을 이와 같이 해줘야 함
				members[n].name = nm;
				members[n].number = nb;
				n++;
			}
		
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("No data file");
		}
		
		for (int i=0; i<n; i++) {
			System.out.println(members[i].name + " " + members[i].number);
		}
	}
}