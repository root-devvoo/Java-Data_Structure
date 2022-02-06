package Section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* input.txt라는 파일로부터 사람들의 이름과 전화번호 쌍을 입력받아
 * 배열에 저장하고 출력한다.
 */
public class Code19 {
	public static void main(String[] args) {
		String[] name = new String[1000]; // 배열의 크기 1000으로 지정
		String[] number = new String[1000];
		int n = 0; // n은 사람 수
		// FileNotFoundException 처리를 위해 try, catch문으로 감쌈
		try {
			Scanner sc = new Scanner(new File("input.txt")); // 데이터 파일은 프로젝트 폴더에 있어야 한다.
			                                                 // System.in 대신에 데이터 파일의 이름을 지정하고 File을 만든 후 그 파일에 대한 Scanner를 만든다.
			while (sc.hasNext()) { // 스캐너.hasNext() 메서드는 파일의 끝에 도달했는지 검사한다. 파일 안에서 더 읽을거리가 없으면 false를 리턴
								   // detect End of File
				name[n] = sc.next(); // 스캐너.next() 메서드는 하나의 문자열을 입력해줌
				number[n] = sc.next();
				n++;	
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			System.exit(9); // 프로그램 자체를 실행할 수 없으므로 종료시키는 메서드 System.exit()
			// status 0은 정상적인 종료를 의미, 0이 아닌 값은 프로그램의 비정상적인 오류로 종료됐음을 의미
		} 
													  
		for (int i=0; i<n; i++)
			System.out.println(name[i] + ": " + number[i]);
	}
}