# ResponseEntity
Spring Framework에서 제공하는 클래스로, HTTP 응답을 나타냅니다. 
REST API에서 클라이언트에게 반환되는 응답을 생성하고 제어하는 데 사용됩니다.

ResponseEntity는 응답의 상태 코드, 헤더 및 본문을 설정할 수 있는 강력한 기능을 제공합니다.
일반적으로 HTTP 응답의 상태 코드와 데이터를 함께 반환하는 데 사용됩니다. 

## ResponseEntity 주요 메서드와 사용법

ok(): HTTP 상태 코드 200 OK와 함께 응답을 생성합니다.
```java
return ResponseEntity.ok(user);
```
status(HttpStatus status): 지정된 HTTP 상태 코드와 함께 응답을 생성합니다.
```java
return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
```
body(T body): 응답 본문에 데이터를 설정합니다.
```java
return ResponseEntity.ok(user);
```
notFound(): HTTP 상태 코드 404 Not Found와 함께 응답을 생성합니다.
```java
return ResponseEntity.notFound().build();
```
noContent(): HTTP 상태 코드 204 No Content와 함께 응답을 생성합니다. 본문 데이터는 없습니다.
```java
return ResponseEntity.noContent().build();
```
header(String name, String value): 응답 헤더에 특정 헤더 값을 설정합니다.
```java
return ResponseEntity.ok().header("Custom-Header", "Value").body(user);
```

## ResponseEntity 를 활용한 페이징 예시
```java
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size) {
        Page<User> userPage = userService.getUsersPage(page, size); // 사용자 데이터를 페이징하여 가져오는 서비스 메서드 호출

        List<User> users = userPage.getContent(); // 페이징된 사용자 데이터
        int totalPages = userPage.getTotalPages(); // 전체 페이지 수
        long totalElements = userPage.getTotalElements(); // 전체 항목 수

        // ResponseEntity를 사용하여 응답을 구성
        return ResponseEntity.ok()
                .header("X-Total-Pages", String.valueOf(totalPages))
                .header("X-Total-Elements", String.valueOf(totalElements))
                .body(users);
    }
}

```

````html
<template>
  <div>
    <!-- 사용자 목록 표시 -->
    <ul>
      <li v-for="user in users" :key="user.id">
        {{ user.name }}
      </li>
    </ul>

    <!-- 페이지네이션 -->
    <div>
      <button @click="prevPage" :disabled="currentPage === 0">이전</button>
      <span>{{ currentPage + 1 }} / {{ totalPages }}</span>
      <button @click="nextPage" :disabled="currentPage === totalPages - 1">다음</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      users: [], // 사용자 목록
      currentPage: 0, // 현재 페이지
      totalPages: 0, // 전체 페이지 수
    };
  },
  mounted() {
    this.getUsers();
  },
  methods: {
    getUsers() {
      const page = this.currentPage;
      const size = 10; // 페이지 크기

      // API 호출
      axios.get(`/api/users?page=${page}&size=${size}`)
        .then(response => {
          this.users = response.data; // 사용자 목록 업데이트
          this.totalPages = Number(response.headers['x-total-pages']); // 전체 페이지 수 업데이트
        })
        .catch(error => {
          console.error(error);
        });
    },
    prevPage() {
      if (this.currentPage > 0) {
        this.currentPage--;
        this.getUsers();
      }
    },
    nextPage() {
      if (this.currentPage < this.totalPages - 1) {
        this.currentPage++;
        this.getUsers();
      }
    },
  },
};
</script>

````