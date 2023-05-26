# Vue 라우터
```html
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Vue.js</title>
  <style>
    .router-link-exact-active {
      color: red;
    }
  </style>
  <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
  <script src="https://unpkg.com/vue-router@4"></script>
</head>

<body>
  <div id="app">
    <h1>{{abc}}</h1>
    <p>
<!--      a 태그로 변경된다.-->
      <router-link to="/one">라우터1</router-link>   
      <hr>
      <router-link to="/two">라우터2</router-link>
      <hr>
      <router-link to="/three">라우터3</router-link>
      <hr>
      <router-link to="/four">라우터4</router-link>
    </p>
    <!-- 현재 라우트에 맞는 컴포넌트가 렌더링 -->
    <router-view></router-view>
  </div>
  <script>
    //const { createApp } = Vue;
    //const { createRouter, createWebHashHistory } = VueRouter;

    // 라우트 컴포넌트
    const Comp1 = {
      template: "<h2>자바 게시판</h2>",
    };
    const Comp2 = {
      template: "<h2>스프링 게시판</h2>",
    };
    const Comp3 = {
      template: "<h2>JPA 게시판</h2>",
    };
    const Comp4 = {
      template: "<h2>VUE 게시판</h2>",
    };

    // 라우터 객체 생성
    const router = VueRouter.createRouter({
      history: VueRouter.createWebHashHistory(),
      routes: [
        {
          path: "/one",
          component: Comp1,
        },
        {
          path: "/two",
          component: Comp2,
        },
        {
          path: "/three",
          component: Comp3,
        },
        {
          path: "/four",
          component: Comp4,
        },
      ],
    });

    Vue.createApp({
      data() {
        return {
          abc: "라우트 학습-1"
        }
      }
    }).use(router).mount('#app');

  </script>
</body>

</html>
```

# composition API option API
```html
<template>
  <div>
    {{ date1 }}
  </div>
  <div>
    {{ date2 }}
  </div>
  </template>

<script>
export default {
  // Composition API
  setup() {
    const date1 = Date().toString()
    return {
      date1,
    }
  },

  // Option API
  data() {
    return {
      date2: Date().toString(),
    }
  },
}
</script>
```

# <script setup>: Vue 3에서 도입된 <script setup> 구문을 사용하여 스크립트 영역을 설정합니다.
`````html
<template>
  <h2>그동안 뭐 한거지? ㅎㅎ</h2>
  <div>
     {{ date3 }}
  </div>
</template>

<script setup>
   const date3 = Date().toString()
</script>
`````

# reactive ref
reactive: reactive는 Vue 3에서 사용되는 객체를 리액티브하게 만들기 위한 함수입니다. 
일반적으로 JavaScript 객체를 reactive 함수로 감싸면, 해당 객체의 프로퍼티가 변경될 때 자동으로 감지되고, 이에 따라 연결된 UI가 업데이트됩니다.
즉, 객체의 프로퍼티가 변경되면 해당 변경 사항이 반영되어 화면이 자동으로 갱신됩니다.
````html
<template>
  <div>
    <div class="name">{{ name }}</div>
    <div class="name">{{ name.lastName }}</div>
    <div class="name">{{ name.firstName }}</div>
    <button @click="updateName">Click</button>
  </div>
</template>

<script>
import { reactive } from "vue";

export default {
  setup() {
    const name = reactive({
      firstName:"길동", lastName:"고"
    });

    const updateName = () => {
      name.firstName = "둘리";
      name.lastName = "김"
    };
    return {
      name,
      updateName,
    };
  },
};
</script>

<style>
    .name {
      color : magenta;
    }
</style>
````
ref: ref는 단일 값이나 원시 타입을 리액티브하게 만들기 위한 함수입니다.
ref 함수로 값을 감싸면 해당 값이 변경될 때 자동으로 감지되고, UI가 업데이트됩니다.
ref 함수로 감싼 값은 .value 속성을 통해 실제 값을 접근해야 합니다.
`````html
<template>
	<div>
		<button @click="increment()">Counter: {{ counter }}</button>
	</div>
</template>

<script>
import { onMounted, ref } from 'vue';

export default {
	setup() {
		const counter = ref(0);
		const increment = () => counter.value++;
		onMounted(() => {
			console.log('애플리케이션이 마운트 되었습니다!');
		});
		return {
			counter,
			increment,
		};
	},
};
</script>
`````

# : -> bind 생략
```html
<template>
  <div>
  <p>
    <span :title="message">
      마우스를 올려 놓으면 잠시후 "둘리도우너또치"라는 툴팁이 출력됩니다.
    </span>
  </p>
  <p :class="{ red: isRed }" @click="toggleRed">
    빨간색 백그라운드 칼라가 토글~~~
  </p>

  <!-- style bindings also support object and arrays -->
  <p :style="{ color }" @click="toggleColor">
    클릭할 때마다 그린과 블루가 토글~~~
  </p>
</div>
</template>

<script>
import { ref } from 'vue'

export default {
  setup() {
    const message = ref('둘리또치도우너')
    const isRed = ref(true)
    const color = ref('green')

    function toggleRed() {
      isRed.value = !isRed.value
    }

    function toggleColor() {
      color.value = color.value === 'green' ? 'blue' : 'green'
    }

    return {
      message,
      isRed,
      color,
      toggleRed,
      toggleColor
    }
  }
}
</script>

<style>
  .red {
    background-color : red;
  }
</style>
```

# watch
```html
<template>
  메인보드의 가격: <input type="text" v-on:input="price = $event.target.value" v-bind:value="price">
</template> 

<script>
import { ref, watch } from 'vue'

export default {
  setup() {
    const price = ref(112053)

    watch(price, (cur, prev) => {
        console.log('price의 변경된 값 :', cur)
        console.log('price의 변경되기 전의 값 :', prev)
      },
      {
        immediate: true,
      }
    )

    return {
      price,
    }
  },
}
</script>

```