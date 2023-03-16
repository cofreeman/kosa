# 인터페이스
> 모든 클래스가 추상메서드인 클래스
    
인터페이스가 인터페이스를 상속받을 때는 extends 로 상속받는다.
인터페이스는 모든 메서드가 public 이다.

# 인터페이스 상수
초기화 된 상수를 추가할 수 있다.
컴파일러가 public static final 을 붙여준다.

# 매개변수 다형성
부모타입으로 선언된 객체의 메서드를 사용할 때 부모와 자식에 동일한 클래스가 존재하면 자식의 메서드가 실행된다.

```java
class Parent {
    void method() {

    }
}

class Child extends Parent {
    void method() {

    }
}

class Test {
    public static void main(String[] args) {
        Parent child = new Child();
        child.method();
        // Child 클래스의 method 메서드가 실행된다.
    }
}
```
이 현상은 자바의 다형성 때문에 발생합니다. 다형성은 하위 클래스의 인스턴스가 상위 클래스의 인스턴스처럼 취급되고, 실제 실행되는 메서드는 객체의 타입에 따라 결정되는 것입니다.

Parent child = new Child();에서 child 변수는 Parent 타입이지만, 실제로 가리키고 있는 객체는 Child 클래스의 인스턴스입니다. 따라서 child.method();를 호출하면, 컴파일러는 런타임 시점에 실제 객체 타입인 Child 클래스의 method() 메서드를 실행합니다.
