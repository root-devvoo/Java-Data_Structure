### 메서드와 생성자

- 클래스는 서로 관련있는 데이터들을 하나의 단위로 묶어두기 위한 것이다.
- 하지만 이것이 전부가 아니다.
- 서로 관련있는 데이터들 뿐 아니라, 그 데이터와 관련이 깊은 메서드도 함께 묶어 둘 수 있다.
- 이렇게 함으로써 코드의 응집도(cohesion)를 높이고 결합도(coupling)를 낮출 수 있다.

![image](https://user-images.githubusercontent.com/78403443/152979872-8d92a791-c187-4e7d-81c3-59ef19b3d768.png)

![image](https://user-images.githubusercontent.com/78403443/152981416-5a2e89f2-1e00-458d-b048-bb22ef492071.png)

![image](https://user-images.githubusercontent.com/78403443/152983643-023bc46f-b401-430e-bc27-0881bae84ad2.png)

![image](https://user-images.githubusercontent.com/78403443/152984747-653c58eb-0fef-418b-bae9-aab828dd9017.png)

![image](https://user-images.githubusercontent.com/78403443/152984973-312f0f7a-51c2-416f-ac6f-bbbdf18fceb3.png)

![image](https://user-images.githubusercontent.com/78403443/152985201-19f8b978-3b7f-4ddc-8454-c39b37ea86b1.png)

---

(2/3)

#### 생성자

- 클래스 안에 그 클래스와 동일한 이름을 가지며 return 타입이 없는 특별한 메서드를 둘 수 있다. 이것을 생성자(constructor)라고 부른다.
- 생성자는 new 명령으로 객체가 생성될 때 자동으로 실행된다. <u>주 목적은 객체의 데이터 필드의 (내가 원하는 값으로) 값을 초기화</u>하는 것이다.

![image](https://user-images.githubusercontent.com/78403443/153127398-0d2ce19f-faf2-4369-9c29-b6148e9d8fe6.png)

생성자를 사용하면 코드를 간단, 명료하게, 가독성 높게 할 수 있다.

![image](https://user-images.githubusercontent.com/78403443/153128045-6a9b73cf-89b3-4e4b-b53b-92f6782a1c35.png)

![image](https://user-images.githubusercontent.com/78403443/153128320-78672e20-7a4c-441b-a7ea-09eaa9cec0e1.png)

모든 클래스가 생성자를 가져야하는 것은 아니지만, 생성자를 만들어두면 유용하다!

![image](https://user-images.githubusercontent.com/78403443/153129170-c5fd1a65-8b7f-4fec-935f-be69a095e001.png)

<br>

제2-1장(Chapter2 Section1 패키지)에서 다뤘던 직사각형 여러개를 입력받아서 면적에 대한 오름차순으로 정렬하는 것을 했었는데(Code05.java, MyPoint1.java, MyRectangle1.java), 그 프로그램에 생성자를 적용해서 다시 짜본다. 

![image](https://user-images.githubusercontent.com/78403443/153130622-4d403ef0-826a-49ee-a488-b5af32bef124.png)

![image](https://user-images.githubusercontent.com/78403443/153131055-b99b15f8-14a8-4add-8a37-a506534b70e3.png)

(Code09.java, MyRectangle2.java, MyPoint2.java 파일)

![image](https://user-images.githubusercontent.com/78403443/153137490-04804a26-9dee-425e-b1bd-a909ff2d8710.png)

---

(3/3)

![image](https://user-images.gitㄴㄴhubusercontent.com/78403443/153139048-66b1790d-2f23-46c1-a7ef-92b19dab0034.png)

![image](https://user-images.githubusercontent.com/78403443/153140262-51e2490d-84d8-448d-87df-dc60caa48d41.png)

OrthoLine.java : 수직선분이나 수평선분을 표현하기 위한 클래스

![image](https://user-images.githubusercontent.com/78403443/153144447-1562d940-c67f-4ae6-9375-41efdc90596c.png)

두 선분이 교차하기 위해서는 수평 선분의 양 끝점이 수직 선분의 양 쪽에 하나씩 있어야된다는 것이고, 또 수직 선분의 양 끝점은 수평 선분의 양쪽에 하나씩.. 하나는 위에 하나는 아래에.. 이런 조건을 만족해야 두 선분이 교차하게 되고, 또 그런 조건을 만족하면 두 선분은 교차하게 된다. (노란색 표시)

![image](https://user-images.githubusercontent.com/78403443/153149937-55e14684-3daa-40c4-ba93-cd4c68ed4340.png)

만약에 `p.x`가 `q.x`보다 크다면 그 얘기는 `p`는 오른쪽에 있고 `q`는 왼쪽에 있고... 이 경우는 선분은 수평 선분, 그런 경우에는 이 두 점을 `swap()`하겠다는 것이다. `swap()`함수는 u와 v를 자리를 바꾸는 전형적인 swap하는 것.<br>그래서, 만약에 두 점이 들어왔는데, `p`가 `q`보다 더 오른쪽에 있다면 `p`, `q`의 자리를 바꿔서 항상 `u`가 왼쪽점 `v`가 오른쪽점 이렇게 되게 만들어두겠다는 뜻이다. (노란색 표시 참고)

그 다음에 수직 선분의 경우에도 만약에 `p.x`와 `q.x`가 같고(즉, 일단 수직선이고), 그러면서 `p.y`가 `q.y`보다 더 크다는 얘기는 `p`의 y좌표가 더 크다는거니까 그 경우에도 swap을 해서 항상 수직선의 경우에는 y좌표가 더 작은 쪽을 `u`, 수평선의 경우에는 x좌표가 더 작은 쪽을 u 이렇게 부르도록 만들어준 것이다. (파란색 표시 참고)

(※ 헷갈림 주의... 여기 강의에서는 y좌표가 아래로 갈수록 더 크다고 하고 있음)

![image](https://user-images.githubusercontent.com/78403443/153153427-606f4d9d-f235-49db-b571-b632928d05a9.png)

(이런 경우 교차하는지 안하는지 문제는 피해가고 있음(이런 경우는 없다고 가정), 기하학적으로 문제를 풀자는게 아니기 때문에)

OrthoLine 클래스는 하나의 선분을 표현하는 클래스이다. 우리는 다각형이 있어야 한다.

OrthoPolygon.java : 직교 다각형을 표현하는 클래스

마지막으로 메인함수를 포함할 코드는 Code10.java

![image](https://user-images.githubusercontent.com/78403443/153159345-d8674eb4-5884-453c-985a-0539dda375cf.png)