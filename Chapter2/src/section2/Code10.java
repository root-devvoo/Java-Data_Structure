package section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 여기에서는 입력 파일을 읽어서 실제 코드 실행
public class Code10 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("data.txt"));
			int n = sc.nextInt();
			OrthoPolygon thePolygon = new OrthoPolygon(n);
			for (int i=0; i<n; i++)
				thePolygon.addVertex(sc.nextInt(), sc.nextInt());
			MyPoint2 thePoint = new MyPoint2(sc.nextInt(), sc.nextInt());
			sc.close();
			
			if (thePolygon.contain(thePoint))
				System.out.println("Yes");
			else
				System.out.println("No");
			
		} catch (FileNotFoundException e) {
			System.out.println("No data file exists.");
			System.exit(1);
		}
	}
}