# @ComponentScan
@ComponentScan 으로 스캔될 빈들의 패키지를 설정할 수 있다.
````java
@ComponentScan(basePackages = {"com.example.springedu","thymeleaf.exam"})
````
주의 : ComponentScan 을 설정하면 기본으로 설정되는 basepackage 도 스캔 설정을 해줘야 스캔대상에 포함이 된다.

---
# Dispatcher Servlet 
> Spring MVC 웹 프레임워크에서 Front Controller 패턴을 구현한 컨트롤러입니다. 웹 애플리케이션에서 들어오는 모든 요청을 한 곳에서 처리하고, 이를 적절한 컨트롤러에게 전달하여 요청을 처리하는 중앙집중식 컨트롤러입니다.

# 도입 이유
## 도입 전
기존의 Servlet Container에서는 HTTP 요청이 Servlet으로 전달되어, Servlet에서 요청을 처리하고 응답을 생성하는 구조였습니다.<br>
이 구조에서는 Servlet이 Front Controller의 역할을 하게 됩니다.<br>
이에 반해 Spring Boot Web 모듈에서는 Dispatcher Servlet이 Front Controller의 역할을 합니다.<br>
## 도입 후
Spring Boot Web 모듈에서의 Dispatcher Servlet은 HTTP 요청을 받아, 요청을 처리하기 위해 적절한 Controller에 전달하고,<br> 
Controller가 요청을 처리한 후에는 다시 Dispatcher Servlet에게 응답을 생성하도록 전달합니다.<br>
이 구조에서는 Spring Boot의 MVC 패턴이 사용되며, Controller와 View 사이에는 Model 객체를 사용하여 데이터를 전달합니다.<br>
이러한 구조를 통해 높은 수준의 유연성과 확장성을 가진 웹 애플리케이션을 개발할 수 있습니다.<br>

또한 추후에 dispatcher servlet을 이용하여 spring security를 도입할 수 있습니다.

## Spring MVC 의 FrontController 를 이용한 요청처리 방법
Spring MVC의 Front Controller는 Dispatcher Servlet입니다.<br> 
Dispatcher Servlet은 웹 애플리케이션의 모든 요청을 중앙집중적으로 처리하며, 요청을 적절한 핸들러에게 전달하여 처리합니다.<br>

Spring MVC에서 Front Controller를 이용한 요청 처리 방법은 다음과 같습니다.

1. 클라이언트로부터 요청이 들어오면, Dispatcher Servlet이 이를 가로챕니다.
2. Dispatcher Servlet은 Handler Mapping을 이용하여 적절한 Controller를 찾습니다.
3. Controller는 요청을 처리하고, 결과를 Model 객체에 담아 Dispatcher Servlet에게 반환합니다.
4. Dispatcher Servlet은 View Resolver를 이용하여 View를 찾습니다.
5. View는 Model 객체를 이용하여 요청에 대한 응답을 생성합니다.
6. Dispatcher Servlet은 생성된 응답을 클라이언트에게 반환합니다.
7. Spring MVC에서 Front Controller를 이용하는 방법은 간단하고 직관적입니다. 

모든 요청을 Dispatcher Servlet이 중앙집중적으로 처리하므로, 애플리케이션의 구조가 단순화되고 유연성이 높아집니다.<br>
또한, 핸들러 매핑과 View Resolver를 이용하여 요청과 응답 처리를 자동화할 수 있으므로, 개발자는 핵심 비즈니스 로직에 집중할 수 있습니다.<br>

---

# Handler Mapping
> Handler Mapping은 Dispatcher Servlet이 요청을 받았을 때, 알맞은 Controller를 찾아주는 역할을 하는 Spring MVC의 인터페이스입니다.

## 역할
Handler Mapping은 URL과 Controller 사이의 매핑 정보를 가지고 있으며, 이를 이용하여 Dispatcher Servlet이 요청에 대한 처리를 위해 어떤 Controller를 사용해야 하는지 결정합니다.

## 직접 구현하나? 
Spring MVC에서는 기본적으로 여러 종류의 핸들러 매핑을 제공하며, 이를 사용하여 커스텀 핸들러 매핑을 구현하지 않아도 됩니다.<br>
또한 일반적인 경우에는 Spring MVC에서 제공하는 핸들러 매핑을 사용하는 것이 좋습니다.<br>

## handller mapping 은 언제 생성되나?
Handler Mapping은 컴파일 단계에서 생성되는 클래스가 아니며, 런타임 시점에 Dispatcher Servlet이 초기화될 때 생성됩니다.<br> 
이 때, Handler Mapping은 ApplicationContext에서 Controller Bean을 검색하여 매핑 정보를 생성합니다.<br>
따라서, Handler Mapping은 Dispatcher Servlet이 요청을 받았을 때, 요청에 알맞은 Controller를 찾아주는 역할을 하는 Spring MVC의 인터페이스이며, 런타임 시점에 생성됩니다.<br>

---

# handler adapter
Handler Adapter는 Spring MVC 프레임워크에서 컨트롤러(Controller) 객체가 요청(Request)을 처리할 수 있는 방식으로 변환하는 역할을 합니다.

---

# view Resolver
> View Resolver는 Spring Framework에서 사용되는 구성 요소 중 하나입니다. Spring MVC 애플리케이션에서 View를 검색하고 선택하는 방법을 결정하는 데 사용됩니다.

## 장점
Spring MVC에서 View Resolver는 컨트롤러가 반환하는 논리적인 View 이름을 실제 View로 해석하고 렌더링합니다.<br>
이를 통해 개발자는 뷰의 실제 경로를 지정하지 않아도 된다는 이점을 얻을 수 있습니다.<br>

---

# Controller 의 매개변수에 올 수 있는 것들
Spring MVC의 컨트롤러(Controller) 매개변수는 다양한 유형의 객체를 받을 수 있습니다. 이러한 매개변수는 컨트롤러 메소드에서 사용될 수 있는 요청(Request)의 정보를 포함합니다.

대표적인 컨트롤러 매개변수의 유형은 다음과 같습니다.

1. HttpServletRequest, HttpServletResponse
HttpServletRequest는 HTTP 요청(Request) 정보를 가진 객체이며, HttpServletResponse는 HTTP 응답(Response) 정보를 가진 객체입니다. 
이러한 객체는 Servlet API의 일부분이며, Spring MVC에서도 사용됩니다.
```java
@Controller
public class MyController {
 
    @RequestMapping("/myrequest")
    public ModelAndView myRequest(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name"); // 요청 파라미터 가져오기
        //request.getParameter("name")은 GET 또는 POST 방식으로 전달된 "name"이라는 이름의 파라미터 값을 모두 가져올 수 있습니다.
        String method = request.getMethod(); // 요청 HTTP 메소드 가져오기
        String userAgent = request.getHeader("User-Agent"); // User-Agent 헤더 가져오기
        
        // 응답(Response) 처리
        ModelAndView mav = new ModelAndView("myview");
        mav.addObject("name", name);
        mav.addObject("method", method);
        mav.addObject("userAgent", userAgent);
        return mav;
    }
}
```

2. HttpSession
HttpSession은 클라이언트와 서버간의 상태를 유지하기 위한 객체입니다. 클라이언트가 서버에 최초로 접속할 때 생성되며, 유지 기간은 서버와 클라이언트간의 통신이 계속 유지되는 동안입니다.
```java
@GetMapping("/example")
public String example(HttpSession session) {
    // HttpSession 객체를 매개변수로 받음
    Integer count = (Integer) session.getAttribute("count");
    if (count == null) {
        count = 0;
    }
    count++;
    session.setAttribute("count", count);
    return "examplePage";
}
```

3. @RequestParam
@RequestParam 어노테이션은 요청(Request) 파라미터를 가져오는 데 사용됩니다.
이 어노테이션은 URL에서 파라미터로 전달된 값을 매개변수로 받아올 수 있습니다.
모든 요청 유형에서 사용할 수 있습니다.
```java
@GetMapping("/example")
public String example(@RequestParam("name") String name
    ,@RequestParam(value = "email") String email
    ,@RequestParam(value = "avgScore", defaultValue = "없음") String avgScore){

    // 요청(Request) 파라미터에서 "name" 값을 가져옴
    return"examplePage";
    }
}
```

4. @PathVariable
@PathVariable 어노테이션은 RESTful API에서 URL 경로 변수를 매개변수로 받아올 때 사용됩니다. 예를 들어, "/users/{id}"와 같은 URL 패턴에서 {id}에 해당하는 값을 매개변수로 받아올 수 있습니다.
````java
@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long userId, Model model) {
        // {id}에 해당하는 값이 userId 변수로 매핑됨
        User user = userService.getUser(userId);
        model.addAttribute("user", user);
        return "userPage";
    }
}
````

5. @RequestHeader
@RequestHeader는 요청 헤더의 값을 추출하기 위해 사용되는 스프링 MVC의 어노테이션입니다. 특정 헤더의 값을 메서드 파라미터로 바인딩할 수 있습니다
```java
@GetMapping("/example")
public void handleRequest(@RequestHeader("User-Agent") String userAgent) {
    // User-Agent 헤더의 값을 추출하여 사용
}

```

6. @RequestBody
@RequestBody 어노테이션은 요청(Request) 본문을 객체로 변환하여 매개변수로 받아올 때 사용됩니다.
따라서 Get 방식에서는 지원을 하지 않습니다.
```java
@PostMapping("/users")
public ResponseEntity<?> createUser(@RequestBody User user) {
    // 요청(Request) 본문을 User 객체로 변환하여 user 매개변수로 받음
    userService.createUser(user);
    return new ResponseEntity<>(HttpStatus.CREATED);
}
```

7. Model, ModelMap, ModelAndView
Model, ModelMap, ModelAndView는 View에서 사용할 데이터를 저장하는 객체입니다.
이러한 객체를 매개변수로 받아와서 컨트롤러 메소드에서 데이터를 추가하거나 수정할 수 있습니다.
```java
예시1. Model
// Model은 View에 전달할 데이터를 담는 데에 사용되는 인터페이스입니다. 컨트롤러 메소드에서 Model 객체를 매개변수로 받아서 데이터를 추가하면, 이 데이터는 View에서 사용할 수 있습니다.
@GetMapping("/example")
public String example(Model model) {
    // Model 객체를 매개변수로 받음
    model.addAttribute("name", "John");
    model.addAttribute("age", 30);
    return "examplePage";
    }
    
예시2. ModelMap
@GetMapping("/example")
public String example(ModelMap modelMap) {
    // ModelMap 객체를 매개변수로 받음
    modelMap.addAttribute("name", "John");
    modelMap.addAttribute("age", 30);
    return "examplePage";
    }
    
예시3. ModelAndView
@GetMapping("/example")
public ModelAndView example() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("name", "John");
    modelAndView.addObject("age", 30);
    modelAndView.setViewName("examplePage");
    return modelAndView;
    }
```

8. ModelAttribute
@ModelAttribute 어노테이션은 요청(Request) 매개변수의 값을 객체로 받아오는 방법 중 하나입니다.
또한 ModelAttribute 로 전달받은 객체는 자동으로 Model 객체 안에 추가됩니다.
예를 들어 다음과 같은 코드에서 kkk 라는 이름의 StepVo 객체가 모델에 추가됩니다.
`````java
@Controller
public class StepController {		
	@PostMapping("/step")
	public String memberHandle(@ModelAttribute("kkk") StepVO vo) {
		if(vo.getAge() < 18)
			return "redirect:/stepForm.html";
		System.out.println("[ 전달된 Command 객체의 정보 ]");
		System.out.println(vo.getName());
		System.out.println(vo.getPhoneNumber());
		System.out.println(vo.getAge());
		return  "stepOutput";
	}
}
`````
HTML <form> 태그를 사용하여 전송한 데이터를 객체로 받아오는 예시 코드는 다음과 같습니다.
```java
@PostMapping("/save")
public String save(@ModelAttribute User user) {
  // 컨트롤러 메소드에서 전송된 데이터를 처리합니다.
  return "result";
}
```

9. @CookieValue
@CookieValue 는 쿠키의 값을 추출하기 위해 사용되는 스프링 MVC의 어노테이션입니다. 특정 쿠키의 값을 메서드 파라미터로 바인딩할 수 있습니다
`````java
@GetMapping("/example")
public void handleRequest(@CookieValue("sessionId") String sessionId) {
    // sessionId 쿠키의 값을 추출하여 사용
}

`````
10. Errors, BindingResult
Errors와 BindingResult는 스프링 MVC에서 데이터 바인딩과 유효성 검증을 수행할 때 사용되는 객체입니다. 이들은 주로 폼 처리와 관련하여 사용됩니다.
`````java
@PostMapping("/submitForm")
public String submitForm(@Validated FormDto formDto, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        // 유효성 검증 오류가 발생한 경우 처리
        List<ObjectError> errors = bindingResult.getAllErrors();
        for (ObjectError error : errors) {
            System.out.println(error.getDefaultMessage());
        }
        return "error-page";
    }
    // 폼 데이터가 유효한 경우 처리
    return "success-page";
}
`````