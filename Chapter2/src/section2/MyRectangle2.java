package section2;
// 하나의 직사각형을 표현하기 위한 클래스
public class MyRectangle2 {
	public MyPoint2 lu; // left upper 하나의 사각형은 왼쪽, 위쪽 꼭지점과
	public int width; // 너비
	public int height; // 높이
	
	public MyRectangle2(int x, int y, int w, int h) {
		lu = new MyPoint2(x, y);
		this.width = w;
		this.height = h;
	}
	
	// 여기서 쓰는 생성자는 아니지만...
	public MyRectangle2(MyPoint2 p, int w, int h) { // 매개변수를 어떻게 주느냐에 따라 어떤 생성자를 쓰는지 결정됨
		lu = p;
		this.width = w;
		this.height = h;
	}
	
	// 사각형의 면적 구하는 함수 정의
	public int calcArea() { // 지금은 calcArea가 어떤 사각형의 일부분이니까 자기 자신의 면적을 계산해서 리턴
		return width * height; // 면적 = 너비 x 높이(세로)
	}

	// 어떤 사각형의 자신의 꼭짓점 좌표와 너비, 높이 정보를 포함하는 하나의 문자열을 이렇게 만들어서 구성해서 리턴해주는 toString 함수를 가지고 있다면
	public String toString() { // 메인 함수에 출력이 간단해지고, 추상적이게 됨
		return "(" + lu.x + " " + lu.y + ") " + width + " " + height;
	}
}