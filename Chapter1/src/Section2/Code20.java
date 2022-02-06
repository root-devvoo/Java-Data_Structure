package Section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* input.txt 파일로부터 이름과 전화번호 쌍을 입력받은 후
 * 이름의 알파벳 순서로 정렬하여 출력한다. 
 */
public class Code20 {
	/* 입력받은 이름과 전화번호들을 저장할 배열 name과 number 그리고 개수 count는
	 * main메서드만이 아니라 bubbleSort 메서드에서 사용된다.
	 * 그래서 main 메서드 외부에 선언하였다. 
	 * 이렇게 하나의 메서드가 아니라 클래스 전체에서 사용될 데이터는
	 * 클래스의 멤버로 만드는 것이 좋다.
	 */
	static String[] name = new String[1000];
	static String[] number = new String[1000];
	static int n = 0;
	
	public static void main(String[] args) {
		// 예외처리를 위한 try, catch
		try {
			Scanner sc = new Scanner(new File("input.txt"));
			while (sc.hasNext()) {
				name[n] = sc.next();
				number[n] = sc.next();
				n++;
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			System.exit(9);
		}
		
		bubbleSort(); // 정렬할 데이터를 넘겨준다. 정렬할 갯수 n 그리고 name, number를 넘겨준다
		// 그러나 클래스 밖에 name, number, n을 선언했기 때문에 더이상 bubbleSort()를 호출할 때 매개변수로 넘겨줄 필요가 없어진다.
		// 어차피 bubbleSort 함수 안에서도 name, number, n을 다 사용할 수 있기 때문이다. (아까와 그냥 다르게 해보는 것임... 편법(?))
		
		for (int i=0; i<n; i++)
			System.out.println(name[i] + ": " + number[i]);
	}
	static void bubbleSort() { // 정렬이니까 리턴타입은 void
		for (int i=n-1; i>0; i--) { // int i는 n-1에서, i가 0보다 큰 동안 i를 줄여가면서
			for (int j=0; j<i; j++) { // int j는 0에서, j는 i보다 작은 동안 j를 증가시켜가면서
				if (name[j].compareTo(name[j+1]) > 0) { // 사람의 이름에 대해서 정렬을 하는 것이기 떄문에 name..
										                // compareTo는 name[j]와 name[j+1]을 비교하라는거니까 (크다, 작다, 똑같다의)3가지 가능성이 있다. 그 결과를 (작은 경우)음수나 (똑같은 경우)0이나 (큰 경우)양수로 반환함
													    // 우리는 name[j]가 name[j+1]보다 큰지가 관심사이다. 만약에 name[j]가 크다면 양수를 반환하기 때문에, compareTo > 0 이렇게 표시해주면 된다.
					// swap name[j] and name[j+1]
					String tmp = name[j];
					name[j] = name[j+1];
					name[j+1] = tmp;
					// 그리고 이름에 따라서 number도 같이 swap시켜줘야하므로...
					tmp = number[j];
					number[j] = number[j+1];
					number[j+1] = tmp;
				}	
			}
		}
	}
}