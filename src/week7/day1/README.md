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
Filter는 javax.servlet.Filter 인터페이스를 구현하여 작성한다.ㅡ

## 요청이 Filter 를 거치는 과정

## Filter 객체 구현과정

# JUnit
> 단위 테스트를 위한 테스트 프레임워크 

## 특징
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

????
요청이 Filter 를 거치는 과정
Filter가 특정 요청만 처리하게 하는 방법
doFilter 메서드는 뭔가
doFilter메서드의 매개변수 FilterChain 에는 무엇이 주입되나 -> 다음 요청을 수행할 객체(필터 또는 서블릿)? -> 아니다 
FilterChain 인터페이스에는 별 내용이 없는데 어떻게 다음 요청을 수행할 객체를 찾지?
프레임워크가 요청에 대한 요청처리과정을 컴파일 시점에 정해놓나?
서블릿 컨테이너에 의해서 관리되나? 내생각에는 요청 -> 서블렛 컨테이너 -> 알맞은 필터 매핑 -> 필터링 거친 요청을 다시 서블릿 객체로 전달
????