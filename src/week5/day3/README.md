# JavaScript 의 객체 선언과 활용

## JavaScript 객체의 특징

- 객체란 이름과 값을 가진 data(Property) 의 집합 및 data 를 조작하기 위한 Method 가 하나로 묶인 것이다.(Java 의 객체와 유사함)

- JavaScript 에서 객체는 Property 의 집합과 하나의 prototype object 을 가지고 있다 .
- Method 는 함수가 값으로 저장된 객체의 Property 로서, 객체의 속성을 취득 및 변경 하기 위한 창구이다. 객체의 프로퍼티에 할당되어 객체를 통해서 호출되는 함수를 메서드라 부른다.
- 객체의 속성과 메서드는 동적으로 추가하거나 삭제하는 것이 가능하다.
- 상속구문도 적용되어 JavaScript 에서 생성되는 모든 객체들은 조상 객체로 Object 객체를 갖는다.
- JavaScript 의 함수는 실행 가능한 코드와 연결된 객체라 할 수 있다.
- map 자료구조라고 생각하면 편하다.(외부에서 변수 추가 가능)

??????? 한 번 더 보기??????

## 객체 정의

JavaScript의 객체 생성 방법은 2가지가 지원된다.

### 객체 리터럴을 사용하는 방법

```javascript
{
    속성명:속성값, 속성명
:
    속성값
...
}
```

### 생성자 함수를 사용하는 방법

> 생성자 함수란 객체를 초기화(속성과 메서드를 정의)하기 위해 사용되는 함수로서 관례적으로 생성자 함수의 명칭은 첫 글자를 대문자로 사용한다.

````javascript
function 함수명([매개변수]) {
    this.속성명 = 값;
    this.속성명 = 값;
...
}

new 함수명()
````

### 변수, 함수 사용 예시

- 프로퍼티에 접근할 때 this 를 무조건 붙혀줘야한다.
- 변수와 메서드명이 같아도 동작한다.
-

```js
<script>
    const obj = {
    name : '듀크',
    eat : "먹음",
    eat : function(food) {
    alert(this.name + "가 " + food + "를 먹어요!!");
}
};
    obj.eat("사과");
    obj.eat;
</script>
```

### 동일한 사양을 갖는 객체가 여러개 필요한 경우

객체 리터럴 보다는 생성자 함수를 사용하는 것이 낫다.<br>
prototype 을 사용할 수 있다.<br>
prototype x -> 객체가 생성될 때마다 속성, 메서드의 메모리 할당이 일어난다.<br>
prototype o -> 같은 타입의 멤버에서 미리 메모리에 할당된 속성,메서드를 재사용 할 수 있다.<br>
객체 리터럴은 유틸 클래스 같은 거로 쓰일까? o
```js
<script>
    function Student(name, korean, math, english, science) {
        this.이름 = name;
        this.국어 = korean;
        this.수학 = math;
        this.영어 = english;
        this.과학 = science;
    }
    Student.prototype.toString = function() {
        return this.이름+ " :  " +
        this.국어+ ", " +
        this.수학+ ", " +
        this.영어+ ", " +
        this.과학
    }
    Student.prototype.사회 = 0;
    var st1 = new Student('둘리', 96, 98, 92, 98);
    var st2 = new Student('또치', 92, 98, 96, 98);
    var st3 = new Student('도우너', 76, 96, 94, 90);
</script>
```