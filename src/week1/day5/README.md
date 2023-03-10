#메서드
자바프로그램의 시작은 main 메서드로 시작된다.
### 오버로딩
하나의 이름으로 많은 명령ㅇ르 수행할 수 있다.

다형성을 지원하는 대표적인 사례

### 가변인자
다형성을 이용하여 가변적으로 인자를 받을 수 있음
```java
method1(int ...i); -> method1(),method(1),method(1,2),method2(new int[]{1,2,3})
method3(char c, int... i);
// 가볍인자 뒤에 인자가 오는것은 허용되지 않음
method(int... i,char c);
```