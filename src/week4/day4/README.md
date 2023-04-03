# 사용자와 서버의 통신 과정

1. 주소창에 naver 를 친다.
2. udp 프로토콜로 dns 서버에 질의를 한다.
3. dns 서버로 부터 ip 주소를 획득한 후 ip 주소를 획득합니다.
4. ip 주소와 포트번호(well-known 포트 HTTP: 80 HTTPS: 443)를 바인딩해서 client 소켓을 만듭니다.
5. 서버는 미리 서버 소켓을 만들어놓은 후 클라이언트의 요청을 받을 수 있는 상태(ServerSocket.accept())로 만들어놓습니다.

//todo

?. 연결되면 서버는 요청을 한 클라이언트에게 포트를 할당합니다.

---
### 네트워크 패킷의 형태를 보고싶다...
와이어 샤크 프로그램을 쓰면 패킷 정보를 알 수 있다.
___
# WWW (World Wide Web)
> 인터넷상의 정보를 하이퍼텍스트 방식과 멀티미디어 환경에서 검색할 수 있게 해주는 정보검색 시스템이다.

## URL, URI, URN
> URI (Uniform Resource Identifier) : 자원의 식별자
> URL (Uniform Resource Locator) : 자원의 위치

URI는 Uniform Resource Identifier의 약자로, 인터넷에서 고유한 리소스를 식별하는 일반적인 용어입니다. URI는 리소스를 식별하기 위해 사용되며, 이를 통해 인터넷 프로토콜을 통해 접근 가능한 모든 리소스를 식별합니다.

URL (Uniform Resource Locator)은 인터넷에서 리소스의 위치를 나타내는 식별자입니다. URL은 프로토콜(예: HTTP, FTP), 호스트 이름(예: www.example.com) 및 리소스 경로(예: /index.html)로 구성됩니다.
예를 들어, "https://www.example.com/index.html"은 URL입니다. 이 URL은 HTTPS 프로토콜을 사용하며, 호스트 이름은 "www.example.com"이고, 리소스 경로는 "/index.html"입니다. 이 URL을 사용하여 브라우저에서 해당 웹 페이지를 로드할 수 있습니다.

URI는 인터넷에서 모든 리소스를 식별하기 위한 표준적인 방법입니다. 예를 들어, 웹 페이지, 이미지, 문서, API 엔드 포인트 등 다양한 리소스가 URI로 식별될 수 있습니다.

또 다른 예시로, "mailto:example@example.com"은 이메일 주소를 식별하는 URI입니다. 이 URI를 사용하여 이메일 클라이언트에서 해당 이메일 주소로 새 이메일을 작성할 수 있습니다.

URI는 다양한 인터넷 프로토콜에서 사용됩니다. 예를 들어, HTTP, FTP, SMTP, Telnet 등 다양한 프로토콜에서 URI를 사용하여 리소스를 식별합니다.

### URL, URI 예시
https://example.io 의 경우 https://example.io 라는 서버를 나타내기 때문에 URL이면서 URI이다.<br>
https://example.io/images 의 경우 example.io 서버의 images라는 네트워크 상의 자원의 위치를 의미하기 때문에 URL이면서 URI이다.<br>
https://example.io/images/dog.jpeg 의 경우 example.io 서버의 images 디렉터리 아래의 dog.jpeg를 가리키므로 URL이면서 URI이다.<br>
https://example.io/user/123 의 경우 URL은 https://example.io/user 까지고 원하는 정보에 도달하기 위한 식별자 123을 포함하면 URI이다. 즉, URI이지만 URL은 아니다.<br>
https://example.io/profile?id=11 의 경우도 마찬가지로 https://example.io/profile 까지는 URL이지만 원하는 정보에 도달하기 위한 식별자(여기서는 ?id=11)를 포함하면 URI가 된다. 즉, URI이지만 URL은 아니다.<br>

한줄 요약: 자원을 식별하면 URI, 자원의 위치를 나타내면 URL, URI 는 URL 을 포함한다.

___
# IntelliJ Artifact
> Artifact 란 IntelliJ IDEA 내에서 Java 프로그램을 jar 파일로 뽑아낼 때, 
해당 jar 파일에 어떤 내용이 포함될 것인지, 어디에 저장될 것인지를 정하는 기능
___


?????????
사용자와 서버의 통신과정을 설명
?????????