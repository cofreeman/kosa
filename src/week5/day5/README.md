# 이벤트 전파
이벤트 전파는 DOM 요소에서 이벤트가 발생했을 때, 이벤트가 어떻게 다른 관련 요소들로 전달되는지를 설명하는 과정입니다. 
이벤트 전파는 세 단계로 구성되어 있습니다: 이벤트 캡처링, 이벤트 타깃, 이벤트 버블링

1. 이벤트 캡처링(Event Capturing): 이벤트가 발생한 요소에서 최상위 요소로부터 이벤트가 전달되는 과정입니다.
   (이벤트 전파: 부모 -> 자식)
2. 이벤트 타깃(Target): 이벤트가 실제로 발생한 요소에 도달한 시점입니다. 이벤트 리스너가 해당 요소에 바인딩되어 있으면 실행됩니다.
3. 이벤트 버블링(Event Bubbling): 이벤트가 발생한 요소에서부터 최상위 요소까지 이벤트가 전달되는 과정입니다.(이벤트 전파: 자식 -> 부모)

이벤트 리스너를 등록할 때, 이벤트 캡처링 단계에서 리스너를 실행할지 이벤트 버블링 단계에서 실행할지 결정할 수 있습니다. 
이를 위해 addEventListener 메서드의 세 번째 인자로 true (캡처링) 또는 false (버블링)를 전달할 수 있습니다.
```js
dom3.addEventListener("click", displayAlert, true);
```

# Canvas API
웹 페이지에 그림을 그릴 수 있도록 지원하는 HTML5 API 이다.
## 사용법
canvas 태그를 사용하여 그림을 그리기 위한 영역을 정의하고 스크립트로 그림을 그린다.<br>
직선, 박스, 원, 베지에 곡선등 다양한 그림을 직접 그릴 수 있으며 원하는 사이즈 그리고 칼라의 이미지 출력을 처리할 수 있다.

# JavaScript 의 웹 스토리지
> 웹 스토리지란 웹 브라우저에 자료를 저장하기 위한 기능으로 로컬스토리지와 세션스토리지로 나뉜다.

## 생기게 된 이유
서버에 모든 정보를 보관하려면 부담이 많이 되니 클라이언트의 서버에 저장하기 위함

## 특징
- 기존의 쿠키와 비슷한 기술이지만 일부 기능에서 차이를 가지고 있다.
- 저장하려는 데이터마다 유일한 이름(키)을 같이 저장한다.
- 저장하려는 데이터의 종류에는 제한이 없으며 저장시에는 문자열로 저장된다
- 로컬스토리지(local storage) : 영구 보관
- 세션스토리지(session storage) : 브라우저가 종료될 때까지 보관
- W3C는 Same Origin Policy에 따라 도메인당 5MB를 권장하고 있으며 추가 용량이 필요할 경우 사용자의 동의를 얻어 용량을 확장할 수 있다.(초과시 QUOTA_EXCEEDED-ERR 발생)
- Same Orign Policy 정책이 적용된다.
## 사용법(API)
window.localStorage 와 window.sessionStorage 의 주요 멤버는 다음과 같다.
- length : 스토리지에 저장된 key/value 쌍의 개수를 추출하는 속성이다.
- key(index) : 숫자형 인덱스에 해당하는 key를 리턴한다.
- getItem(key) : 스토리지로 부터 key 에 해당하는 value 를 추출한다.
- setItem(key, value) : 스토리지에 key 에 해당하는 value 를 저장한다.
- removeItem(string key) : 스토리지에 key 에 해당하는 value 를 제거한다.
- clear() : 현재 스토리지의 모든 데이터를 제거한다.
- onstorage : 로컬 스토리지의 내용이 변경될 때마다 발생되는 이벤트로 로컬 스토리지의
변경 사항을 모니터링 하는 것이 가능하다. StorageEvent 객체가 생성된다.

### 세션 스토리지
- 저장
  - sessionStorage.mykey = "myvalue"; 
  - sessionStorage["mykey"] = "myvalue";
  - sessionStorage.setItem("mykey", "myvalue");
- 읽기
  - var mydata = sessionStorage.mykey;
  - var mydata = sessionStorage["mykey"];
  - var mydata = sessionStorage.getItem("mykey”);
- 삭제
  - delete sessionStorage.mykey;
  - delete sessionStorage["mykey"]; 
  - sessionStorage.removeItem("mykey");

### 로컬 스토리지
로컬 스토리지의 데이터 관리 
- 저장
  - localStorage.mykey = "myvalue"; 
  - localStorage["mykey"] = "myvalue"; 
  - localStorage.setItem("mykey", "myvalue");
- 읽기
  - var mydata = localStorage.mykey;
  - var mydata = localStorage["mykey"];
  - var mydata = localStorage.getItem("mykey”);
- 삭제
  - delete localStorage.mykey;
  - delete localStorage["mykey"]; 
  - localStorage.removeItem("mykey");
  
## Same Origin Policy(동일 출처 정책)
Same Origin Policy(동일 출처 정책)은 웹 보안의 기본 원칙 중 하나로, 웹 브라우저가 다른 출처의 리소스에 대한 액세스를 제한하는 정책입니다.<br> 
이 정책은 웹 애플리케이션에서 발생할 수 있는 보안 문제를 방지하려는 목적으로 존재합니다.<br>

동일 출처 정책에 따라, 웹 페이지에서 실행되는 스크립트는 동일한 출처(origin)에서 로드된 리소스에만 액세스할 수 있습니다.<br> 
출처는 URL의 프로토콜(scheme), 호스트명(host), 포트번호(port)의 조합으로 결정됩니다.<br>
예를 들어, 동일 출처 정책이 적용되면 http://example.com/app 페이지에서 로드된 스크립트는 http://example.com/data 에 있는 데이터에 액세스할 수 있지만,<br>
http://another-example.com/data 또는 https://example.com/data 에 있는 데이터에는 액세스할 수 없습니다.<br>





