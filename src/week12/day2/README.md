# vue3 란
Vue는 사용자 인터페이스를 구축하기 위한 JavaScript 프레임워크입니다.
표준 HTML, CSS 및 JavaScript를 기반으로 구축되며, 단순한 것 부터 복잡한 것 까지 사용자 인터페이스를 효율적으로 개발할 수 있는 컴포넌트 기반 프로그래밍 모델을 제공합니다.

# 빠른 시작
스크립트 태그를 통해 CDN 에서 vue 사용 가능 

## 문법
Vue.js에서는 createApp 함수를 사용하여 Vue 애플리케이션을 생성합니다. 
이 함수를 사용하여 Vue 인스턴스를 생성하고, 인스턴스의 data 옵션을 통해 데이터를 정의합니다.
데이터는 Vue 인스턴스 내에서 사용되는 변수로, 화면에 표시되거나 바인딩될 수 있는 값들을 포함합니다.
```html
	<body>
        <h2>v-text 와 v-html 속성</h2>
		<hr>
		<div id="app">
			<p>{{ myText }}</p>   // 데이터 바인딩
			<p v-text="myText"></p> // 텍스트 지시자 
			<p v-html="myText"></p> // html 지시자
		</div>
        <script>
        const { createApp } = Vue // const { createApp } = Vue;: Vue 객체의 createApp 멤버를 구조 분해 할당하여 가져옵니다.
        createApp({  // createApp({ ... }): Vue 인스턴스를 생성합니다. data 옵션을 사용하여 데이터를 정의합니다.
            data() {  //data() { ... }: Vue 인스턴스의 데이터 옵션으로, message 속성을 정의하고 초기값을 설정합니다.
                return  {
					myText:'<h1>안녕? Vue!!!</h1>'
				}
            }
        }).mount('#app')  // a.mount('#app'): 생성한 Vue 인스턴스 a를 #app 엘리먼트에 마운트합니다.
        </script>
    </body>
```

### bind 문법
```html
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Vue.js sample</title>
	<link rel="stylesheet" href="style.css">
	<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
	<style>
		.atype {
			border: 1px solid red;
		}

		.btype {
			color: blue;
			font-weight: bold;
		}
	</style>
</head>

<body>
	<h2>HTML 태그의 속성에 Vue 객체의 데이터 바인딩</h2>
	<hr>
	<div id="app">
		<img v-bind:src="fileName"> //  v-bind 디렉티브를 사용하여 이미지 태그의 src 속성을 fileName 데이터와 바인딩합니다. 따라서 fileName 변수에 저장된 이미지 파일 경로가 실제 이미지로 출력됩니다.
		<hr>
		<a v-bind:href="myURL">링크를 v-bind로 지정</a> //  v-bind 디렉티브를 사용하여 앵커 태그(<a>)의 href 속성을 myURL 데이터와 바인딩합니다. 따라서 myURL 변수에 저장된 링크 주소가 실제 링크로 지정됩니다.
		<hr>
		<p v-bind:style="{textAlign:myAlign}">우측정렬을 v-bind 로 지정</p> // v-bind 디렉티브를 사용하여 문단 태그(<p>)의 스타일 속성을 myAlign 데이터와 바인딩합니다. myAlign 변수에 저장된 정렬 값에 따라 텍스트가 우측 정렬되도록 스타일이 적용됩니다.
		<hr>
		<p v-bind:style="{ color: myColor }">문자색을 v-bind로 지정</p> // v-bind 디렉티브를 사용하여 문단 태그(<p>)의 스타일 속성을 myColor 데이터와 바인딩합니다. myColor 변수에 저장된 색상 값에 따라 텍스트의 글자색이 변경됩니다.
		<p v-bind:style="{ fontSize: mySize }">글자크기를 v-bind로 지정</p> // v-bind 디렉티브를 사용하여 문단 태그(<p>)의 스타일 속성을 mySize 데이터와 바인딩합니다. mySize 변수에 저장된 크기 값에 따라 텍스트의 글자크기가 변경됩니다.
		<p v-bind:style="{ backgroundColor: myBackColor }">배경색을 v-bind로 지정</p> // v-bind 디렉티브를 사용하여 문단 태그(<p>)의 스타일 속성을 myBackColor 데이터와 바인딩합니다. myBackColor 변수에 저장된 배경색 값에 따라 텍스트의 배경색이 변경됩니다.
		<hr>
		<p v-bind:class="myClass">v-bind로 클래스 지정</p> // v-bind 디렉티브를 사용하여 문단 태그(<p>)의 클래스 속성을 myClass 데이터와 바인딩합니다. myClass 변수에 저장된 클래스명이 적용되어 해당 클래스의 스타일이 적용됩니다.
		<p v-bind:class="[myClass, darkClass]">v-bind로 복수의 클래스 지정</p> // v-bind 디렉티브를 사용하여 문단 태그(<p>)의 클래스 속성을 myClass와 darkClass 데이터와 바인딩합니다. myClass와 darkClass 변수에 저장된 클래스명이 함께 적용되어 해당 클래스들의 스타일이 적용됩니다.
		<p v-bind:class="{'atype': isON}">데이터로 클래스 ON/OFF</p> // v-bind 디렉티브를 사용하여 문단 태그(<p>)의 클래스 속성을 isON 데이터와 바인딩합니다. isON 변수의 값에 따라 atype 클래스가 동적으로 적용되거나 제거됩니다. isON이 true인 경우 atype 클래스가 적용되고, false인 경우 atype 클래스가 제거됩니다.
	</div>
	<script>
		const { createApp } = Vue
		createApp({
			data() {
				return {
					fileName: 'images/duke.png',
					myURL: 'https://v3-docs.vuejs-korea.org/',
					myAlign: 'right',
					myColor: '#E08000',
					mySize: '2em',
					myBackColor: 'aqua',
					myClass: 'atype',
					darkClass: 'btype',
					isON: false
				}
			}
		}).mount('#app')
	</script>
</body>

</html>
```

### computed 속성
```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Vue.js sample</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
</head>

<body>
    <h1>Date 객체 출력</h1>
    <hr>
    <div id="app">
        <h3>{{data1}}</h3>
        <h3>{{data2}}</h3>
        <h3>{{data3}}</h3>
        <h3>{{data4}}</h3>
    </div>
    <script>
        const { createApp } = Vue
        let now = new Date();
        createApp({
            data() {
                return {
                    data1: "둘리"
                }
            },
            computed: {     // computed 속성은 해당 속성의 값이 종속된 다른 데이터를 기반으로 동적으로 계산되며, 캐싱되어 변경되지 않는 한 이전에 계산된 결과를 반환합니다. 따라서 data2는 data1 속성의 값을 기반으로 문자열을 계산하여 반환합니다.
                data2() {
                    return this.data1 + " 입니다!"
                },
                data3() {
                    let randNum = Math.floor((Math.random() * 2 + 1));
                    if (randNum % 2)
                        return "홀수";
                    else
                        return "짝수";
                },
                data4() {
                    let now = new Date();
                    if (now.getHours() < 12)
                        return "오전";
                    else
                        return "오후";
                }
            }
        }).mount('#app')
    </script>
</body>

</html>
```

### v-model 문법
```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Vue.js sample</title>
		<link rel="stylesheet" href="style.css" >
		<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
	</head>
	<body>
        <h2>입력한 문자열 표시</h2>
		<div id="app">
			<input v-model="myName" placeholder="이름">  // v-model 디렉티브를 사용하여 myName 데이터와 양방향 데이터 바인딩이 설정되었습니다. 사용자가 입력한 값은 myName 데이터에 자동으로 업데이트됩니다. placeholder 속성은 input 요소에 힌트를 제공하는 텍스트를 설정합니다.
			<p>나는 {{ myName }} 입니다.</p>
		</div>
		<script>
        const { createApp } = Vue
        createApp({
            data() {
                return  {
					myName:''
				}
            }
        }).mount('#app')
        </script>
    </body>
</html>
```

### select 와 lazy
```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Vue.js sample</title>
		<link rel="stylesheet" href="style.css" >
		<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
	</head>
	<body>        
		<div id="app">
			<h2>이미지 출력을 라디오버튼으로 변경</h2>
			<label><input type="radio" value="images/docker.png" v-model="fileName">
				기술1</label><br>
			<label><input type="radio" value="images/kubernetes.png" v-model="fileName">
				기술2</label><br>
			<p>{{ fileName }} 선택<p>
			<img v-bind:src="fileName" width="100">
			<hr>
			<h2>문자열이 선택한 색으로 변경</h2>
			<select v-model="myColor1">
				<option disabled value="">색을 선택해 주세요</option>
				<option>red</option>
				<option>green</option>
				<option>blue</option>
				<option>orange</option>
				<option>brown</option>
			</select>
			<p v-bind:style="{color: myColor1}">선택한 색상은 {{ myColor1 }} 입니다. </p>
			<hr>
			<h2>복수의 선택을 배열로 처리</h2>
			<select v-model="myColor2" multiple style="width:150px">
				<option>red</option>
				<option>green</option>
				<option>blue</option>
				<option>orange</option>
				<option>brown</option>
			</select>
			<p>선택한 색은 {{ myColor2 }}　입니다.</p>
			<hr>
			<h2>모두 입력 후 표시</h2>
			<input v-model.lazy="myText" size="50"> // 포커스를 벗어나면 model 의 값이 변경됨
			<p>입력후 표시「{{ myText }}」</p>
		</div>
		<script>
        const { createApp } = Vue
        createApp({
            data() {
                return  {
					fileName:'',
					myColor1: '',
					myColor2: '',
					myText:'',
				}
            }
        }).mount('#app')
        </script>
    </body>
</html>
```

### input 타입과 trim
````html
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Vue.js sample</title>
	<link rel="stylesheet" href="style.css">
	<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
</head>

<body>
	<div id="app">
		<h2>number 타입 사용</h2>
		<input v-model="myNumber1" type="number"> // 숫자로 표시 <input v-model.number="myNumber1"> 도됨
		<p>10을 더해서 표시「{{ 10 + myNumber1 }}」</p>
		<p>100을 더해서 표시「{{ 100 + myNumber1 }}」</p>
		<p>1000을 더해서 표시「{{ 1000 + myNumber1 }}」</p>
		<hr>
		<h2>입력을 수식으로 변경</h2>
		<input v-model="myNumber2">
		<p>10을 더해서 표시「{{ 10 + myNumber2 }}」</p>
		<p>100을 더해서 표시「{{ 100 + myNumber2 }}」</p>
		<p>1000을 더해서 표시「{{ 1000 + myNumber2 }}」</p>
		<hr>
		<h2>앞뒤의 공백을 자동으로 제거(트림)</h2>
		<input v-model.trim="myText1">  // 공백이 없어짐
		<pre>앞뒤 공백을 제거「{{ myText1 }}」</pre>
		<hr>
		<h2>앞뒤의 공백을 자동으로 제거(트림) 안함</h2>
		<input v-model="myText2">
		<pre>앞뒤 공백을 제거「{{ myText2 }}」</pre>
	</div>
	<script>
		const { createApp } = Vue
		createApp({
			data() {
				return {
					myNumber1: 0,
					myNumber2: 0,
					myText1: '      ',
					myText2: '      ',
				}
			}
		}).mount('#app')
	</script>
</body>

</html>
````

### 이벤트 발생 v-on
```html
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Vue.js sample</title>
	<link rel="stylesheet" href="style.css">
	<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
</head>

<body>
	<h2>클릭하면 카운터가 올라갑니다.</h2>
	<div id="app">
		<p> {{count}}회</p>
		<button v-on:click="count++">카운터1</button>  // click 하면 count 라는 객체를 ++ 한다. 
		<button @click="countUp">카운터2</button> // @click 으로 간단히 표현 가능 전달하는것이 없으면 간단히 함수명만 쓸 수 있음
	</div>
	<script>
		const { createApp } = Vue
		createApp({
			data() {
				return {
					count: 0
				}
			},
			methods: {
				countUp: function () {
					this.count++;
				}
			}
		}).mount('#app')
	</script>
</body>

</html>
```

## 매개변수가 있는 메서드
```html
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Vue.js sample</title>
	<link rel="stylesheet" href="style.css">
	<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
</head>

<body>
	<div id="app">
		<h2>클릭하면 카운터 증가, 감소</h2>
		<p> {{count1}}회</p>
		<button @click="countUp">카운터 업!</button>
		<button @click="countDown">카운터 다운!</button>
		<hr>
		<h2>클릭하면 지정된 값만큼 증가</h2>
		<p>{{ count2 }}</p>
		<button @click="countUpWithValue(3)">3증가</button> // 매개변수의 값을 넘겨줄 수 있다.
		<button @click="countUpWithValue(10)">10증가</button>
		<button @click="countUpWithValue(100)">100증가</button>
	</div>
	<script>
		const { createApp } = Vue
		createApp({
			data() {
				return { count1: 0, count2: 0 }
			},
			methods: {
				countUp: function () {
					this.count1++;
				},
				countDown: function () {
					this.count1--;
				},
				countUpWithValue: function (value) {
					this.count2 += value;
				}
			}
		}).mount('#app')
	</script>
</body>

</html>
```

### 체크박스 상태에 따라 태그 제어
```html
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Vue.js sample</title>
	<link rel="stylesheet" href="style.css">
	<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
</head>

<body>
	<div id="app">
		<h2>true 일때만 표시하는 예제</h2>
		<label><input type="checkbox" v-model="myVisible1">표시</label> //v-model 은 태그에 따라 추가기능을 제공한다.
		<p v-if="myVisible1">체크박스가 ON</p>
		<hr>
		<h2>true 와 false 를 ON/OFF 로 표시하는 예제</h2>
		<label><input type="checkbox" v-model="myVisible2">표시</label> 
		<p v-if="myVisible2">체크박스 ON</p>
		<p v-else>체크박스 OFF</p>
		<hr>
		<h2>클릭하면 “좋아~” 버튼을 삭제하는 예제</h2>
		<button v-if="isShow" v-on:click="good">좋아~</button>
	</div>
	<script>
		const { createApp } = Vue
		createApp({
			data() {
				return {
					myVisible1: true,
					myVisible2: false,
					isShow: true
				}
			},
			methods: {
				good: function () {
					this.isShow = false
				}
			}
		}).mount('#app')
	</script>
</body>

</html>
```
### v-for 지시자
```html
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Vue.js sample</title>
	<link rel="stylesheet" href="style.css">
	<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
</head>
<body>
	<div id="app">
		<h2>배열 데이터를 리스트로 표시</h2>
		<ul>
			<li v-for="item in myArray">{{ item }}</li>
		</ul>
		<hr>
		<h2>오브젝트 배열 데이터를 리스트로 표시</h2>
		<ul>
			<li v-for="item in objArray">{{ item.name }} - {{ item.price }}</li>
		</ul>
		<hr>
		<h2>1x5 ~ 9x5 를 반복 표시</h2>
		<ul>
			<li v-for="n in 9"> {{n}}x5={{n * 5}}</li>
		</ul>
		<hr>
		<h2>배열 데이터를 번호가 붙어 있는 리스트로 표시</h2>
		<ul>
			<li v-for="(item, index) in myArray"> {{ index }}:{{ item }}</li>
		</ul>
	</div>
	<script>
		const { createApp } = Vue
		createApp({
			data() {
				return {
					myArray: ['둘리','또치','도우너'],
					objArray: [
						{name: '둘리', price: 1000},
						{name: '또치', price: 1200},
						{name: '도우너', price: 1500}
					]
				}
			}
		}).mount('#app')
	</script>
</body>
</html>
```