# Rest 란?
REST는 "REpresentational State Transfer"의 약어로, 하나의 URI는
하나의 고유한 리소스(Resource)를 대표하도록 설계된다는 개념이다.
즉, 자원을 이름으로 구분하여 해당 자원의 상태(정보)를 주고받는 모든 것을 의미한다.

## Rest 특징
1. 리소스 지향 (Resource-Oriented): 모든 자원은 고유한 식별자(URI)를 가지며, 클라이언트는 이를 통해 자원을 식별합니다. 리소스는 웹에서의 문서, 이미지, 데이터베이스 레코드 등 다양한 형태일 수 있습니다.
2. 상태 없음 (Stateless): 서버는 클라이언트의 상태를 관리하지 않으며, 각 요청은 완전한 정보를 포함하고 있어야 합니다. 이를 통해 서버의 확장성이 개선되고, 클라이언트와 서버 간의 의존성이 낮아집니다.
3. 통일된 인터페이스 (Uniform Interface): REST는 일관된 인터페이스 규칙을 따릅니다. 이를 통해 서버와 클라이언트 간의 상호작용을 단순화하고, 서비스의 가시성과 이해성을 향상시킵니다. 주요 요소로는 리소스 식별자, 메서드, 표현 방식, 하이퍼미디어 제어 등이 있습니다.
4. 자체 표현 (Self-Descriptive): 각 요청은 자신을 설명하는 메타데이터(헤더)를 포함해야 합니다. 이를 통해 클라이언트는 서버의 상태나 기능을 파악하고, 적절한 조치를 취할 수 있습니다.
5. 계층화 (Layered System): REST 아키텍처는 클라이언트와 서버 사이에 중간 계층(로드 밸런서, 캐시 등)을 포함할 수 있습니다. 이를 통해 시스템의 구조를 유연하게 설계하고, 확장성과 보안성을 개선할 수 있습니다.

## Rest API 설계 규칙
1. 명사 기반의 리소스 식별자 사용: API 엔드포인트는 리소스를 나타내는 명사로 구성되어야 합니다. 예를 들어, /users는 사용자 리소스에 대한 엔드포인트를 나타냅니다.
2. HTTP 메서드 활용: HTTP 메서드(GET, POST, PUT, DELETE 등)를 적절하게 활용하여 리소스에 대한 작업을 표현합니다. 예를 들어, GET 메서드는 리소스를 조회할 때, POST 메서드는 리소스를 생성할 때 사용됩니다.
3. 명확하고 일관된 경로 구조: API의 경로 구조는 일관성을 유지해야 합니다. 관련 리소스 간에 일관된 경로 패턴을 사용하고, 계층 구조를 활용하여 관계를 표현할 수 있습니다. 예를 들어, /users/{id}/orders는 특정 사용자의 주문 목록을 나타냅니다.
4. 요청과 응답에 JSON 형식 활용: 데이터 교환 형식으로 JSON을 사용하는 것이 일반적입니다. 클라이언트에서는 JSON 형식으로 요청을 보내고, 서버는 JSON 형식으로 응답을 반환합니다.
5. 필터링, 정렬, 페이징 기능 제공: 대용량 데이터를 다룰 때는 필터링, 정렬, 페이징과 같은 기능을 제공하여 클라이언트가 필요한 데이터를 효율적으로 조회할 수 있도록 합니다. 이를 위해 쿼리 매개변수나 헤더를 활용할 수 있습니다.
6. 오류 처리: 오류 발생 시 적절한 HTTP 상태 코드와 함께 오류 메시지를 반환해야 합니다. 일반적으로 4xx 상태 코드는 클라이언트 오류를 나타내고, 5xx 상태 코드는 서버 오류를 나타냅니다.
7. 보안 고려: API 보안을 위해 HTTPS를 사용하고, 인증과 권한 부여를 구현해야 합니다. 중요한 데이터에 대한 접근 제어를 위해 API 토큰이나 OAuth와 같은 인증 방식을 활용할 수 있습니다.
8. 버전 관리: API의 변경을 관리하기 위해 버전 관리를 고려해야 합니다. 새로운 기능 추가나 기존 기능 변경 시, 호환성을 유지하기 위해 버전 번호를 업데이트하거나, URL 경로에 버전 정보를 포함시킬 수 있습니다.

## 설계 예시
user 에 관한 REST API 설계 예시

1. 모든 사용자 조회 (GET /users):
```java
@GetMapping("/users")
public List<User> getAllUsers() {
    // 사용자 목록을 조회하는 로직
    List<User> users = userService.getAllUsers();
    return users;
}

```
2. 특정 사용자 조회 (GET /users/{id}):
````java
@GetMapping("/users/{id}")
public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
    // 특정 사용자 조회하는 로직
    User user = userService.getUserById(userId);
    
    if (user != null) {
        return ResponseEntity.ok(user);
    } else {
        return ResponseEntity.notFound().build();
    }
}
````

3. 새로운 사용자 생성 (POST /users):
````java
@PostMapping("/users")
public ResponseEntity<User> createUser(@RequestBody User newUser) {
    // 새로운 사용자 생성하는 로직
    User createdUser = userService.createUser(newUser);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
}

````
4. 기존 사용자 수정 (PUT /users/{id}):
````java
@PutMapping("/users/{id}")
public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User updatedUser) {
    // 기존 사용자를 수정하는 로직
    User modifiedUser = userService.updateUser(userId, updatedUser);
    
    if (modifiedUser != null) {
        return ResponseEntity.ok(modifiedUser);
    } else {
        return ResponseEntity.notFound().build();
    }
}

````
5. 특정 사용자 삭제 (DELETE /users/{id}):
````java
@DeleteMapping("/users/{id}")
public ResponseEntity<Void> deleteUser(@PathVariable("id") Long userId) {
    // 특정 사용자를 삭제하는 로직
    boolean deleted = userService.deleteUser(userId);
    
    if (deleted) {
        return ResponseEntity.noContent().build();
    } else {
        return ResponseEntity.notFound().build();
    }
}

````