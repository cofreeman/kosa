# IoC 설정(Annotation 설정)
> Spring Framework에서 IoC(Inversion of Control)를 설정하는 방법 중 하나.

## XML을 통한 Annotation 설정과 다른 점과 장점
Annotation을 이용하면 XML 설정 파일 없이도 컨테이너에서 객체를 생성하고 의존성 주입을 수행할 수 있습니다.

__장점__

1. 코드 가독성: Annotation을 이용하면 코드에 설정 정보가 함께 기술되므로, 코드를 보는 것만으로도 설정 정보를 파악할 수 있습니다. 이는 XML 설정 파일에 비해 코드 가독성을 높일 수 있습니다.
2. 간결성: Annotation을 이용하면 설정 정보를 직접 코드에 작성할 수 있으므로, XML 설정 파일을 작성하지 않아도 됩니다. 이는 설정 정보를 간결하게 표현할 수 있도록 돕습니다.
3. 개발 생산성: Annotation을 이용하면 설정 정보를 코드에 작성하므로, 별도의 설정 파일을 작성할 필요가 없습니다. 이는 개발 생산성을 높일 수 있습니다.
4. 높은 유연성: Annotation을 이용하면 Bean의 스캔 범위를 지정할 수 있으므로, 높은 유연성을 제공합니다.
5. 컴파일 타임 검사: Annotation을 이용하면 컴파일 타임에 설정 정보를 검사할 수 있습니다. 이는 설정 정보에 오타 등의 오류가 있을 경우, 빠르게 확인할 수 있도록 돕습니다.


## 사용법
1. @ComponentScan: Spring에서 자동으로 Bean을 스캔하고 등록하기 위한 Annotation입니다.
이를 이용하면 basePackages 속성을 이용하여 특정 패키지 이하에서 Bean을 스캔할 수 있습니다.
````java
@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
    // ...
}

````
2. @Component: Bean으로 등록할 클래스에 붙이는 Annotation입니다. 
이를 이용하면 스캔된 클래스가 Bean으로 등록됩니다.<br>
bean의 이름은 해당 클래스명(첫 글자는 소문자로 변경해서)이 사용됩니다.<br>
범위는 디폴트로 singleton이며 @Scope를 사용하여 지정할 수 있습니다.<br>
```java
@Component
@Scope(value = "prototype")
public class MyComponent {
    // ...
}

```
3. @Autowired: 필드, 생성자, Setter 등에서 자동으로 의존성 주입을 수행할 때 사용하는 Annotation입니다.
```java
@Component
public class MyComponent {
    private MyDependency myDependency;
    
    @Autowired
    public MyComponent(MyDependency myDependency) {
        this.myDependency = myDependency;
    }
}
```
4. @Qualifier: 같은 타입의 Bean이 여러 개일 때 어떤 Bean을 주입할지 선택하기 위한 Annotation입니다.
```java
@Component
public class MyComponent {
    //case2: 매개변수에 주입
    private MyDependency myDependency;
    
    @Autowired
    public MyComponent(@Qualifier("myDependencyA") MyDependency myDependency) {
        this.myDependency = myDependency;
    }
    //case1: 필드에 주입
    @Qualifier("myDependencyA")
    private MyDependency myDependency;

    @Autowired
    public MyComponent(MyDependency myDependency) {
      this.myDependency = myDependency;
    }
}
```
5. @Value: 프로퍼티 값을 Bean의 필드에 주입할 때 사용하는 Annotation입니다.
```java
@Component
public class MyComponent {
    @Value("${my.property}")
    private String myProperty;
}
```

# Spring Boot
> 스프링 부트는 스프링으로 애플리케이션을 만들 때 필요한 초기 설정을 간편하게 처리해주는 모듈.

## Spring Boot 가 나오게 된 배경
Spring Framework는 엔터프라이즈급 애플리케이션을 개발하기 위한 유연하고 확장 가능한 자바 프레임워크입니다.
그러나 Spring Framework는 설정 및 구성과 같은 일부 기능을 구현하기 위해 많은 양의 XML 설정 파일을 사용해야 했습니다. 
이는 프로젝트의 복잡도를 증가시키고 초기 개발 시간을 늘리는 데 기여했습니다.


Spring Boot는 이러한 문제를 해결하기 위해 자동 구성, 스타터 의존성 및 내장형 웹 서버와 같은 기능을 제공합니다.
이를 통해 개발자는 많은 설정 작업을 수행하지 않고도 간단하고 빠르게 Spring 기반 웹 애플리케이션을 만들 수 있습니다.

## 타임리프 문법
```html
<h2>반갑다~~ [[${data}]]</h2>
<h2>잘 해보자~~<span th:text="${data}">뭐라두!!</span></h2>

<ul>
  <li th:each="ele : ${array}" th:text="${ele}"></li>
</ul>
```
????

?????


