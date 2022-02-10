### Static & Non-static

![image](https://user-images.githubusercontent.com/78403443/153329627-aa680bd7-c627-488b-b9ee-2e0c8c36ef6b.png)

![image](https://user-images.githubusercontent.com/78403443/153329706-9fde6ac2-87a2-4f83-90a5-9b97816f1d48.png)

![image](https://user-images.githubusercontent.com/78403443/153330207-16133c78-f924-4be7-88ae-a85ec1ce7046.png)

내가 객체를 2개 만들면 t는 2개가 존재. 각각의 객체마다 따로따로 멤버가 존재.. Non-static 멤버는 객체를 생성할 때마다 별개로 존재한다는 것이다.

static은 클래스 안에 존재한다. (클래스는 오직 1개만 존재) 그리고, 객체에는 s라는 멤버는 존재하지 않는다.

**Questions**

- 왜 main 메서드는 반드시 static이어야 하는가?
  - 자바에서는 프로그램이라는건 순수하게 클래스들의 집합이고, 클래스 외부에 있을 수 있는 것은 아무것도 없다. 그렇기 때문에 메인함수조차도 어떤 클래스 안에 들어가야만 한다.
  - 그냥 클래스로 존재하는 상태에서는 어떤 일도 할 수가 없다. 클래스 안에 있는 어떤 메서드를 실행하려면 그 자체로는 실행할 수 없고, 누군가가 이 클래스의 객체를 new명령어로 만들어서 그 다음에 그 객체 안에 있는 메서드를 실행하는 것이므로...
  - 그래서 메인 메서드는 static이어야만 한다.
  - 메인이라는 것은 프로그램의 출발점이니까 누군가 이 메인이 속해있는 클래스 객체를 만들 수 없다.
- 왜 static메서드에서 같은 클래스의 non-static 멤버를 엑세스 할 수 없는가?
  - (Test.java 참고)
- 다른 클래스에 속한 static 멤버는 어떻게 엑세스하는가?
  - (TestTest.java 참고)
- static 메서드/필드의 용도는?

![image](https://user-images.githubusercontent.com/78403443/153334180-30e6ea46-ec07-468e-bcbc-7a2b824371cd.png)

수학 함수들... 예를 들면, abs.. 절대값을 구하는 함수인데, 절대값을 구하는 함수는 어떤 객체 안에 들어가 있을 이유가 별로 없다. 왜냐하면, 어떤 객체 안에 들어가 있든 이 함수는 매개변수로 들어오는 값이 무엇인지에 따라서 이 함수가 하는 일이 정의되는 것이기 때문.<br>이 객체 안에 있는 다른 멤버나 다른 데이터 필드랑은 완전히 독립적인 것이다. 그렇기 때문에, (따로따로 존재하게 될) 객체 안에 이 함수를 굳이 넣을 이유가 없다.

(반드시 static으로 정의해야되는 것은 아님, 필요에 따라 다르다)

![image](https://user-images.githubusercontent.com/78403443/153334314-6236c853-fbcf-4dec-aee3-2a52f744aa06.png)

Code11.java 보기

---

### 접근제어: public, private, default, protected

- public: <u>클래스 외부</u>에서 접근이 가능하다.
- private: <u>클래스 내부에서만</u> 접근이 가능하다.
- default: <u>동일 패키지에 있는 다른 클래스</u>에서 접근 가능하다. (아무것도 안쓰는)
- protected: <u>동일 패키지의 다른 클래스</u>와 다른 패키지의 <u>하위클래스</u>에서도 접근 가능하다.

![image](https://user-images.githubusercontent.com/78403443/153347729-ddef5cdf-f7f1-4cba-81cb-08d53257b46f.png)