# Filter
> 클라이언트의 요청을 수행하기 전, 후로 request 또는 response에 영향을 주거나 또는 특정 처리를 하는 객체

## Filter 가 사용되는 상황
1. 인증
2. 로깅
3. 이미지 변환
4. 데이터 압축
5. 암호화
6. 스트림 토큰화
7. XML 변환

## Filter 특징
Filter는 javax.servlet.Filter 인터페이스를 구현하여 작성한다.

## 요청이 Filter 를 거치는 과정
1. 클라이언트가 서버에 요청을 한다.
2. 서버는 요청을 처리하기 전에 필터를 적용합니다. 
3. 웹 서버가 필터를 요청에 적용합니다.(필터는 web.xml 파일이나 @WebFilter 애너테이션을 통해 정의됩니다.)
4. 요청에 필터를 적용하여 알맞게 변환한 후 다시 요청을 처리한다.

## Filter 객체 구현과정
```java
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST}, urlPatterns = {"/*"})
// 특정 요청 타입과 url에 Filter를 적용합니다. 
public class HangulFilter implements Filter {
// Filter를 상속받은 class 를 구현합니다.
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    // 추상메서드인 doFilter 메서드를 구현합니다.
    //request와 response는 각각 요청과 응답이며 FilterChain은 ~입니다.
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getMethod().equals("POST")) {
            request.setCharacterEncoding("utf-8");
        }
        chain.doFilter(request, response);
        // FilterChain 의 doFilter 를 통해 ~
    }
}
```
# doFilter 메서드
> doFilter 메서드는 요청과 응답 객체를 받아서 처리하는 메서드입니다.

## doFilter 메서드 특징
1. 다음 필터 또는 서블릿으로 요청을 전달합니다. 
2. 만약 다음 필터 또는 서블릿이 존재하지 않는다면, 클라이언트에게 요청에 대한 적절한 응답을 보냅니다.

## doFilter 메서드 구현 방법
```java
void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException;
```
을 구현하면 된다.

## doFilter 메서드 매개변수
| 매개변수 | 설명                                 |
|------|------------------------------------|
|request| HTTP 요청에 대한 정보가 담긴 객체입니다.          |
|response| HTTP 응답에 대한 정보가 담긴 객체입니다.          |
|chain|  다음 필터 또는 서블릿으로 요청을 전달하기 위한 객체입니다. |

## FilterChain 이란?
> 서블릿 컨테이너에 의해 구성되는 Filter 들의 연속된 체인

## FilterChain 은 누가 만드는가?
FilterChain 은 서블릿 컨테이너가 생성합니다.<br> 
클라이언트의 요청이 서블릿에 전달되기 전에 FilterChain을 구성되고 각각의 필터가 순차대로 실행되어 요청을 처리합니다.<br>  
Spring MVC 에서는 DispatcherServlet이 FilterChainProxy를 이용하여 Filter chain을 구성합니다.<br>

## FilterChain 은 언제 생성되나?
서블릿 컨테이너는 각각의 요청이 생성될 때 마다 Filter chain 을 새로 생성한다.

---
# JUnit
> 단위 테스트를 위한 테스트 프레임워크 

## JUnit 특징
JUnit 를 사용하면 클래스에 구현된 메서드가 주어진 기능을 제대로 수행하는지 단위테스트를 처리할 수 있다.
BeforeAll 과 AfterAll 은 항상 static 으로 정의되어야한다.

## 어노테이션의 종류
|어노테이션| 설명                                   |
|---|--------------------------------------|
|@Test | 테스트 메서드를 나타내는 어노테이션(필수)              | 
|@BeforeEach | 각 테스트 메서드 시작 전에 실행되는 메서드             | 
|@AfterEach|  각 테스트 메서드 종료 후에 실행되는 메서드            |
|@BeforeAll|  테스트 시작 전에 실행되는 메서드(static 메서드여야만 함) |
|@AfterAll|  테스트 종료 후에 실행되는 메서드(static 메서드여야만 함) |
|@Disabled | 실행되지 않아야 하는 테스트 메서드                  |

# Assertion
> 원하는 결과를 제대로 리턴하는지 에러는 발생하지 않는지 확인할 때 사용하는 메서드

## 종류
|메서드명|설명|
|---|---|
|fail|무조건 실패|
|assertTrue|조건이 성공이면 True|
|assertFalse|조건이 실패면 True|
|assertNull|조건이 Null이면 True|
|aseertNotNull|조건이 NotNull 이면 True|
|assertEquals(expected, actual)|expected와 actual이 같으면 True|
|assertArrayEquals| 두 Array가 동일하면 True|
|assertIterableEquals| 두 Iterable이 동일하면 True|
|assertLinesMatch|두 Stream이 동일하면 True|
|assertNotEquals|expected와 actual이 다르면 True|
|assertSame|동일한 Object면 True|
|assertNotSame|다른 Object면 True|
|assertAll|여러 Assertion이 True면 True|
|assertThrows|예상한 에러가 발생하면 True|
|assertDoesNotThrow|에러가 발생하지 않으면 True|
|assertTimeout|테스트가 지정한 시간보다 오래 걸리지 않으면 True 지정한 시간보다 오래 걸려도 테스트가 끝날 때까지 대기|
|assertTimeoutPreemptively|테스트가 지정한 시간보다 오래 걸리지 않으면 True 지정한 시간보다 오래 걸린 경우 바로 테스트 종류|


# 스프링 프레임워크
> 스프링 프레임워크는 자바 기반의 애플리케이션 프레임워크로 엔터프라이즈급 애플리케이션을 개발하기 위한 다양한 기능을 제공하는 프레임워크다.

## 특징
1. 제어의 역전(IOC)
2. 의존성주입(DI)
3. 관점 지향 프로그래밍(AOP-Aspect Oriented Programming)

# 제어의 역전(IOC)
> 객체 생성과 의존성 주입을 컨테이너가 수행하도록 하는 프로그래밍 원칙입니다.

## IOC 의 장점
IOC를 사용하면, 개발자는 컨테이너에게 필요한 객체를 요청하고, 컨테이너는 이를 생성하고 필요한 의존성을 자동으로 주입합니다. 
이를 통해 객체 간의 결합도를 낮출 수 있고, 유연하고 재사용성이 높은 코드를 작성할 수 있습니다.

## 예시
case 1. IOC 를 적용하지 않은 예시
```java
public class UserService {
    private UserDao userDao;
    
    public UserService() {
        userDao = new UserDao();
    }
    
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
```
case 1에서 UserService가 UserDao에 직접 의존하고 있습니다.<br> 
UserService 내부에서 UserDao의 객체를 생성하고 사용하고 있습니다.<br>
이 방식은 결합도가 높아지며, UserDao를 변경해야할 경우 UserService도 함께 변경되어야 합니다.<br>

case 2. IOC 를 적용한 예시
```java
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
```
case 2에서 UserService가 UserDao에 의존하지 않고, 생성자를 통해 UserDao 객체를 주입받도록 변경되었습니다.<br> 
이를 통해 UserDao의 변경이 UserService에 영향을 미치지 않으며, 유연한 코드를 작성할 수 있습니다.<br>
또한, 위 코드에서는 UserService 생성 시점에 UserDao 객체를 주입받고 있기 때문에 DI (Dependency Injection)을 구현하고 있는 것입니다.<br> 
이를 통해 UserDao를 외부에서 주입받도록 함으로써 객체의 결합도를 낮출 수 있습니다.<br>

# 의존성 주입(DI Dependency Injection)
> 객체 지향 프로그래밍에서 객체가 직접 필요한 의존성을 생성하지 않고, 외부에서 주입받는 방식을 사용하는 프로그래밍 방식입니다.

# DI 특징
DI는 객체가 다른 객체에 대한 의존성을 자신이 아닌 외부에서 주입받도록 하는 것입니다. 
이를 통해 객체 간의 결합도를 낮출 수 있으며, 코드의 유지보수성과 재사용성을 높일 수 있습니다.
IOC 원칙을 구현하는 방법 중 하나이고 case 2 에서 UserDao 객체가 UserService 객체에 주입되고 이것을 (컨테이너에 의한)의존성 주입 즉, DI 라고 합니다.

# DI 방법
1. Construction Injection : 생성자를 통해서 객체 바인딩(의존관계를 연결)
2. Setter Injection : setter 메서드를 이용해서 객체 바인딩(의존관계를 연결)
3. method Injection : 어노테이션을 정의한 메서드를 이용해서 객체 바인딩(의존관계를 연결)
4. field Injection : 어노테이션을 정의한 메서드를 이용해서 객체 바인딩(의존관계를 연결)
