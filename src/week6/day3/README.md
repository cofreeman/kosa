# 서블릿 컨테이너
> 서블릿들을 관리하는 컨테이너

## 역할
클라이언트의 요청을 올바른 서블릿에 전달하고, JVM 이 해당 요청을 처리한 후 생성된 결과를 올바른 장소에 동적으로 반환해준다.
## 특징
1. 서블릿들의 생명주기관리를 한다.
2. 서블릿과 웹 서버 쉽게 통신할 수 있게 도와준다.
3. 클라이언트 요청이 발생하면 소켓을 만들고 쓰레드도 만든다.

### 서블릿프로그램에서 클라이언트-서버 통신과정
1. 웹서버가 HTTP 요청을 받는다
2. 웹서버는 요청을 서블릿 컨테이너로 전달합니다.
3. 서블릿이 컨테이너에 없다면, 서블릿을 동적으로 검색하여 컨테이너의 주소 공간에 로드한다
4. 컨테이너가 서블릿의 init() 메소드를 호출하면, 서블릿이 초기화된다: 서블릿이 처음 로드됬을 때 한번만 호출
5. 컨테이너가 서블릿의 service() 메소드를 호출하여 HTTP 요청을 처리한다. (요청의 데이터를 읽고, 응답을 만들어낸다)서블릿은 컨테이너 주소에 남아있고, 다른 HTTP 요청들을 처리할 수 있습니다.
6. 웹서버는 동적으로 생성된 결과를 올바른 위치에 반환한다.

### 참고
https://velog.io/@han_been/%EC%84%9C%EB%B8%94%EB%A6%BF-%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88Servlet-Container-%EB%9E%80

# 상태정보 유지 기술
HTTP 프로토콜은 무상태성이므로 이전 접속의 결과물을 일정시간, 또는 영구적으로 저장하고 사용할 수 있어야하고 이 기술을 상태정보 유지라고한다.

# Cookie
> 클라이언트에 정보를 저장하는 기술

## 특징
1. 클라이언트에 정보를 저장하기 때문에 서버의 부담이 줄어든다. 
2. 쿠키는 보안의 위험과 유지성 때문에 사용해야할 상황을 잘 고려해야한다.  

## 예시
```java
```
# Session
> 서버에 정보를 저장하는 기술

## 특징
1. 상태정보를 서버에 저장하므로 보안성과 유지성이 좋다.
2. 서버가 다운되면 상태 정보가 전부 사라지게된다. 따라서 세션 복제나 세션 스토리지 같은 기술을 사용해서 정보관리에 신경을 써야한다.
3. 클라이언트마다 세션을 구분해야하므로 sessionId 등을 부여해야한다.
4. 세션 객체를 생성하면 JVM 의 Heap 메모리영역에 올라간다.

## 주요 메서드
```java
public Enumeration getAttributeNames()
세션에 등록된 객체들의 이름을 열거한다.
public long getCreationTime()
1970. 1.1 GMT 부터 세션이 만들어졌을 때까지의 시간을 밀리초의 단위로 리턴한다.
public String getId()
세션에 지정된 세션 ID를 리턴한다.
public long getLastAccessedTime()
클라이언트 요청이 마지막으로 시도된 시간을 밀리초로 리턴한다.
public int getMaxInactiveInterval()
클라이언트의 요구가 없을 때 서버가 현재의 세션을 언제까지 유지할지를 초시간 단위로 리턴한다. 이때 디폴트 세션마감시간은 30분으로 지정되어 있다.
public boolean isNew()
서버측에서 새로운 세션을 생성한 경우에는 true를 리턴하고 기존의 세션이 유지되고 있는 경우라면 false를 리턴한다.
public void setMaxInactiveInterval(int seconds)
세션 유지 시간을 설정한다. 이 시간이 지나면 세션은 자동 종료(HttpSession객체 삭제)된다.
```
## 예시
```java
public static void main(){
    HttpSession session = request.getSession(false);
    //        HttpSession 객체를 추출하거나 새로이 생성한다. 
    //        request.getSession(true) 와 동일하다. 
    //        request.getSession(false) 는 HttpSession 객체를 추출하여 리턴하는데 없으면 null을 리턴한다.
    
    session.setAttribute(“xxx”, new Data()) : 보관하려는 정보를 객체로 만들어 HttpSession객체에 저장한다. “xxx” 라는 이름으로 객체의 참조 값을 보관한다 .
    session.getAttribute(“xxx”) : “xxx” 라는 이름으로 보관된 객체에 대한 참조 값을 리턴한다.
    session.removeAttribute(“xxx”) : “xxx” 라는 이름으로 보관된 객체에 대한 참조 값을 삭제한다.
    session.invalidate() : HttpSession 객체를 강제로 삭제한다.
}
```