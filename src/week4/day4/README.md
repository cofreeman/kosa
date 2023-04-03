# 사용자와 서버의 통신 과정

1. 주소창에 naver 를 친다.
2. udp 프로토콜로 dns 서버에 질의를 한다.
3. dns 서버로 부터 ip 주소를 획득한 후 ip 주소를 획득합니다.
4. ip 주소와 포트번호(well-known 포트 HTTP: 80 HTTPS: 443)를 바인딩해서 client 소켓을 만듭니다.
5. 서버는 미리 서버 소켓을 만들어놓은 후 클라이언트의 요청을 받을 수 있는 상태(ServerSocket.accept())로 만들어놓습니다.


?. 연결되면 서버는 요청을 한 클라이언트에게 포트를 할당합니다.

---
# WWW (World Wide Web)
> 인터넷상의 정보를 하이퍼텍스트 방식과 멀티미디어 환경에서 검색할 수 있게 해주는 정보검색 시스템이다.

## URL, URI
> URI (Uniform Resource Identifier) : 자원의 식별자
> URL (Uniform Resource Locator) : 자원의 위치

예시: 

elancer.co.kr > URI
https://www.elancer.co.kr > URL, URI


---
## Form 태그


---

IDE 툴 : 웹 프로젝트 폴더

WAS(Web Application Server: Tomcat) : 컨텍스트
___

?????????
사용자와 서버의 통신과정을 설명
인텔리제이의 artifact 란 배포설정 톰캣 설정
톰캣 서버 연동하는 법 
와일드 샤크
web-app 폴더란?
url, uri 란?
Form 태그
?????????