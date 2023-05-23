# 엔티티 기본키 매핑
JPA 에서 기본키를 매핑하는 방법에는 직접할당과 자동할당이 있다.
직접 할당은 엔티티에 @Id 어노테이션만 사용해서 직접 할당하는 것이다.
자동 생성은 엔티티에 @Id와 @GeneratiedValue를 추가하고 원하는 키 생성 전략을 선택한다.
자동 생성같은 경우에는 MySQL의 AUTO_INCREMENT 같은 기능으로 생성된 값을 기본키로 사용 하는 것이다.


## 기본키 자동 생성 전략
IDENTITY = DB 에 따라 기본키 생성 전략을 다르게하는 방식이고 오라클의 경우 Sequence, MySQL 같은 경우 Auto increment 전략을 사용한다.

## 예시
```java
@Entity
public class Member {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private Long id;
```
## 엔티티 필드 매핑
@Column 어노테이션은 엔티티 클래스의 속성을 데이터베이스 테이블의 컬럼과 매핑할 때 사용됩니다.
이 어노테이션을 통해 컬럼의 속성들을 지정할 수 있습니다.

### @Column 어노테이션의 주요 속성
|속성|설명|
|---|---|
|name|컬럼의 이름을 지정합니다. 속성과 컬럼의 이름이 다를 경우 사용합니다.|
|nullable|컬럼의 값이 NULL일 수 있는지를 지정합니다. 기본값은 true입니다.|
|unique|컬럼의 값이 고유해야 하는지를 지정합니다. 기본값은 false입니다.|
|length|컬럼의 최대 길이를 지정합니다. 문자열 컬럼에 사용될 수 있습니다.|
|precision 및 scale|컬럼의 숫자형 데이터의 정밀도와 소수 자릿수를 지정합니다.|
|insertable 및 updatable|컬럼의 값이 INSERT 또는 UPDATE 작업에 포함되어야 하는지를 지정합니다. 기본값은 true입니다.|

```java
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "emp_name", nullable = false, length = 50)
    private String name;

    @Column(name = "emp_salary", precision = 10, scale = 2)
    private BigDecimal salary;

    // Getters and Setters
}

```
참고: spring.jpa.hibernate.ddl-auto 속성을 update로 설정하면 Hibernate가 애플리케이션 시작 시에 데이터베이스 스키마를 자동으로 생성 또는 업데이트합니다.
이때 엔티티 클래스에 정의된 @Column 어노테이션의 내용이 참조되어 데이터베이스의 테이블 및 컬럼 정의가 생성 또는 업데이트됩니다.
예를 들어 @Column 필드의 nullable이 false 일때 엔티티 생성시 null 값이 들어가도 오류가 나지 않고 DB 에 들어가는 필드값이 null 일떄 오류가 발생합니다.


## @JoinColumn
@JoinColumn 어노테이션은 엔티티 간의 관계를 매핑할 때 사용되는 어노테이션입니다. 
주로 외래 키(Foreign Key) 컬럼의 매핑을 지정할 때 사용됩니다.

## @JoinColumn 속성
| 속성  | 설명  |
|-----|-----|
|name|조인 컬럼의 이름을 지정합니다. 기본값은 현재 필드의 이름과 동일한 값입니다.|
|referencedColumnName| 조인할 대상 엔티티의 기본 키 컬럼의 이름을 지정합니다. 기본값은 참조하는 엔티티의 기본 키 컬럼의 이름입니다.|
|unique| 조인 컬럼이 유니크 제약 조건을 가지는지 여부를 지정합니다. 기본값은 false입니다.|
|nullable| 조인 컬럼이 null 값을 허용하는지 여부를 지정합니다. 기본값은 true입니다.|
|insertable| 새로운 엔티티가 저장될 때 조인 컬럼이 포함되어야 하는지 여부를 지정합니다. 기본값은 true입니다.|
|updatable| 엔티티가 업데이트될 때 조인 컬럼이 포함되어야 하는지 여부를 지정합니다. 기본값은 true입니다.|

# 단방향 매핑
단방향 매핑은 관계를 설정하는 한 방향으로만 매핑하는 것을 말합니다.
즉, 한 엔티티에서 다른 엔티티로의 관계를 매핑하고 접근할 수 있지만, 반대로 다른 엔티티에서 해당 엔티티로의 접근은 제공되지 않습니다.

## 예시
```java
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    //...
}

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    
    //...
}

```

# 양방향 매핑

양방향 매핑은 두 엔티티 간의 관계를 양쪽으로 매핑하는 것을 말합니다.
즉, 한 엔티티에서 다른 엔티티로의 관계를 설정하고, 동시에 다른 엔티티에서 해당 엔티티로의 접근을 제공하는 것입니다.

```java
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy = "author")
    private List<Book> books;
    
    //...
}

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    
    //...
}
```
