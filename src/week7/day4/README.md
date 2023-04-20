# Spring Bean
> Spring Framework 에서 IoC 에 등록되어 사용되는 객체

## 특징
Spring 에서는 Bean 을 등록,생성,관리,소멸하는 작업을 대신해주는 IoC 객체를 제공한다.<br>
기존에는 객체의 생성을 클래스 내에서 직접했지만 결합도가 높았지만 Spring Framework 에서는 객체와 객체의 결합을 낮춰서 유연성과 확장성을 높혀줍니다.

## Spring Bean 등록 방법
Spring 에서 Bean 을 등록하는 방법은 Annotation 을 이용한 자동 스캔 방식과 XML 파일을 이용한 수동방식이 있고<br>@Autowired 를 이용해서 클래스 내에서 필요한 Bean 객체를 주입받을 수 있습니다.

### XML을 이용한 등록방법
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="morningGreeting" class="exam1.MorningGreetingImpl"/>
	<bean id="afternoonGreeting" class="exam1.AfternoonGreetingImpl"/>
	<bean id="eveningGreeting" class="exam1.EveningGreetingImpl" scope="singleton"/>
	<bean id="nightGreeting" class="exam1.NightGreetingImpl" scope="prototype"/>
	<bean id="localDateTime" class="java.time.LocalDateTime" factory-method="now"/>
</beans>
```
| 용어           | 설명                                                                                                                                            |
|--------------|-----------------------------------------------------------------------------------------------------------------------------------------------|
| bean         | <bean> 태그는 스프링 IoC 컨테이너에서 사용할 빈을 정의하는 데 사용됩니다.                                                                                                |
| id           | id 속성은 빈의 고유한 식별자를 지정합니다.                                                                                                                     |
| class        | class 속성은 해당 빈이 생성될 클래스를 지정합니다.                                                                                                               |
| factory-method |  factory-method 속성은 빈이 생성될 때 호출될 팩토리 메서드를 지정합니다. now는 LocalDateTime 클래스에서 정의된 정적 팩토리 메서드 중 하나입니다. 이를 이용해 현재 시간을 반환하는 LocalDateTime 객체를 생성합니다. |
| scope        |빈 객체의 생명주기 범위를 정의합니다. singleton은 한 개의 빈 객체를 생성하여 모든 곳에서 공유하고, prototype은 요청할 때마다 새로운 객체를 생성하는 범위입니다.|

### bean 을 등록한 후 사용법
ex) 스프링 프레임워크에서 XML 설정 파일을 이용해 LocalDateTime과 Greeting 빈을 생성하고 사용하는 방법을 보여주는 예시입니다.
```java
public static void main(String[] args...){
    ApplicationContext factory = new ClassPathXmlApplicationContext("exam1.xml");
    // ClassPathXmlApplicationContext 클래스를 이용하여 exam1.xml 파일에서 빈 설정 정보를 읽어들이는 ApplicationContext 객체를 생성합니다.
    // 해당 코드가 실행될 때, 스프링 IoC 컨테이너에서 설정 파일인 exam1.xml에 등록된 빈(Bean) 객체들도 함께 생성됩니다.
    LocalDateTime localDateTime = (LocalDateTime) factory.getBean("localDateTime");
    Greeting morningGreeting = (Greeting) factory.getBean("morningGreeting");
    morningGreeting.greet();
    ((ClassPathXmlApplicationContext) factory).close();
    // factory가 생성한 ApplicationContext 객체를 닫아서 리소스를 해제합니다. 이는 애플리케이션 종료시 수행하는 것이 좋습니다.
}
```
# Spring IoC 컨테이너가 생성되는 시점
ClassPathXmlApplicationContext 메서드 내부에서 refresh() 메서드를 호출하는데 이 메서드를 통해 Spring IoC 컨테이너를 생성합니다. <br>
또한 refresh() 메서드는 다음과 같은 작업을 수행합니다.
1. 스프링 IoC 컨테이너를 초기화합니다.
2. 빈 객체를 등록합니다.
3. 빈 객체들간의 의존성을 설정합니다.
4. 컨테이너에서 사용할 설정을 로딩합니다.
5. 컨테이너에서 사용할 리소스들을 로딩합니다.
6. 이벤트 리스너를 등록합니다.
XML 파일은 만들어진 Spring IoC container 에 등록할 bean 객체들에 대한 설정과 연관관계를 기술해 놓은 일종의 설정 파일이다.

# IoC 컨테이너가 초기화 될 때 모든 빈이 다 등록되나?
Spring IoC 컨테이너가 초기화될 때, 모든 bean 객체가 등록되는 것은 아닙니다.<br> 
bean 객체는 lazy loading 방식으로 초기화됩니다.<br>
즉, 컨테이너가 초기화될 때, bean 객체의 인스턴스가 모두 생성되지 않고, 요청 시점에 필요한 bean 객체만 생성됩니다.<br>
bean 객체가 컨테이너 초기화 시점에 등록되고 인스턴스화된다면, 시스템 자원의 낭비와 애플리케이션 성능 저하 등의 문제가 발생할 수 있습니다.<br>
bean은 Spring IoC 컨테이너가 생성될 때 같이 생성되지만 초기화는 사용시점에 이루어집니다.<br>