# Array
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
		<h2>버튼으로 리스트에 추가/삭제</h2>
		<ul>
			<li v-for="item in myArray1"> {{ item }}</li>
		</ul>
		<hr>
		<button v-on:click="addLast">맨 뒤에 추가</button>
		<button v-on:click="addObj(3)">네번째에 추가</button>
		<button v-on:click="changeObj(0)">첫번째를 변경</button>
		<button v-on:click="deleteObj(1)">두번째를 삭제</button>
		<hr>
		<h2>버튼을 클릭하면 소트</h2>
		<ul>
			<li v-for="item in myArray2"> {{ item }}</li>
		</ul>
		<button v-on:click="sortData(myArray2)">소트</button><br>
		<hr>
		<h2>짝수만 표시</h2>
		<ul>
			<div v-for="item in myArray3">
				<li v-if="item % 2 == 0"> {{ item }}</li>
			</div>
		</ul>
		<ul>
			<li v-for="item in evenArray"> {{ item }}</li>
		</ul>
		<hr>
		<h2>버튼을 클릭하면 짝수만 표시</h2>
		<ul>
			<li v-for="item in myArray4">{{ item }}</li>
		</ul>
		<button v-on:click="evenData()">짝수만 표시</button><br>
	</div>
	<script>
		const { createApp } = Vue
		createApp({
			data() {
				return {
					myArray1: ['첫번째', '두번째', '세번째', '네번째', '다섯번째'],
					myArray2: ['one', 'two', 'three', 'four', 'five'],
					myArray3: [1, 2, 3, 4, 5, 6, 7, 8],
					myArray4: [1, 2, 3, 4, 5, 6]
				}
			},
			computed: {
				evenArray() {
					let evenA = [];
					this.myArray3.forEach(elem => {
						if (elem % 2 == 0)
							evenA.push(elem);
					});
					return evenA;
				}
			},
			methods: {
				addLast: function () {
					this.myArray1.push("［맨 뒤에 추가］");
				},
				addObj: function (index) {
					this.myArray1.splice(index, 0, '［추가］') 
				},
				changeObj: function (index) {
					this.myArray1.splice(index, 1, '［변경］')
				},
				deleteObj: function (index) {
					this.myArray1.splice(index, 1);
				},
				sortData: function (listdata) {
					listdata.sort();
				},
				evenData: function () {
					this.myArray4 = this.myArray4.filter(
						function (value) { return value % 2 == 0; }
					);
				}
			}
		}).mount('#app')
	</script>
</body>

</html>
```

# watch
```html
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Vue.js sample</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/1.19.1/TweenMax.min.js"></script>
</head>

<body>
    <div id="app">
        <h2>입력문자를 감시하여 금지문자가 입력 되면 경고창 띄우기</h2>
        <p>금지문자 :「{{ forbiddenText }}」</p>
        <textarea v-model="inputText"></textarea>
        <hr>
        <h2>남은 시간(초)를 감시하여 표시하고 0초가 되면 경고창 띄우기</h2>
        <p>앞으로 {{ restSec }}초<br>
            <button v-on:click="startTimer">START</button>
            <hr>
        <h2>숫자가 빠르게 올라가는 애니메이션을 보여주며 값이 증가하는 input 태그</h2>
        <p>값은 {{ animeNumber }}입니다.</p>
        <input v-model="myNumber" type="number">
    </div>
    <script>
        const { createApp } = Vue
        let now = new Date();
        createApp({
            data() {
                return {
                    forbiddenText: '고길동',
                    inputText: '오늘은 날씨가 좋습니다.',
                    restSec: 5,
                    timerObj: null,
                    myNumber: 0,
                    tweenedNumber: 0
                }
            },
            methods: {
                startTimer: function () {
                    // 남은시간 5초
                    this.restSec = 5;
                    // 타이머를 스타트, 1초(1000미리초)에 1씩 감소
                    this.timerObj = setInterval(() => { this.restSec-- }, 1000)
                }
            },
            watch: { // 
                // 입력한 문자열을 감시한다.
                inputText: function () {
                    //console.log(this.forbiddenText);
                    var pos = this.inputText.indexOf(this.forbiddenText);
                    if (pos >= 0) {
                        alert(this.forbiddenText + "는 입력할 수 없습니다.");
                        // 입력문자에서 금지 문자를 삭제한다.
                        this.inputText = this.inputText.substr(0, pos);
                    }
                },
                restSec: function () {
                    // 0초 이하가 되면 얼럿을 띄우고 타이머를 멈춘다.
                    if (this.restSec <= 0) {
                        alert("제한시간 입니다.");
                        clearInterval(this.timerObj);
                    }
                },
                myNumber: function () {
                    // data의 tweenedNumber 프로퍼티를 1초에 myNumber까지 증가시킨다.
                    console.log("W" + this.myNumber);
                    TweenMax.to(this.$data, 1, { tweenedNumber: this.myNumber })
                }
            },
            computed: {
                // tweenedNumber 값이 변경되는 변화중 애니메이션을 산출한다.
                animeNumber: function () {
                    console.log("C" + this.tweenedNumber.toFixed(0));
                    return this.tweenedNumber.toFixed(0);
                }
            }
        }).mount('#app')
    </script>
</body>

</html>
```
# v-if, v-if-else
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
		<p v-if="isDisplay">v-if : 개발자 도구에서 엘리먼트 정보 확인</p>
		<p v-show="isDisplay">v-show : 개발자 도구에서 엘리먼트 정보 확인</p>
		<hr>
		<button @click="isDisplay =  !isDisplay">클릭</button>
		<hr>
		<input type="text" v-model="friendName" />
		<h3 v-if="friendName === '둘리'">고길동</h3>
		<h3 v-else-if="friendName === '올라프'">안나</h3>
		<h3 v-else-if="friendName === '짱구'">흰둥이</h3>
		<h3 v-else>앤</h3>
	</div>
	<script>
		Vue.createApp({
			data() {
				return {
					isDisplay: true,
					friendName: '둘리'
				}
			}
		}).mount('#app')
	</script>
</body>

</html>
```
# v-watch
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
    <h1>watch 뽀개기</h1>
    <div id="app">
        <button @click="updateStr">문자열 변경</button>
        {{someStr}}
        <hr>
        <button @click="updateNum">숫자 변경</button>
        {{someNum}}
        <hr>
        <button @click="updateObj1">객체 변경</button>
        {{someObj}}
        <hr>
        <button @click="updateObj2">객체 내용 변경</button>
        {{someObj}}
        <hr>
    </div>
    <script>
      Vue.createApp({
        data() {
          return {
              someStr : "가나다",
              someNum : 100,
              someObj: {
                a: 'obj-a',
                b: 'obj-b',
                c: 'obj-c'
              }
          }
        },
        watch: {
            someStr: {
              handler: function (val, oldVal) {
                 console.log(`[someStr] ${val}-${oldVal}`)
              }
            }, 
            someNum: {
              handler: function (val, oldVal) {
                 console.log(`[someNum] ${val}-${oldVal}`)
              }
            }, 
            someObj: {
              handler: function (val, oldVal) {
                 console.log(`[someObj] ${val}-${oldVal}`)
              },              
            },    
            // 속성을 변경하고 싶어
            'someObj.a' : {  
              handler: function (val, oldVal) {
                 console.log(`[someObj.a] ${val}-${oldVal}`)
              },              
            },        
        },
        methods: {
            updateStr : function() {
              this.someStr += "ㅋ";
            },
            updateNum : function() {
              this.someNum++;
            },
            updateObj1 : function() {
              this.someObj = { };
            },
            updateObj2 : function() {
              this.someObj.a += 'ㅋ';
            },
        }
      }).mount('#app')
    </script>
</body>

</html>
````

# axios,v-html
`````html
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>ECMAScript6</title>
  <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

</head>

<body>
  <h1> AJAX 기술로 REST API 요청(CORS)</h1>
  <hr>
  <div id="app">
    <button @click="getAll">GET(ALL)</button>
    <button @click="getOne()">GET(One)</button>
    <button @click="postData()">POST</button>
    <button @click="deleteData()">DELETE</button>
    <hr>
    <div v-html="result"></div>
  </div>

  <script>
    const { createApp } = Vue
    createApp({
      data() {
        return {
          result: ''
        }
      },
      methods: {
        getAll: function () {
          axios.get("http://localhost:8088/boards")
            .then(response => {
              console.log(response);
              return response.data;
            }).
            then(boards => {
              console.log(boards);
              let str = "";
              for (let elem of boards) {
                console.log(elem);
                str += `<h3>${elem.boardNo}. ${elem.title}  ${elem.content}</h3>`;
              }
              this.result = str;
            })
            .catch(err => console.error(err));
        },
        getOne: function () {
          axios.get("http://localhost:8088/boards/1")
            .then(response => {
              console.log(response);
              return response.data;
            }).
            then(board => {
              console.log(board);
              this.result = `<h3>${board.boardNo}. ${board.title}  ${board.content}</h3>`;
            })
            .catch(err => console.error(err));
        },
        postData: function () {
          let payload = {
            boardNo: 5,
            title: '꽃잎 한 장처럼',
            content: '수도생활 50년, 좋은 삶과 관계를 위한 통찰',
            writer: '이해인',
            regDate: '2020-05-25T09:00'
          };
          axios.post("http://localhost:8088/boards", payload)
            .then(response => {
              console.log(response);
              return response.data;
            }).
            then(msg => {
              console.log(msg);
              this.result = `<h3>${msg}</h3>`;
            })
            .catch(err => console.error(err));
        },
        deleteData: function () {
          axios.delete("http://localhost:8088/boards/5")
            .then(response => {
              console.log(response);
              return response.data;
            }).
            then(msg => {
              console.log(msg);
              this.result = `<h3>${msg}</h3>`;
            })
            .catch(err => console.error(err));
        }
      }
    }).mount('#app')    
  </script>
</body>

</html>
`````

# Component
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
	<h2>컴포넌트를 만들어서 표시</h2>
	<div id="app">
		<my-comp-tag1></my-comp-tag1>
		<my-comp-tag2></my-comp-tag2>
		<my-comp-tag3></my-comp-tag3>
		<hr>
		<my-comp-tag1></my-comp-tag1>
	</div>
	<script>
		const { createApp } = Vue;

		const MyComponent1 = {
			template: '<p class="my-comp">안녕? 둘리~~</p>'
		}
		const MyComponent2 = {
			template: '<p class="my-comp">안녕? 도우너~~</p>'
		}
		const MyComponent3 = {
			template: '<p class="my-comp">안녕? 또치~~</p>'
		}
		createApp({
			components: {
				'my-comp-tag1': MyComponent1,
				'my-comp-tag2': MyComponent2,
				'my-comp-tag3': MyComponent3,
			}
		}).mount('#app');
	</script>
	<style>
		.my-comp {
			width: 300px;
			background-color: #ffffe0;
			border: solid;
			border-color: darkorange;
			border-radius: 8px;
			padding: 8px;
		}
	</style>
</body>

</html>
````