import java.util.Scanner;

/* n개의 정수를 입력받아 순서대로 배열에 저장한다.
 * 그런 다음 모든 정수들을 한 칸씩 오른쪽으로 shift(이동)하라.
 * 마지막 정수는 배열의 첫 칸으로 이동하라.
 * (circular shift)
 */
public class Code09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n];
		// n개의 숫자들 입력 받음
		for (int i=0; i<n; i++)
			data[i] = sc.nextInt();
		sc.close();
		
		int tmp = data[n-1]; // 배열의 맨 마지막 값 n-1을 임시(tmp)변수에 맨 마지막 값을 keep해둠 
		for (int i=n-2; i >= 0; i--) {// 맨 마지막 값을 제외한 끝에서 2번째 값(n-2)부터 1번째 값까지를  
			data[i+1] = data[i]; // 전부 1칸 씩 뒤로 쉬프트 (data[i]번지에 있던 애를 [i+1]번지로 보냄)
		}
		data[0] = tmp;
		
		for (int i=0; i<n; i++)
			System.out.println(data[i]);
	}
}