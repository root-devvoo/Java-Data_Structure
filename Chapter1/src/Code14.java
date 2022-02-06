import java.util.Scanner;

// 정렬을 다뤄본다.
/*
 * 사용자로부터 n개의 정수를 입력받은 후
 * 오름차순으로 정렬(sort)하여 출력하는 코드이다.
 */
public class Code14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n];
		
		for (int i=0; i<n; i++)
			data[i] = sc.nextInt();
		sc.close();
		// 버블정렬(bubblesort) 알고리즘
		for (int i=n-1; i>0; i--) { // i는 sort 대상인 마지막 데이터의 배열 인덱스를 표시
			// data[0] ~ data[i] 중에서 (다른 값들이 어떻게 되건 상관하지 않고) 최대값을 data[i] 위치로 몰아가는 일을 함
			for (int j=0; j<i; j++) { // j는 i-1까지만 가면 된다.
				if (data[j] > data[j+1]) { // data[j]가 data[j+1]보다 크면 자리를 바꾼다.
					// swap
					int tmp = data[j]; // 스왑을 할 때는 잠깐 임시로 다른 곳에 써두고
					data[j] = data[j+1]; // 그러면 그 자리에 내가 다른 값을 덮더라도 상관이 없으니까 그 자리에 쓰고,
					data[j+1] = tmp; // 다른쪽에는 임시로 저장해뒀던 값을 쓰면 두 값의 교환이 이루어진다.
				}
			}
		}
		System.out.println("Sorted data: ");
		for (int i=0; i<n; i++)
			System.out.println(data[i]);
	}
}