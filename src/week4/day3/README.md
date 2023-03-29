# 람다식 메서드 참조

### 정적 메서드와 인스턴스 메서드 참조
- 람다식에서 정적 메소드를 참조할 경우 클래스 이름 뒤에 :: 기호를 붙이고 정적 메소드 이름을 기술
- 인스턴스 메소드일 경우에는 객체를 생성한 다음 참조 변수 뒤에 :: 기호를 붙이고 인스턴스 메소드 이름을 기술

추상메서드가 단 하나인 인터페이스를 정의한 후 메서드를 구현한다.
이 때 메서드가 하나 뿐이니 그것을 구현한 코드만 작성해주면 된다.
이제 (구현한 인터페이스.메서드이름(변수)) 를 쓰면 함수형 프로그래밍 완성

### Functional Interface with 가변인자, 제네릭
**다음과 같은 경우에는 람다식이 어떻게 쓰일까?**
```java
interface ActionExpression {
	void exec(Object... param);
}

interface FuncExpression<T> {
	T exec(Object... param);
}
```
