package Section3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/* [인덱스 메이커]
 * + 입력으로 하나의 텍스트 파일을 읽는다 (sample.txt)
 * + 텍스트 파일에 등장하는 모든 단어들의 목록을 만들고,
 *   각 단어가 텍스트 파일에 등정하는 횟수를 센다. 단, 단어 개수는 100,000개 이하라고 가정한다.
 * + 사용자가 요청하면 단어 목록을 하나의 파일로 저장한다.
 * + 사용자가 단어를 검색하면 그 단어가 텍스트 파일에 몇 번 등장하는지 출력한다.
 * 
 * (실행 예)
 * $ read sample.txt  // 텍스트 파일 sample.txt를 읽고 인덱스(여기선, 단어의 목록과 각각의 단어가 파일에 등장한 횟수를 말함)를 만든다.
 * $ find heaven      // heaven이라는 단어가 몇번 나오는지 출력한다.
 * The word "heaven" appears 13 times.
 * $ saveas index.txt // 인덱스를 index.txt라는 파일로 저장한다.
 * $ find java
 * The word "java" does not appear.
 * $ exit
 * 
 * [Code22.java 코드의 문제점]
 * + 소수점, 쉼표 등의 특수기호가 단어에 포함된다.
 * + 숫자 등이 단어로 취급된다.
 * + 대문자와 소문자가 다른 단어로 취급된다.
 * + 단어들이 알파벳 순으로 정렬되면 좋겠다.
 * 이 문제점들을 보완한다.
 */
public class Code23 {
	
	static String[] words = new String[100000]; // 단어들의 배열 정의
	static int[] count = new int[100000]; // 각 단어의 등장 횟수를 담을 배열 정의
	static int n = 0; // 그 목록에 저장된 단어의 개수 n
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) { // true로 무한 반복하도록 함
			System.out.print("$ ");
			String command = sc.next(); // 명령어를 읽는다
			if (command.equals("read")) {
				String fileName = sc.next();
				makeIndex(fileName); // 파일을 읽는 함수 실행
			}
			else if (command.equals("find")) {
				String str = sc.next();
				int index = findWord(str);
				if (index > -1) { // -1이 아니면... -1보다 크면 양수니깐
					System.out.println("The word " + words[index] + " appears " + count[index] + " times.");
				} else { // 찾는 단어가 없는 경우.. 즉 -1인 경우
					System.out.println("The word " + str + " does not appear.");
				}
			}
			else if (command.equals("saveas")) {
				String fileName = sc.next();
				saveAs(fileName); // 파일을 저장하는 함수 실행
			}
			else if (command.equals("exit"))
				break;
		}
		sc.close();
	}
	// 파일을 저장하는 함수 정의
	static void saveAs(String fileName) {
		try {
			PrintWriter outFile = new PrintWriter(new FileWriter(fileName)); // PrintWriter와 FileWriter를 조합하여 사용해서
			for (int i=0; i<n; i++) // 현재 목록에 있는 단어와 단어의 갯수 출력
				outFile.println(words[i] + " " + count[i]); // 콘솔이 아닌 파일로 만들어 출력하기 위해 outFile.println 사용
			
			outFile.close();
		} catch (IOException e) {
			System.out.println("Save failed");
			return;
		}
	}
	
	// 파일을 읽는 함수 정의
	static void makeIndex(String fileName) {
		try {
			Scanner inFile = new Scanner(new File(fileName));
			while(inFile.hasNext()) { // 파일의 끝에 도달했는지 검사해주는 hasNext()
			// hasNext()가 true인 동안에 while문을 돌면서 한번의 한 단어씩 읽으면 되겠다.
				String str = inFile.next();
				// 어떤 파일을 연 후 파일의 끝에 도달할 때까지 어떤 문자열을 하나 읽으면
				String trimmed = trimming(str); // trimming이라는 함수를 이용해서 str 단어 앞 뒤 특수문자를 제거한 다음(trimming 한 다음)에 그 단어를
				
				if (trimmed != null) {// trimmed가 null이 아닐 경우에만,
					String t = trimmed.toLowerCase(); // 대소문자 구분을 안할거기 때문에 애초에 다 소문자로 바꿔서 단어를 저장
					// addWord 함수가 방금 새로읽은 단어 trimmed가 지금까지 내가 읽은 단어들의 목록에 이미 있는지 없는지 검사하고,
					addWord(t); // 이미 목록에 있다면 빈도만 1 증가시켜주고, 그렇지 않으면 새로읽은 단어 trimmed를 목록에 추가해준다.
				}
			}
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			return; // 파일이 없는 경우 이 명령은 무시하고 다시 새로운 명령을 받도록 하는게 적절하므로,
			// 리턴해서 프로그램을 종료하지 않고 다른 명령을 받도록 함
		}
	}
	// 단어 앞, 뒤에 알파벳이 아닌 숫자나 특수문자를 제거하는 일을 하는 함수 정의
	static String trimming(String str) {
		int i = 0, j = str.length()-1;
		while(i < str.length() && !Character.isLetter(str.charAt(i))) // while i번째 캐릭터(char)가 영어 알파벳이 아닌 동안에(is not letter) while문을 돌면서
			i++;
		while(j >= 0 && !Character.isLetter(str.charAt(j))) // 반대 방향에서 똑같은 기능
			j--;
		
		if (i > j) // 아무것도 남는게 없는 경우
			return null;
		// else
		return str.substring(i, j+1); // substring 메서드는 문자열 str을 i에서 j전까지만 딱 남기고 잘라낸 문자열을 반환 // i <= .... <= j+1
	}
	// 단어를 추가 하는 함수 정의
	static void addWord(String str) {
		int index = findWord(str); // return -1 if not found
		if (index != -1) { // (found)   words[index] == str 그 단어가 이미 존재한다는 얘기
			count[index]++; // 단어의 등장 횟수 1 증가
		} else { // (not found)  단어가 존재하지 않고, 새로운 단어가 등장했다는 뜻이므로,
			// 단어들이 추가될 때마다 알파벳 순으로 정렬되게 하기 위해 삽입정렬(insert sort) 적용
			int i = n-1;
			while(i >= 0 && words[i].compareTo(str) > 0) { // word[i]번째 칸에 잇는 애가 내가 지금 추가하려는 str보다 더 큰 동안.. 
														   // 우리가 이미 모든 단어들을 소문자로 바꿔버렸기 때문에, compareTo를 쓰든 compareToIgnoreCase를 쓰든 결과적으로는 똑같다.
				// 뒤쪽으로 1칸씩 밀고,
				words[i+1] = words[i];
				count[i+1] = count[i];
				i--; // i값 1씩 감소
			}
			// while문을 빠져나오면
			words[i+1] = str; // i+1 자리에 문자열을 쓰고
			count[i+1] = 1;  // i+1 자리에 1일 쓰고
			n++; // 그리고 새로운 단어가 추가되었으니 단어 갯수는(n값은) 1 증가
		}
	}
	// 단어가 배열안에 있는지 없는지 검사하는 함수 정의
	static int findWord(String str) {
		for (int i=0; i<n; i++)
			if (words[i].equalsIgnoreCase(str)) // equalsIgnoreCase는 대소문자 구분 없이 검색함
				return i; // 찾는 단어가 있다면 해당 인덱스 리턴
		return -1; // 없다면 -1 리턴
	}
}