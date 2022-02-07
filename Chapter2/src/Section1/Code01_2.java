package Section1;

public class Code01_2 {
	public static void main(String[] args) {
		Person1 first;
		first = new Person1();
		
		first.name = "John"; 
		first.number = "012483120";
		
		System.out.println("Name: " + first.name + ", Number:" + first.number); 
		
		Person1 second = first;
		second.name = "Tom";
		System.out.println("Name: " + first.name + ", Number:" + first.number); 
//		System.out.println("Name: " + second.name + ", Number:" + second.number); 
		
		Person1[] members = new Person1[100];
		members[0] = first;
		members[1] = second;
		System.out.println("Name: " + members[0].name + ", Number:" + members[0].number);
		System.out.println("Name: " + members[1].name + ", Number:" + members[1].number);
		
		members[2] = new Person1(); // 이렇게 해줘야 이름, 전화번호로 구성되있는 객체가 배열에 들어간다
		members[2].name = "David";
		members[2].number = "2376457264";
		
		System.out.println("Name: " + members[2].name + ", Number:" + members[2].number); 
	}
}