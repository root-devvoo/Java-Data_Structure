package Section1;

public class Code01 {
	public static void main(String[] args) {
		Person1 first;
		// 하나의 Person1 타입의 객체(object)를 생성하고 그것을 first라고 한다.
		first = new Person1(); // object (객체)
		
		// first객체의 name필드와 number 필드에 이름과 전화번호를 각각 저장한다.
		first.name = "John"; // Person객체 필드를 액세스하기 위해서 Person객체.name, Person객체.number
		first.number = "012483120"; // 저장
		
		System.out.println("Name: " + first.name + ", Number:" + first.number); // first.number는 first가 가리키는 Person1 객체의 number 필드를 의미한다.
		
		Person1[] members = new Person1[100]; // Person1 타입의 배열도 만들 수 있다.
		members[0] = first;
		members[1] = new Person1();
		members[1].name = "David";
		members[1].number = "254789798543";
		
		System.out.println("Name: " + members[1].name + ", Number:" + members[1].number);
	}
}