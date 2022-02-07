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
 */
public class Code22 {
	
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
				// addWord 함수가 방금 새로읽은 단어 str이 지금까지 내가 읽은 단어들의 목록에 이미 있는지 없는지 검사하고,
				addWord(str); // 이미 목록에 있다면 빈도만 1 증가시켜주고, 그렇지 않으면 새로읽은 단어 str을 목록에 추가해준다.
			}
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			return; // 파일이 없는 경우 이 명령은 무시하고 다시 새로운 명령을 받도록 하는게 적절하므로,
			// 리턴해서 프로그램을 종료하지 않고 다른 명령을 받도록 함
		}
	}
	// 단어를 추가 하는 함수 정의
	static void addWord(String str) {
		int index = findWord(str); // return -1 if not found
		if (index != -1) { // (found)   words[index] == str
			count[index]++; // 단어의 등장 횟수 1 증가
		} else { // (not found)  새로운 단어가 등장했다는 뜻이므로
			words[n] = str; // 이미 기존에 n개의 단어가 있으니까 얘는 n+1번째 단어, 배열 인덱스는 0부터 시작하므로 n임. 거기에 새로운 단어 저장해줌
			count[n] = 1; // 그 단어의 count는 1이 된다. 처음으로 단어가 나온거니까
			n++; // 그리고 목록에 있는 단어 갯수는 1 증가
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