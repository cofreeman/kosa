# ModelAttribute
> @ModelAttribute는 스프링 MVC에서 컨트롤러 메서드의 매개변수 앞에 사용되는 애노테이션입니다.

## 역할
이 애노테이션은 요청 파라미터나 경로 변수 등으로부터 데이터를 바인딩하여 해당 매개변수에 전달하는 역할을 합니다.
@ModelAttribute 애노테이션은 다음과 같이 사용될 수 있습니다
1. 컨트롤러 메서드의 매개변수 앞에 사용되는 경우
```java
@PostMapping("/create")
public String create(@ModelAttribute User user) {
    // ...
}
```
위의 예제에서 @ModelAttribute 애노테이션은 User 객체에 요청 파라미터를 바인딩하여 전달합니다. 스프링 MVC는 요청 파라미터의 이름과 User 객체의 필드 이름을 기준으로 바인딩을 수행합니다.

2. 메서드의 리턴 타입으로 사용되는 경우
```java
@ModelAttribute
public User getDefaultUser() {
    return new User("John", "Doe");
}
```
위의 예제에서 @ModelAttribute 애노테이션은 getDefaultUser() 메서드의 리턴 값을 모델에 추가합니다. 
이를 통해 해당 데이터를 뷰로 전달할 수 있습니다.


## 정리 
@ModelAttribute 애노테이션은 데이터 바인딩과 모델에 데이터를 추가하는 두 가지 목적으로 사용될 수 있습니다.<br>
요청 파라미터를 바인딩하여 객체로 전달하거나, 모델에 데이터를 추가하여 뷰로 전달할 때 유용하게 사용할 수 있습니다.<br>
---

# DAO,DTO,VO
> 소프트웨어 개발에서 데이터 처리와 전달에 사용되는 개념입니다.

## DAO (Data Access Object)
데이터베이스와의 상호 작용을 담당하는 객체입니다.<br>
데이터베이스의 CRUD(Create, Read, Update, Delete) 작업을 수행하고, 데이터베이스 연산에 필요한 SQL 쿼리를 실행합니다.<br>
비즈니스 로직과 데이터 액세스 로직을 분리하여 데이터베이스에 접근하는 역할을 합니다.<br>

## DTO (Data Transfer Object)
DTO는 데이터 전달을 위한 객체입니다.<br>
여러 개의 필드를 포함하며, 데이터의 일부 또는 전체를 한 번에 전달하기 위해 사용됩니다.<br>
주로 데이터베이스에서 조회한 결과를 비즈니스 계층으로 전달하거나, 비즈니스 계층에서 데이터를 서비스나 클라이언트로 전달하는 데 사용됩니다.<br>
일반적으로 DTO는 불변(immutable)한 객체로 설계되며, 필요한 데이터만 포함합니다.<br>


## VO (Value Object)
VO는 값 객체로도 알려져 있습니다.<br>
불변성(immutable)을 가지며, 주로 데이터의 속성을 그룹화하여 사용됩니다.<br>
데이터의 속성을 포함하며, 도메인 모델에서 개별적인 값으로 다뤄질 수 있는 작은 단위의 객체입니다.<br>
비즈니스 로직을 포함하지 않고, 데이터의 상태를 나타내는 역할을 합니다.<br>
주로 데이터의 일관성과 불변성을 보장하고 도메인 객체 간에 값을 전달하는 데 사용됩니다.<br>
---
# RestController
>  스프링 프레임워크에서 제공하는 애노테이션으로, RESTful 웹 서비스를 개발할 때 사용되는 Annotation입니다.@Controller + @ResponseBody 입니다.

## RestController 의 특징
1. @ResponseBody 자동 적용: @RestController 애노테이션은 메서드가 반환하는 데이터를 HTTP 응답 본문에 자동으로 직렬화하여 반환합니다. 이를 위해 @ResponseBody 애노테이션을 각 메서드에 추가할 필요가 없습니다.<br>
2. Content Negotiation 지원: @RestController는 클라이언트 요청의 Accept 헤더를 기반으로 적절한 응답 형식(JSON, XML 등)을 선택하는 Content Negotiation을 지원합니다. 스프링MVC 에서는 기본적으로 반환값이 JSON 형태입니다.<br>
3. RESTful 응답 상태 코드 제어: @RestController를 사용하면 메서드의 반환 값을 기반으로 적절한 HTTP 응답 상태 코드를 자동으로 설정할 수 있습니다.<br>
4. 간편한 JSON/XML 변환: @RestController는 객체를 JSON이나 XML 형식으로 직렬화하여 반환할 수 있도록 도와줍니다. 이를 위해 스프링의 HttpMessageConverter를 사용하여 객체를 적절한 형식으로 변환합니다.<br>
5. 반환타입이 일반객체 또는 ResponseEntity 타입: 
   1. 일반 객체 반환: @RestController의 메서드는 일반 객체를 반환할 수 있습니다. 이 경우, 스프링은 해당 객체를 자동으로 직렬화하여 HTTP 응답 본문에 담아 클라이언트에게 반환합니다.<br>
   2. ResponseEntity 반환: @RestController의 메서드는 ResponseEntity 객체를 반환할 수도 있습니다. ResponseEntity는 HTTP 응답의 상태 코드, 헤더, 본문 등을 직접 제어할 수 있는 클래스입니다. 이를 통해 더 세밀한 제어가 필요한 경우 사용될 수 있습니다.

---
# StringBuffer String Builder 의 thread safe
StringBuffer와 StringBuilder는 문자열 조작을 위한 클래스로, 문자열을 가변적으로 다루는데 사용됩니다. 
이 두 클래스의 차이 중 하나는 스레드 안전성(Thread Safety)입니다.
## StringBuffer
StringBuffer는 스레드 안전한 클래스로, 여러 스레드에서 동시에 접근하여 조작해도 안전하게 작동합니다.<br>?
StringBuffer의 메서드들은 동기화되어 있어 스레드 간의 충돌이나 경쟁 조건을 방지할 수 있도록 설계되었습니다.<br>
따라서 멀티스레드 환경에서 안전하게 사용할 수 있습니다.<br>
하지만 동기화에는 오버헤드가 발생할 수 있어 단일 스레드 환경에서는 성능이 더 낮을 수 있습니다.<br>

## StringBuilder
StringBuilder는 스레드 안전하지 않은 클래스로, 동시에 여러 스레드에서 접근하여 조작하는 것은 안전하지 않습니다.<br>
StringBuilder는 동기화되지 않기 때문에 단일 스레드 환경에서 사용할 때 성능이 더 우수합니다.<br>
따라서 단일 스레드 환경에서 문자열 조작을 위해 StringBuilder를 사용하는 것이 권장됩니다.<br>
## 정리
스레드 안전성이 요구되는 경우에는 StringBuffer를 사용하고, 단일 스레드 환경이거나 스레드 안전성이 중요하지 않은 경우에는 StringBuilder를 사용하면 됩니다.

???
StringBuffer 와 StringBuilder 의 JVM 에서의 동작과 원리
???