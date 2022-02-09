package section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code09 {
	// 여러 메소드에서 공통적으로 사용할 변수를 여기에 정의
	static MyRectangle2[] rects = new MyRectangle2[100]; // 사각형들의 배열의 이름 선언, new 명령어로 지정된 크기의 배열을 생성
	static int n = 0; // 사각형의 개수 n
	
	public static void main(String[] args) {
		
		try {
			Scanner in = new Scanner(new File("data.txt"));
			while(in.hasNext()) {
//				int x = in.nextInt();
//				int y = in.nextInt();
//				int w = in.nextInt();
//				int h = in.nextInt();
				rects[n++] = new MyRectangle2(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()); // 객체 액세스를 위해 MyRectangle1 new 명령어로 생성, 중요!!!
//				n++;
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("No data file.");
			System.exit(1);
		}
		
		bubbleSort(); // 버블정렬 함수 호출
		
		for (int i=0; i<n; i++) 
			System.out.println(rects[i].toString());
	}
	// 버블정렬하는 함수 정의
	private static void bubbleSort() {
		for (int i=n-1; i>0; i--) {
			for (int j=0; j<i; j++) {
				if (rects[j].calcArea() > rects[j+1].calcArea()) { // j번째 사각형의 면적
					// Swap
					MyRectangle2 tmp = rects[j];
					rects[j] = rects[j+1];
					rects[j+1] = tmp;
				}
			}
		}
	}
}