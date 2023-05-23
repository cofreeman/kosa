# HATEOAS
HATEOAS(Hypermedia as the Engine of Application State)는 웹 API의 설계 원칙 중 하나입니다.
HATEOAS는 REST 아키텍처 스타일을 따르는 API를 개발할 때 사용되며, API의 자체 문서화와 클라이언트와 서버 간의 상호작용을 향상시키는 방법을 제공합니다.

HATEOAS는 Hypermedia 링크를 통해 리소스 간의 관계와 상태 변화를 전달합니다. 
API의 응답에는 현재 리소스와 관련된 하이퍼링크가 포함되어 있으며, 클라이언트는 이러한 링크를 따라가며 원하는 동작을 수행할 수 있습니다.
이를 통해 클라이언트는 서버의 상태 변화에 따라 동적으로 API를 탐색하고 상호작용할 수 있습니다.

HATEOAS를 사용하면 클라이언트가 API의 상태 전이를 사전에 알고 있을 필요가 없습니다.
클라이언트는 현재 리소스와 관련된 링크를 사용하여 동적으로 리소스를 찾고, 해당 리소스에서 사용 가능한 작업을 수행할 수 있습니다.
이는 API의 확장성과 유연성을 높여주며, 클라이언트와 서버 간의 결합도를 낮출 수 있습니다.

HATEOAS는 RESTful API의 자기서술적 특성을 강화하고, API의 디자인과 개발을 단순화시킬 수 있는 강력한 도구입니다.
이를 통해 클라이언트와 서버 간의 상호작용을 효과적으로 관리하고, API의 변경에 유연하게 대응할 수 있습니다.

## Hateoas 예시
```json
{
  "id": 1,
  "name": "John",
  "age": 30,
  "links": [
    {
      "rel": "self",
      "href": "http://api.example.com/users/1"
    },
    {
      "rel": "update",
      "href": "http://api.example.com/users/1",
      "method": "PUT"
    },
    {
      "rel": "delete",
      "href": "http://api.example.com/users/1",
      "method": "DELETE"
    }
  ]
}

```

위의 예시에서는 사용자 정보를 나타내는 JSON 응답에 HATEOAS 링크가 포함되어 있습니다. 
각 링크는 rel과 href 속성을 가지며, rel은 링크의 관계를 나타내고 href는 링크의 주소를 나타냅니다. 
이를 통해 클라이언트는 링크를 따라가며 추가 동작을 수행할 수 있습니다.

예를 들어, "self" 링크를 따라가면 해당 사용자의 세부 정보를 조회할 수 있습니다. 
"update" 링크를 따라가면 사용자 정보를 수정하는 PUT 요청을 보낼 수 있고, "delete" 링크를 따라가면 사용자를 삭제하는 DELETE 요청을 보낼 수 있습니다. 
이렇게 HATEOAS를 사용하면 클라이언트는 API의 동작을 링크를 통해 탐색하고, 서버의 상태에 따라 동적으로 상호작용할 수 있게 됩니다.

## controller 에서 Hateoas 로 보낸 json 파일을 vue 에서 매핑하는 예시
```html
<template>
  <div>
    <h2>User Details</h2>
    <p>Name: {{ user.name }}</p>
    <p>Age: {{ user.age }}</p>
    <ul>
      <li v-for="link in user.links" :key="link.rel">
        <a :href="link.href" :method="link.method" @click="followLink(link)">{{ link.rel }}</a>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      user: {},
    };
  },
  mounted() {
    this.fetchUser();
  },
  methods: {
    fetchUser() {
      axios.get("http://api.example.com/users/1")
        .then(response => {
          this.user = response.data;
        })
        .catch(error => {
          console.error("Error fetching user:", error);
        });
    },
    followLink(link) {
      if (link.method === "PUT") {
        // Perform update logic
        console.log("Performing update for user:", this.user.id);
      } else if (link.method === "DELETE") {
        // Perform delete logic
        console.log("Performing delete for user:", this.user.id);
      } else {
        // Other link handling logic
        console.log("Following link:", link);
      }
    },
  },
};
</script>

```