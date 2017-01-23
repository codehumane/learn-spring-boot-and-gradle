# learn-spring-boot-and-gradle

Spring Boot와 Gradle을 이용하여 간단한 어플리케이션을 작성합니다.

- 부모/자식 구조로 `build.gradle` 구성
- 피처<sup>Feature</sup> 우선 패키지 구성
- 피처 안에는 기술 기반 레이어 패키지 구성
- 피처 별 공통 코드는 `common` 패키지에 위치
- 어플리케이션 실행 시 간단한 `Item` 집합 영속 (`@PostConstruct` 이용. `CommandLineRunner` 사용 X)
- 페이징을 지원하는 간단한 `Item Controller` 작성
