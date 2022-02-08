package Section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code05 {
	// 여러 메소드에서 공통적으로 사용할 변수를 여기에 정의
	static MyRectangle1[] rects = new MyRectangle1[100]; // 사각형들의 배열의 이름 선언, new 명령어로 지정된 크기의 배열을 생성
	static int n = 0; // 사각형의 개수 n
	
	public static void main(String[] args) {
		
		try {
			Scanner in = new Scanner(new File("data.txt"));
			while(in.hasNext()) {
				rects[n] = new MyRectangle1(); // 객체 액세스를 위해 MyRectangle1 new 명령어로 생성, 중요!!!
				rects[n].lu = new MyPoint1();  // 객체 액세스를 위해 MyPoint1 new 명령어로 생성, 중요!!!
				
				rects[n].lu.x = in.nextInt();
				rects[n].lu.y = in.nextInt();
				rects[n].width = in.nextInt();
				rects[n].height = in.nextInt();
				n++;
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("No data file.");
			System.exit(1);
		}
		
		bubbleSort(); // 버블정렬
		
		for (int i=0; i<n; i++) 
			System.out.println(rects[i].lu.x + " " + rects[i].lu.y + " " + rects[i].width + " " + rects[i].height);
	}
	// 버블정렬하는 함수 정의
	private static void bubbleSort() {
		for (int i=n-1; i>0; i--) {
			for (int j=0; j<i; j++) {
				if (calcArea(rects[j]) > calcArea(rects[j+1])) { // j번째 사각형의 면적
					// Swap
					MyRectangle1 tmp = rects[j];
					rects[j] = rects[j+1];
					rects[j+1] = tmp;
				}
			}
		}
	}
	// 사각형의 면적 구하는 함수 정의
	public static int calcArea(MyRectangle1 r) {
		return r.width * r.height; // 면적 = 가로 x 높이(세로)
	}
}