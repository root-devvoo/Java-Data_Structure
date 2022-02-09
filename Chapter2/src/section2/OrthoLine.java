package section2;
// 수직선분이나 수평선분을 표현하기 위한 클래스

public class OrthoLine {
	// 선분이라는건 양 끝점에 의해서 정의되는거니까...
	public MyPoint2 u; // 두 점
	public MyPoint2 v;
	
	public OrthoLine(MyPoint2 p, MyPoint2 q) { // 선분의 양 끝점 역할을 할 두개의 포인트 p, q를 받아서
		u = p;
		v = q;
		if (p.x > q.x || p.x == q.x && p.y > q.y) {
			swap();
		}
	}
	
	public void swap() {
		MyPoint2 tmp = u;
		u = v;
		v = tmp;
	}
	
	public OrthoLine(int x1, int y1, int x2, int y2) { // 한쪽 점의 x좌표, y좌표 다른 쪽 끝 점의 x좌표, y좌표를 받음
		u = new MyPoint2(x1, y1);
		v = new MyPoint2(x2, y2);
	}
	
	public boolean isVertical() { // 내가 수직 선분인지를 검사해주는 함수 
		return u.x == v.x; // u.x와 v.x가 같으면 수직 선분이니, true를 리턴
	}
	// 가장 중요! 어떤 2개의 선분이 교차하는지를 검사하는 일을 하는 함수 정의
	public boolean intersects(OrthoLine other) {
		// 자기 자신이 이미 선분의 일부분이니까 교차검사는 그냥 다른 선분 하나를 입력으로 받아서, 그 다른 선분과 내가 교차하는지를 검사
		if (isVertical() && !other.isVertical()) { // 내가 수직 선분이고, 다른 선분이 수직 선분이 아닌 경우
			return (other.u.x < u.x && other.v.x > u.x && u.y < other.u.y && v.y > other.u.y);
		}
		else if (!isVertical() && other.isVertical()) { // 내가 수직 선분이 아니고, 다른 선분이 수직 선분인 경우 
			return (other.u.y < u.y && other.v.y > u.y && u.x < other.u.x && v.x > other.u.x);
		}
		else // else라면 둘다 수직선이거나 둘다 수평선이라는 거니까
			return false;
	}
}
