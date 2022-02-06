// 자바 배열을 어떻게 선언하고 사용하는가?
public class Code05 {

	public static void main(String[] args) {
		// declare the array
		int[] grades = new int[5];
		
/*		int[] grades; // 정수 배열 선언
		grades = new int[5]; // 크기가 5인 정수 배열
		
		만약 실수형 배열을 만들겠다면...
		double[] array;
		array = new double[100]; 혹은 double[] array = new double[100]; 이렇게 한 문장으로 선언할 수도 있음
		
		만약에 문자형 배열을 만들겠다면...
		char[] word;
		word = new char[20]; 혹은 char[] word = new char[20]; 이렇게 한 문장으로 선언할 수도 있음
*/		
		// assign some values to the array
		grades[0] = 100;
		grades[1] = 76;
		grades[2] = 92;
		grades[3] = 95;
		grades[4] = 14;

		// print out each value
		System.out.println(grades[0]);
		System.out.println(grades[1]);
		System.out.println(grades[2]);
		System.out.println(grades[3]);
		System.out.println(grades[4]);
	}
}