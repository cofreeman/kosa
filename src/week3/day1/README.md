# Generic
**제네릭 프로그래밍**
> 프로그램에서 처리할 데이터의 타입을 일반화 시키는 것.
- 재사용성을 높이는 결과가 되며 프로그램에서 처리할 데이터 타입을 객체 생성시에 정한다.
```java
class Value<T>{
    T obj;
    public void get(){
        return obj;
    }
}
Value<String> v1 = new Value<>();
Value<Date> v2 = new Value<>();
```
### 제네릭 클래스의 컴파일 과정 
자바 컴파일러는 제네릭 타입을 "타입 소거(Type Erasure)"라는 과정을 거쳐 일반 클래스로 변환합니다.
기본적으로 Object 타입으로 변환하며, 다음과 같은 경우(상위타입이 제한된 제네릭)에는 제한된 상위타입으로 소거되어 대체됩니다.  
```java
public class LimitedBox<T extends Number>
```

### 제네릭 클래스의 런타임 과정
jvm 이 제네릭 클래스가 heap, method 영역에 어떤 형식으로 로드되나?
method 영역에는 타입 소거된 일반 클래스가 로드 되고 heap 영역에는 타입 소거된 객체가 생성되며 
안의 메서드나 변수중 제네릭 타입이 사용되는 경우, heap 영역에 로드된다.

### 제네릭과 static
제네릭 클래스는 컴파일 과정을 거치면 타입소거가 되어 타입이 정해진 일반 클래스파일로 변환된다.

그렇다면 일반 클래스 파일로 변환된 제네릭 클래스는 static 클래스가 될 수도 있고 static 변수또한 사용가능하다고 생각할 수 있다.

하지만 이는 한가지 간과한것이 있다.
```java
//todo
```

위의 원리로 제네릭 클래스는 static class 가 될 수 없고 generic 한 static 변수 또한 사용 될 수 없다.

# Collection API

