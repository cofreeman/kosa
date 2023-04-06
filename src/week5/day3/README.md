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

## BOM(Browser Object Model)
> JavaScript 로 브라우저 또한 조작이 가능하다.

![img.png](img.png)
location.href 현재 웹페이지의 url 정보인데 이 정보를 변경하면 웹 페이지 이동을 한다. 
iframe 태그는 하나의 window 객체를 생성한다.

## DOM(Document Object Model)
> 객체 지향 모델로써 구조화된 문서를 표현하는 형식이다.

브라우저는 서버로부터 응답된 웹 컨텐트 내용을 파싱한 후 트리구조로 각 HTML 태그마다 DOM 기술을 적용하여 JavaScript 객체를 생성하는데 이 객체들을 DOM 객체라 한다.

DOM 객체를 통해서 HTML 문서의 내용에 접근하여 crud 를 할 수 있다.

그렇다면 javascript 가 읽을 수 있는 DOM 객체로 변환된 HTML 페이지를 BOM 객체 중 document 객체를 통해  조작하는것인가?
정답 : o

### DOM 객체 접근
DOM 객체를 접근할 때는 **직접 접근 방법**과 **노트 워킹 접근 방법**이 사용될 수 있다.

### 직접접근방법
원하는 DOM 객체에 접근하기 위해서는 document 객체에서 제공되는 다음 메서드들을 사용한다.
- document.getElementsByTagName('태그명') 태그명으로 DOM 객체들을 찾음 -> NodeList
- document.getElementById ('id속성값') 태그에 정의된 id 속성의 값으로 DOM 객체를 찾음 -> Node
- document.getElementsByClassName('class속성값') 태그에 정의된 class 속성의 값으로 DOM 객체들을 찾음 ->NodeList
- document.querySelector('#id, #class,#') 선택자에 알맞은 DOM 객체를 찾음 -> Node
- document.querySelectorAll('#찾고자 하는 DOM 객체에대한 CSS 선택자') 선택자에 알맞은 DOM 객체들을 찾음 -> NodeList
- 문자열로 정의된 엘리먼트의 컨텐트 내용을 추출하려면 node.nodeValue를 사용한다.
- 문자열로 정의된 엘리먼트의 컨텐트 내용을 추출하려면 node.textContent 사용한다.
- 종류에 관계없이 엘리먼트의 컨텐트 내용을 추출하려면 node.innerHTML 을 사용한다.
- 엘리먼트에 정의된 속성을 접근하기 위해서는 node.getAttribute('속성명')을 사용한다.
### 노트 워킹 접근 방법


### 이벤트 처리
window.onload() = 
?????
노트 워킹 접근 방법
함수 선언식과 호이스팅, 함수 표현식
/Users/choijungwoo/dkDynamicWebApp/src/main/webapp/jsexam/apiexam/exam7_2.html 는 함수 표현식인가 함수 선언식인가

????
