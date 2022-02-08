package Section1;

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
 */
public class IndexMaker {
	
//	static String[] words = new String[100000]; // 단어들의 배열 정의
//	static int[] count = new int[100000]; // 각 단어의 등장 횟수를 담을 배열 정의
	static Item[] items = new Item[100000]; // 대신해서, Items 타입의 배열 객체를 생성
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
					System.out.println("The word " + items[index].word + " appears " + items[index].count + " times.");
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
				outFile.println(items[i].word + " " + items[i].count); // 콘솔이 아닌 파일로 만들어 출력하기 위해 outFile.println 사용
			
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
		if (index != -1) { // (found)  그 단어가 이미 존재한다는 얘기
			items[index].count++; // 단어의 등장 횟수 1 증가
		} else { // (not found)  단어가 존재하지 않고, 새로운 단어가 등장했다는 뜻이므로,
			// 단어들이 추가될 때마다 알파벳 순으로 정렬되게 하기 위해 삽입정렬(insert sort) 적용
			int i = n-1;
			while(i >= 0 && items[i].word.compareTo(str) > 0) {
				// 뒤쪽으로 1칸씩 밀고,
				items[i+1] = items[i];
//				words[i+1] = words[i];
//				count[i+1] = count[i];
				i--; // i값 1씩 감소
			}
			items[i+1] = new Item(); // 접근 전 객체 생성 반드시!!!!
			// while문을 빠져나오면 단어 추가
			items[i+1].word = str; 
			items[i+1].count = 1;
			n++;
		}
	}
	// 단어가 배열안에 있는지 없는지 검사하는 함수 정의
	static int findWord(String str) {
		for (int i=0; i<n; i++)
			if (items[i].word.equals(str)) // equalsIgnoreCase는 대소문자 구분 없이 검색함
				return i; // 찾는 단어가 있다면 해당 인덱스 리턴
		return -1; // 없다면 -1 리턴
	}
}