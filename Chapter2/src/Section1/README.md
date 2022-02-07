### 클래스

- 한 사람의 "이름"과 "전화번호"는 항상 같이 붙어다녀야 하는 데이터이다.
- 이 두 가지 데이터를 서로 별개의 변수에 저장하면 우리가 이름 데이터를 옮길 때 마다 전화번호 데이터도 따로 옮겨줘야 한다.
- 만약 각 사람에 대해서 이름과 전화번호 뿐만 아니라 주소, 이메일 등 여러 가지 데이털르 저장한다면 이 불편은 더 심해질 것이다.
- 인덱스 메이커 프로그램에서도 "하나의 단어"와 그 단어의 "등장 횟수"는 항상 같이 붙여다녀야 하는 데이터이다.
- 이렇게 서로 관련있는 데이터들을 하나의 단위로 묶어두면 편할 것이다.
- 이것이 클래스라는 개념이 등장하는 가장 기본적인 이유이다.

![image](https://user-images.githubusercontent.com/78403443/152760213-7f6f5c4c-11b1-45fb-acb3-cf633338e686.png)

- 클래스는 결국 하나의 "타입"이다. 마치 int, double 등 처럼.

- 다만 int, double 처럼 Java가 미리 정해놓은 타입이 아니라 사용자가 정의한 새로운 타입이라는 의미에서 "사용자 정의 타입"이라고 부르기도 한다.

- int 혹은 double 형 변수를 선언하고 사용하는 것처럼 Person1형 변수를 선언하고 사용한다.

  ```java
  int count = 0;
  Person1 first = new Person();
  ```

![image](https://user-images.githubusercontent.com/78403443/152760727-38fcadcf-b1d7-42f2-ba91-1a92764c20c5.png)

![image](https://user-images.githubusercontent.com/78403443/152761722-ce0fafd1-3f3c-49cd-92fa-b5dbd153abb1.png)

### 참조 변수

모든 프리미티브 타입의 변수는 <u>보통 변수</u>이다.<br>즉, 변수 자체에 값이 저장된다.

**프리미티브 타입이 아닌 모든 변수는 <u>참조 변수</u>이다.**<br>즉, 실제 데이터가 저장될 "객체"는 new 명령으로 따로 만들어야 하고,<br>참조변수에는 그 객체의 주소를 저장한다.

![image](https://user-images.githubusercontent.com/78403443/152763442-771bf4b0-aad7-45ca-af91-efd44d4f2696.png)

클래스는 하나의 타입이고, 이런 클래스 타입의 변수를 참조 변수라고 부르고,<br>이 참조 변수가 int나 double형 변수 즉, 프리미티브 타입의 변수와 다른점은 프리미티브 타입의 변수는 그 변수 안에 값이 저장이 되지만, 참조 변수는 값이 저장되는 객체는 항상 따로 있어야하고, 이 객체는 항상 new라는 명령어에 의해서만 만들어지고, 참조 변수는 그냥 그 객체를 참조하고 있다 즉, 그 객체의 주소를 저장한다.

이것이 가장 기본이 되는 규칙이다.

![image](https://user-images.githubusercontent.com/78403443/152790514-d98e9e49-217c-4c58-9d6d-2deb7b8a122e.png)

이 슬라이드가 설명하는 것은 참조 변수가 뭐다... 그리고 Person1 타입의 배열이 있을 때 그 배열의 각각의 칸도 역시 Person1 타입의 참조 변수가 된다는 얘기이다.

### 클래스와 객체

int는 프리미티브 타입이지만, int배열은 프리미티브 타입이 아니다. (배열이 프리미티브 타입이 아니니까)

프리미티브 타입(Primitive Type)은 int, double, float, boolean, short 이런 것들...<br>1장에서 [변수의 타입](https://github.com/iceman-brandon/Java-Data_Structure/blob/main/Chapter1/src/%EB%B3%80%EC%88%98%EC%9D%98%20%ED%83%80%EC%9E%85.png)에서 프리미티브 타입이라고 명시했던 오로지 그것만 프리미티브 타입이다. 그것을 제외한 어떤 것도 프리미티브 타입이 아니다.

프리미티브 타입이 아닌 모든 변수는 무조건 '참조 변수'이다!

![image](https://user-images.githubusercontent.com/78403443/152792920-a1ef2538-f09f-4568-b913-89c7e9fa40e6.png)

`int num[100];` 이런식으로 어떻게 보면 좀 더 단순한 방법으로 배열을 선언하지 않고, 자바에서 `int[] numbers = new int[8];` 이렇게 복잡한 방법으로 배열을 선언하는 이유는 이걸 좀 더 정확하게 하기 위해서이다.

그러니까 numbers라는 것은 "배열에 주소를 저장하는 참조 변수이고, 그리고 배열 자체는 new 명령어에 의해서 따로 생성되어야 한다." 라는 것을 좀 더 명시적으로 드러내기 위해서 자바에서는 이런 문법을 사용하는 것이다.

그리고 이 배열이 지금 정수형 배열이기 떄문에, 이 배열의 각각의 칸은 정수형 변수로 우리가 생각하면 된다. 그리고, 정수형 int라는 것 자체는 프리미티브 타입이기 때문에 이 배열의 각각의 칸은 프리미티브 타입의 변수이다. 프리미티브 타입의 변수라는 것은 그 변수 자체에 값이 저장되는...그러니까, 또 누군가를 참조하는, 누군가의 주소를 저장하는게 아니라 그냥 값 자체가 거기에 저장된다는 뜻이다.

![image](https://user-images.githubusercontent.com/78403443/152794548-441a59a6-93ef-49db-8511-67d707f2fcc9.png)

그래서 아래와 같이 해야한다.

![image](https://user-images.githubusercontent.com/78403443/152795444-a195d954-5a57-4114-844c-fcf8662cc585.png)

### 값에 의한 호출: 배열

![image](https://user-images.githubusercontent.com/78403443/152796811-a4a2f6b8-35f3-4bfe-8f90-31605e72ffd3.png)

### Code02.java

![image](https://user-images.githubusercontent.com/78403443/152797117-f2054563-cc13-4553-b7ab-73326333970e.png)