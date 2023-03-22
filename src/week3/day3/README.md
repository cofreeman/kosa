## 객체 직렬화
> 직렬화: 객체 내부의 정보(멤버 변수) -> 바이트 스트림
> 역직렬화: 바이트 스트림 -> 객체 생성

객체 직렬화를 위해
FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream, 그 리고 Serializable 인터페이스의 기능을 알고 있어야 한다.

## 직렬화 가능한 가능 객체 구현
**1. Serializable 또는 Externalizable 인터페이스를 상속을 해야 한다.**<br>
**2. 조상이 Serializable을 상속하고 있으면 자손에도 그대로 적용된다.**<br>
**3. non-static, non-transient 멤버 변수들만 직렬화 대상이 된다.(할 필요가 없다.)**<br>
직렬화 시에 직렬화에서 제외되는 멤버변수를 선언하 고자 할 때 사용되는 변수 제어자가 바로 transient 키워드이다.<br>
**4. 메서드도 같은 원리로 직렬화 할 필요가 없다.(할 필요가 없다.)** <br>
**5. 직렬화의 대상이 되는 멤버 변수가 참조형일 때는 참조하는 객체도 직렬화 가능한 객체여야 한다. 그렇지 않 으면 실행 시 NotSerializableException이 발생된다.**

## transient 와 직렬화
직렬화 하고 싶지 않은 멤버 변수에 transient 키워드를 붙히면 해당 변수는 직렬화에서 제외도니다.
그렇다면 역직렬화 시에 transient 변수는 어떻게 주입되는가? 리플렉션? 아니면 컴파일러가 transient 변수를 제외한 생성자를 만들어주는가?
둘 다 아니다.

???????????????????????

## 객체 직렬화시에 정리
1. Serializable 상속 
2. serialVersionUID 변수 생성(psfi)
3. 기호에따라 멤버 변수에 static, transient 추가 

# URL 프로그래밍
> URL 클래스를 이용하는 프로그래밍(java.net)

## URL(Uniform Resource Locator)
> 자원을 식별할 수 있는 문자열

### HTTP URL
> 웹사이트의 주소 문자열

### JDBC URL
> 접속할 DB 서버와 JDBC 드라이버 정보를 정해진 규격으로 작성한 문자열

## java.net.URL 클래스
> 웹 서버에 접속하여 컨텐트를 요청하는 프로그램을 개발할 때




