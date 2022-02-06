package Section2;

import java.util.Scanner;

// 사용자로부터 n개의 정수를 입력받은 후 오름차순으로 정렬(sort)하여 출력하는 코드이다.
// (버블정렬)
public class Code18 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n];
		for (int i=0; i<n; i++)
			data[i] = sc.nextInt();
		sc.close();
		
		// 1. 메서드 bubbleSort를 호출하면서 매개변수로 배열 data와 n의 값을 건낸다.
		bubbleSort(n, data); // 배열에 n개의 데이터가 저장되어있는데, 그 배열을 통째로 (매개변수로) 넘겨줘야 정렬을 할 수 있다.
			                 // 이렇게 배열을 넘겨주면 된다. 그리고, 데이터의 개수 n도 함께 넘겨준다.
		System.out.println("Sorted data: ");
		for (int i=0; i<n; i++)
			System.out.println(data[i]);
	}
	// 2. 메서드 bubbleSort는 매개변수로 하나의 배열과 하나의 정수를 건내 받으며 각각을 data와 n이라고 이름 짓는다.
	static void bubbleSort(int n, int[] data) { // 얘는 자기가 받은 배열 안에 있는 데이터들을 정렬하는 것이 임무이다. 다른 값을 리턴해줄 필요는 없으니 void
		for (int i=n-1; i>0; i--) { 
			for (int j=0; j<i; j++) { 
				if (data[j] > data[j+1]) { 
					// swap data[j] and data[j+1]
					int tmp = data[j];
					data[j] = data[j+1]; 
					data[j+1] = tmp; 
					// 3. 메서드 bubbleSort는 아무 것도 return하지 않는다. 하지만 이 메서드가 한 일은 배열 data에 이미 반영되어 있다.
				}
			}
		}
	}
}