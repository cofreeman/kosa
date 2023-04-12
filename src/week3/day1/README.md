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
## 제네릭 클래스의 컴파일 과정 
자바 컴파일러는 제네릭 타입을 "타입 소거(Type Erasure)"라는 과정을 거쳐 일반 클래스로 변환합니다.
기본적으로 Object 타입으로 변환하며, 다음과 같은 경우(상위타입이 제한된 제네릭)에는 제한된 상위타입으로 소거되어 대체됩니다.  
```java
public class LimitedBox<T extends Number>
```

## 제네릭 클래스의 런타임 과정
jvm 이 제네릭 클래스가 heap, method 영역에 어떤 형식으로 로드되나?
method 영역에는 타입 소거된 일반 클래스가 로드 되고 heap 영역에는 타입 소거된 객체가 생성되며 
제네릭 타입의 멤버 변수는 heap 영역에 로드된다.

## 제네릭의 장점
|-| 장점      ||
|---|---------|-------------------------------------|
| 1 | 타입 안정성  | 원하지 않는 타입의 객체 추가 시 컴파일 시간에 막을 수 있다. |
| 2 | 코드 재사용성 | 타입 캐스팅 x, 클래스 재사용 o                 |
| 3 | 간결성     | 타입 캐스팅 x                            |
| 4 | 가독성     | 타입 캐스팅 x, List< String>같은 명확한 타입 정보 o |


|제네릭을 사용하지 않는 경우|
|---|
```java
public class NonGenericStack {
    private Object[] elements;
    private int top;

    public NonGenericStack(int size) {
        elements = new Object[size];
        top = -1;
    }

    public void push(Object element) {
        elements[++top] = element;
    }

    public Object pop() {
        return elements[top--];
    }
}
```
|사용할 때마다 타입캐스팅이 발생한다. |
|---------------------|
```java
NonGenericStack stack = new NonGenericStack(10);
stack.push("Hello");
String s = (String) stack.pop(); // 타입 캐스팅이 필요

```
| 제네릭을 사용하는 경우 |
|--------------|
```java
public class GenericStack<T> {
    private T[] elements;
    private int top;

    public GenericStack(int size) {
        elements = (T[]) new Object[size];
        top = -1;
    }

    public void push(T element) {
        elements[++top] = element;
    }

    public T pop() {
        return elements[top--];
    }
}
```
|이 경우 타입 캐스팅이 필요없다.|
|---|
```java
GenericStack<String> stack = new GenericStack<>(10);
stack.push("Hello");
String s = stack.pop(); // 타입 캐스팅이 필요 없음

```

따라서 원하지 않는 타입의 객체 추가를 컴파일 시간에 막을 수 있고 타입 안정성이 생긴다.

장점
1. 코드의 재사용성(타입 캐스팅 x, 클래스 재사용 o)<br>
2. 간결성(타입 캐스팅 x)<br>
3. 가독성(타입 캐스팅 x, List < String > 같이 명확한 타입 정보 포함)<br>

## 제네릭과 static
제네릭 클래스는 컴파일 과정을 거치면 타입소거가 되어 타입이 정해진 일반 클래스파일로 변환된다.

그렇다면 일반 클래스 파일로 변환된 제네릭 클래스는 static 클래스가 될 수도 있고 static 변수 또한 사용 가능하다고 생각할 수 있다.

하지만 이는 한가지 간과한 것이 있다.

static 멤버 변수는 클래스가 로드될 때 method 영역에 저장되는데 제네릭타입은 동적 타입이므로 저장될 수가 없다.
(타입 소거되면 되지 않나요)


위의 원리로 제네릭 클래스는 static class 가 될 수 없고 generic 한 static 변수 또한 사용 될 수 없다.



