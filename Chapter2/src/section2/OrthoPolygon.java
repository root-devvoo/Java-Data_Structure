package section2;
// 하나의 직교 다각형을 표현하기 위한 클래스
public class OrthoPolygon {
	public int n;
	public MyPoint2[] vertices; // 꼭지점은 꼭지점들(vertices)이란 배열에 저장한다.
	
	public OrthoPolygon(int k) { // 다각형을 구성하는 꼭지점의 개수만 입력을 받아서
		n = 0; // n은 실제로 입력된 꼭지점의 개수를 표현
		vertices = new MyPoint2[k];
	}
	
	public void addVertex(int x, int y) { // Vertex는 꼭지점이라는 뜻이다. 한 점의 좌표 x, y를 입력받아서
		vertices[n++] = new MyPoint2(x, y); // 꼭지점을 하나씩 순차적으로 추가를 해준다
	}
	
	public int maxX() { // 검사하는 선을 외부로 완전히 빠지게 하기 위해서 꼭지점들 중 x값이 최대인 것을 구함
		int max = vertices[0].x;
		for (int i=0; i<n; i++) {
			if (vertices[i].x > max)
				max = vertices[i].x;
		}
		return max;
	}
	
	public boolean contain(MyPoint2 p) { // 이 다각형이 어떤 또다른 점 p를 내부에 포함하고 있는지 아닌지를 검사해주는 메소드
		OrthoLine arrow = new OrthoLine(p, new MyPoint2(maxX()+1, p.y)); // 검사하는 수평선 만듬, 검사하는 수평선이 다각형을 완전히 벗어나게 한다.
		int count = 0;
		for (int i=0; i<n; i++) {
			OrthoLine edge = new OrthoLine(vertices[i], vertices[(i+1) % n]); // 다각형에서 i번째 변이라는 것은 i번째 꼭지점과 i+1번째 꼭지점을 연결하면 그게 i번째 변이 된다.
																			  // (맨 마지막 꼭지점은 다시 0번 꼭지점하고 연결되는거니까 [(i+1) % n]을 해준다. 맨 마지막에 도달했을 때 0번과 다시 연결되도록)
			// 그래서 vertices[i]과 vertices[i+1]을 양 끝점으로 하는 직교 선분을 우리가 edge라고 한 다음에
			if (arrow.intersects(edge)) // 만약에 arrow(검사하는 수평선)가 edge와 교차하면
				count++; // 카운트 증가
		}
		return (count % 2 == 1); // 홀수면 포함, 짝수면 포함하지 않는거니까
		// 여기에서 이렇게 리턴하면 점을 내부에 포함하고 있는지 아닌지 true, false로 리턴해준다.
	}
}
