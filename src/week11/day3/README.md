# Spring Data JPA 
Spring Data JPA는 Spring 프레임워크와 Java Persistence API (JPA)를 결합한 데이터 액세스 기술입니다.
이를 사용하면 데이터베이스와의 상호작용을 단순화하고 편리하게 수행할 수 있습니다.


## Spring Data JPA 기능
Spring Data JPA는 JPA를 기반으로 하며, 데이터베이스에 접근하여 데이터를 조작하는 작업을 간소화하는 다양한 기능을 제공합니다

1. Repository 인터페이스 자동 구현: Spring Data JPA는 Repository 인터페이스의 구현을 자동으로 생성해줍니다. 개발자는 인터페이스에 정의된 메서드를 호출하여 데이터 액세스 작업을 수행할 수 있습니다.
2. 쿼리 메서드 자동 생성: Spring Data JPA는 메서드 이름을 기반으로 쿼리를 자동으로 생성해줍니다. 메서드 이름에서 일부 키워드를 사용하면 데이터베이스 쿼리를 작성하지 않고도 원하는 데이터를 조회할 수 있습니다.
3. 동적 쿼리 생성: Spring Data JPA는 Criteria API, QueryDSL 등을 사용하여 동적인 쿼리를 생성할 수 있는 기능을 제공합니다. 이를 통해 복잡한 검색 조건을 동적으로 처리할 수 있습니다.
4. 페이징 및 정렬: Spring Data JPA는 페이징 및 정렬을 지원하여 데이터의 일부분만 조회하거나 정렬된 결과를 얻을 수 있습니다.
5. 트랜잭션 관리: Spring Data JPA는 Spring의 트랜잭션 관리 기능을 활용하여 데이터 액세스 작업을 안전하게 처리합니다. 자동으로 트랜잭션을 시작하고 롤백 또는 커밋하는 등의 작업을 수행합니다.

## @Transactional
@Transactional 어노테이션을 사용하면 Spring Data JPA에서 트랜잭션 관리를 자동으로 처리해줍니다.
이를 통해 개발자는 트랜잭션을 명시적으로 시작하고 커밋 또는 롤백하는 등의 작업을 직접 처리할 필요가 없습니다.

@Transactional 어노테이션을 메서드 레벨 또는 클래스 레벨에 적용할 수 있으며, 해당 메서드 또는 클래스에서 수행되는 모든 데이터 액세스 작업은 단일 트랜잭션 내에서 실행됩니다.
이때 Spring Data JPA는 필요한 경우 엔티티 매니저를 생성하고 관리하여 데이터베이스와의 상호작용을 처리합니다.
따라서, @Transactional 어노테이션을 사용하면 Spring Data JPA가 트랜잭션 관리와 엔티티 매니저 생성 등의 작업을 자동으로 처리해주므로 개발자는 데이터베이스 액세스 작업에만 집중할 수 있습니다.

## @Transactional(readOnly=true)
@Transactional(readOnly = true)는 스프링의 트랜잭션 처리 설정 중 하나로, 해당 메서드 또는 클래스 내에서 수행되는 데이터 액세스 작업을 읽기 전용으로 설정하는 역할을 합니다. 
이 설정을 사용하면 해당 트랜잭션에서는 데이터를 수정하거나 변경하는 작업을 수행할 수 없고, 읽기 작업만 허용됩니다.
따라서, @Transactional(readOnly = true)을 사용하면 읽기 작업이 주를 이루는 메서드 또는 클래스에서 성능 향상과 동시성 제어를 위한 최적화를 할 수 있습니다.
단, 이 설정을 사용하는 경우 해당 트랜잭션 내에서는 데이터를 수정하거나 변경할 수 없으므로 주의해야 합니다.