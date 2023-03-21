# Collections
> 컬렉션 API 들을 사용함에 있어서 여러 유용한 기능을 제공

# Comparable interface
compareTo 추상 메서드가 정의되어 있는 인터페이스다.

비교를 하기위해서는 Comparable 을 상속받고 compareTo 를 구현하면된다.

자바에서 Comparable 을 상속한 클래스를 타입으로 가진 리스트
```java
class Person implements Comparable<Person>{
       
}
List<Person> list = new ArrayList<>();
Collections.sort(list);
```
sort의 메서드는 다음과 같다.
```java
public static <T extends Comparable<? super T>> void sort(List<T> list){
    list.sort(null);
        }
```
**메서드 해석**

공용 정적 메소드를 선언합니다.
이 메소드는 하나의 매개변수를 가지며, 이 매개변수는 List<T> 타입입니다.
여기서 T는 Comparable 인터페이스를 구현한 클래스의 인스턴스입니다. 이렇게 하면 리스트에 있는 객체들끼리 비교할 수 있습니다.
list.sort(null); : sort 메소드 내부에서는 매개변수로 받은 list의 sort 메소드를 호출합니다. null을 전달함으로써 자동으로 자연 순서(기본 정렬 순서)에 따라 리스트를 정렬합니다.
결론적으로, 이 코드는 주어진 리스트를 자연 순서(기본 정렬 순서)에 따라 정렬하는 공용 정적 메소드를 정의한 것입니다. 
리스트에 있는 객체는 Comparable 인터페이스를 구현해야 합니다.

# equals
Object 클래스 의 equals 는 주소비교다.

주소비교를 하지않으려면 Object 클래스의 equals 를 오버라이드해서 사용하자
# hashCode
해시코드를 반환하는 메서드

